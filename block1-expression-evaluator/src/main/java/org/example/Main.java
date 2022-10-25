package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String ruta = "expresiones.csv";
        Scanner sc = new Scanner(new File(ruta));

        while (sc.hasNext()) {
            String fila = sc.nextLine();
            System.out.println(comprobarExpresiones(fila));
        }
        sc.close();
    }




public static String comprobarExpresiones(String linea) throws ParseException {
        String[] datos = linea.split(" ");
        String tipoDatos = "";
        for(String dato:datos){
            if(dato.contains("\"")){
                tipoDatos = "string";
            }
            else{
                tipoDatos = "num";
            }
            //else{
            //    tipoDatos = "date";
            //}
        }
        return linea + ": " + ejecutarExpresion(datos, tipoDatos);
    }

    public static String ejecutarExpresion(String[] linea, String tipoDatos) throws ParseException {
        String resultado = linea[0].replace("\"","");

        if(tipoDatos.equals("string")){
            for (int i =0 ; i < linea.length; i++){

            }
        }
        if(tipoDatos.equals("num")){
            for (int i =0 ; i < linea.length; i++){

            }
        }
        if(tipoDatos.equals("date")){
            for (int i =0 ; i < linea.length; i++){

            }
        }

        return resultado;
    }
}