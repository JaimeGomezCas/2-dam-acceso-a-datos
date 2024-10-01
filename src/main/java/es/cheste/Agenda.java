package es.cheste;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Agenda {
    private static ResourceBundle bundle;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bundle = ResourceBundle.getBundle("mensajes", seleccionarIdioma(sc));
         menuOpcionesAgenda();


    }

    private static void menuOpcionesAgenda(){

        System.out.println(bundle.getString("menu.opciones"));





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


}