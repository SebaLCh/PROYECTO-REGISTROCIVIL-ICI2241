/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Main {

    private static String archivoDatos = "registroCivil.txt"
    public static void main(String[] args) throws IOException//, InvalidDateException {
        // preguntar por los datos para armar todas las clases pertenecientes a Persona
        // preguntar por bool extranjero, hacer un if para llamar a uno de los 2 constructores y despues si corresponde
        RegistroCivil registro = new RegistroCivil();
        Persistencia persistencia = new Persistencia(archivoDatos);
        try {
            persistencia.cargar(registro);
        } catch (IOException e) {
            System.out.println("no se cargo el archivo");
        }

        Scanner scan = new Scanner(System.in);
        opcion = "";
        while(!opcion.equals("1") && !opcion.equals("2")){
            System.out.printl("como desea usar el sistema");
            System.out.printl("1. consola");
            System.out.printl("2. ventana");
            System.out.print("opcion: ");
            opcion = scan.nextLine().trim();
        }

        MenuConsola menu = new MenuConsola(registro, persistencia);
        menu.iniciar();

}
