package seis;



import java.util.Scanner;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static IMap mapCartas;
    private static ArrayList<String> coleccion = new ArrayList<String>();

    public static void main(String[] args) {


        boolean salir = false;
        do{

            System.out.println("Tipo de Map seleccionado: [" + mapCartas + "]");
            System.out.println("Menu: ");
            System.out.println("0) Selecionar MAP");
            System.out.println("1) Agregar cartas a la coleccion");
            System.out.println("2) Mostrar tipo de carta especifica (de la tienda)");
            System.out.println("3) Mostrar cada carta que el usuario tiene en su coleccion");
            System.out.println("4) Mostrar cada carta que el usuario tiene en su coleccion (de forma ordenada)");
            System.out.println("5) Mostrar el nombre y toipo de todas las cartas existentes");
            System.out.println("6) Mostrar el nombre y toipo de todas las cartas existentes (de forma ordenada)");
            System.out.println("7) Salir");

            String opcion = scan.nextLine();

            switch (opcion) {
                // Selecionar MAP
                case "0":
                    System.out.println("Porfavor seleccione el tipo de map a utilizar: ");
                    System.out.println("1) Hash Map");
                    System.out.println("2) Linked Hash Map");
                    System.out.println("3) Tree Map");

                    mapCartas = MapFactory.getMap(scan.nextLine());

                    if(mapCartas == null){
                        System.out.println("No se selecciono un Map valido");
                    }
                    else{
                        System.out.println("Se acabo de definir el map tipo [" + mapCartas + "]");
                        // Se guardarán las cartas
                        System.out.println(readData());
                    }

                    break;

                // Agregar cartas a la colección
                case "1":
                    if(mapCartas != null){
                        System.out.println("Por favor ingrese el nombre de la carta que desee: ");
                        String solicitarCarta = scan.nextLine();

                        String cartaRetornada = mapCartas.containsValue(solicitarCarta);

                        if(cartaRetornada.length() == 0){
                            System.out.println("No hay una carta valida. " + cartaRetornada);
                        }
                        else{
                            System.out.println("La carta retornada fue: " + cartaRetornada);
                        }

                    }
                    else{
                        System.out.println("Porfavor seleccione un tipo de Map");
                    }
                    break;

                // Mostrar tipo de carta específica (de la tienda)
                case "2":
                    if(mapCartas != null){
                        System.out.println("Vamos!");
                    }
                    else{
                        System.out.println("Porfavor seleccione un tipo de Map");
                    }

                    break;

                // Mostrar cada carta que el usuario tiene en su coleccion
                case "3":

                    break;

                // Mostrar cada carta que el usuario tiene en su coleccion (de forma ordenada)
                case "4":

                    break;

                // Mostrar el nombre y toipo de todas las cartas existentes
                case "5":
                    if(mapCartas != null){
                        // System.out.println("Vamos!");
                        System.out.println(mapCartas.showCards());
                    }
                    else{
                        System.out.println("Porfavor seleccione un tipo de Map");
                    }
                    break;

                // Mostrar el nombre y toipo de todas las cartas existentes (de forma ordenada)
                case "6":
                    if(mapCartas != null){
                        System.out.println("Vamos!");
                    }
                    else{
                        System.out.println("Porfavor seleccione un tipo de Map");
                    }
                    break;

                // Salir
                case "7":
                    salir = true;
                    break;

                // Opcion no disponible
                default:
                    System.out.println("\nOpcion no disponible\n");
                    break;
            }

        }while(!salir);
    }

    private static String readData(){
        String info = "";

        try {
            FileReader fr = new FileReader("src/sample/cards_desc.txt");
            BufferedReader entrada = new BufferedReader(fr);
            String s;
            Integer key = 0;

            while((s = entrada.readLine()) != null) {
                String[] temp = s.split("\\|");
                Card nuevaCarta = new Card(temp[1], temp[0]);
                mapCartas.saveCard(key, nuevaCarta);
                key += 1;
            }

            info = "Archivo leido exitosamente";
        } catch (Exception e) {
            info = "Archivo no fue localizado";
        }

        return info;
    }

}
