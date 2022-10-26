package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String ruta = "block1-expression-evaluator/expresiones.csv";
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
        for (String dato : datos) {
            if (dato.contains("\"")) {
                tipoDatos = "string";
            } else if (dato.matches("[0-9]{4}/[0-9]{2}/[0-9]{2}")) {
                tipoDatos = "date";
            } else {
                tipoDatos = "num";
            }
        }
        return "La línea: " + linea + " da como resultado: " + ejecutarExpresion(datos, tipoDatos);
    }

    public static String ejecutarExpresion(String[] linea, String tipoDatos) throws ParseException {
        String resultado = linea[0].replace("\"", "");

        if (tipoDatos.equals("string")) {
            for (int i = 0; i < linea.length; i++) {
                if (i % 2 != 0) {
                    switch (linea[i]) {
                        case "+":
                            resultado = resultado + " " + linea[i + 1].replace("\"", "");
                            break;
                        case "*":
                            resultado = resultado + resultado;
                            break;
                    }
                }
            }
        }
        if (tipoDatos.equals("num")) {
            for (int i = 0; i < linea.length; i++) {
                if (i % 2 != 0) {
                    switch (linea[i]) {
                        case "+":
                            resultado = String.valueOf(parseInt(resultado) + parseInt(linea[i + 1]));
                            break;
                        case "-":
                            resultado = String.valueOf(parseInt(resultado) - parseInt(linea[i + 1]));
                            break;
                        case "*":
                            resultado = String.valueOf(parseInt(resultado) * parseInt(linea[i + 1]));
                            break;
                        case "/":
                            resultado = String.valueOf(parseInt(resultado) / parseInt(linea[i + 1]));
                            break;
                    }
                }
            }
        }
        if (tipoDatos.equals("date")) {
            DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
            for (int i = 0; i < linea.length; i++) {
                if (i % 2 != 0) {
                    switch (linea[i]) {
                        case "=":
                            resultado = String.valueOf(fecha.parse(resultado).compareTo(fecha.parse(linea[i + 1])) == 0);
                            break;
                        case "<":
                            resultado = String.valueOf(fecha.parse(resultado).compareTo(fecha.parse(linea[i + 1])) < 0);
                            break;
                        case ">":
                            resultado = String.valueOf(fecha.parse(resultado).compareTo(fecha.parse(linea[i + 1])) > 0);
                            break;
                    }
                }
            }
        }

        return resultado;
    }
}