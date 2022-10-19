package org.example;


import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        List<Person> listadoPersonas = lecturaFichero("block1-process-file-and-streams/people.csv");
        List<Person> listadoMenores25 = menores25(listadoPersonas);
        List<Person> noEmpiezaPorA = noEmpiezaPorA(listadoPersonas);
        Optional<Person> primeroConCiudadMadrid = primeroConCiudad(listadoMenores25, "Madrid");
        Optional<Person> primeroConCiudadBarcelona = primeroConCiudad(listadoMenores25, "Barcelona");

            System.out.println("Listado de personas: ");
        for (Person persona : listadoPersonas) {
            System.out.println(" Name: " + persona.getName() + " Town: " + persona.getTown() + " Age: " + persona.getAge());
        }
            System.out.println("");
            System.out.println("Listado de personas menores de 25: ");
        for (Person persona : listadoMenores25) {
            System.out.println(" Name: " + persona.getName() + " Town: " + persona.getTown() + " Age: " + persona.getAge());
        }
            System.out.println("");
            System.out.println("Listado de personas cuyo nombre no empieza por A: ");
        for (Person persona : noEmpiezaPorA) {
            System.out.println(" Name: " + persona.getName() + " Town: " + persona.getTown() + " Age: " + persona.getAge());
        }

        if(primeroConCiudadMadrid.isPresent()) {
            System.out.println("");
            System.out.println("Primera persona menor de 25 y su ciudad es Madrid: ");
            System.out.println(" Name: " + primeroConCiudadMadrid.get().getName() + " Town: " + primeroConCiudadMadrid.get().getTown() + " Age: " + primeroConCiudadMadrid.get().getAge());
        }
        if(primeroConCiudadBarcelona.isPresent()) {
            System.out.println("");
            System.out.println("Primera persona menor de 25 y su ciudad es Barcelona: ");
            System.out.println(" Name: " + primeroConCiudadBarcelona.get().getName() + " Town: " + primeroConCiudadBarcelona.get().getTown() + " Age: " + primeroConCiudadBarcelona.get().getAge());
        }
    }


    public static List<Person> lecturaFichero(String path) throws IOException {
        List<Person> listadoPersonas = new ArrayList<Person>();

        List<String> datosDocumento = Files.readAllLines(Path.of(path));

        for (String filaDocumento : datosDocumento) {
            String[] persona = filaDocumento.split(":");

            if (persona.length == 2) {

                listadoPersonas.add(new Person(persona[0], persona[1], 0));

            } else {

                if (persona[1].length() == 0) {
                    listadoPersonas.add(new Person(persona[0], "Unknown", Integer.parseInt(persona[2])));
                } else {
                    listadoPersonas.add(new Person(persona[0], persona[1], Integer.parseInt(persona[2])));
                }
            }


        }
        return listadoPersonas;

    }
    public static List<Person> menores25(List<Person> listadoPersonas){

        List<Person> listadoMenores25= new ArrayList<>();

        Stream<Person> stream = listadoPersonas.stream();

       stream.filter(persona -> persona.getAge()<25 && persona.getAge()>0)
                .forEach(listadoMenores25::add);


        return listadoMenores25;
    }
    public static List<Person> noEmpiezaPorA(List<Person> listadoPersonas){
        List<Person> noEmpiezaPorA = new ArrayList<>();

        Stream<Person> stream = listadoPersonas.stream();

        stream.filter(persona -> !persona.getName().startsWith("A")).forEach(noEmpiezaPorA::add);

        return noEmpiezaPorA;

    }

        public static Optional<Person> primeroConCiudad(List<Person> lp, String ciudadSolicitada){

        Stream<Person> stream = lp.stream();

        Optional<Person> ciudadPersona = stream.filter(p -> p.getTown().equals(ciudadSolicitada)).findFirst();

        return ciudadPersona;

    }

}
