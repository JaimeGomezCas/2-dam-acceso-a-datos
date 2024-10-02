package es.cheste;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Agenda {
    private static ResourceBundle bundle;
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        bundle = ResourceBundle.getBundle("mensajes", seleccionarIdioma(sc));

        boolean seguirEnLaAgenda = Boolean.TRUE;
        while (seguirEnLaAgenda){

            seguirEnLaAgenda = menuOpcionesAgenda(sc);

        }
    }

    private static boolean menuOpcionesAgenda(Scanner sc){

        int opcionElegida = 0;

        do {

            try{

                System.out.println(bundle.getString("menu.opciones"));
                opcionElegida = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e){

                //TODO el resources bundle
                System.out.println(bundle.getString("error.opcionNoValida"));

            }

        } while (opcionElegida < 1 || opcionElegida > 6);

        boolean continuarEnLaAplicacion = Boolean.TRUE;
        switch (opcionElegida){
            case 1:
                //guardarContacto();
                break;
            case 2:
                //modificarContacto();
                break;
            case 3:
                //eliminarContacto();
                break;
            case 4:
                //buscarContacto();
                break;
            case 5:
                //mostrarContactos();
                break;
            default:
                continuarEnLaAplicacion = Boolean.FALSE;
        }

        return continuarEnLaAplicacion;
    }

    private static Locale seleccionarIdioma(Scanner sc){

        char idiomaSeleccionado;

        do {

            System.out.println("""
                    Selecciona el idioma:
                    1: Español
                    2: English
                    3: Valencià""");
            idiomaSeleccionado = sc.next().charAt(0);
            sc.nextLine();

        } while (idiomaSeleccionado != '1' && idiomaSeleccionado != '2' && idiomaSeleccionado != '3');

        return switch (idiomaSeleccionado) {
            case '1' -> new Locale("es, ES");
            case '2' -> new Locale("en", "US");
            default -> new Locale("ca", "ES");
        };

    }
    pria


}