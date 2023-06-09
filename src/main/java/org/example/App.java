package org.example;


import java.util.Scanner;


/**
 * Hello to Practica Parcial 1 - MAYOR/MENOR
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    static Mazo mazo;
    static Scanner scanner=new Scanner(System.in);
    private static int partidasGanadas=0;
    private static int partidasPerdidas=0;
    public static void main( String[] args ) {

        System.out.println("Hello, Practica Parcial 1 - MAYOR/MENOR.");
        System.out.println("Esto es Mayor y Menor. Ingrese su nombre para empezar a jugar");// Mensaje de Bienvenida
        scanner.nextLine();
        mazo=new Mazo();
        mazo.mezclarCartas();
        while(true){
            jugar();
            if(!volverAJugar()){
                break;
            }
        }
    }
    private static void jugar() {
        String cartaActual=mazo.mostrarUnaCarta();
        int valorCartaActual=Integer.parseInt(cartaActual.substring(0,2).strip());
        System.out.println(cartaActual);
        boolean esMayor=true;
        while(mazo.quedanCartas()){
            System.out.println("La siguiente carta es MAYOR o MENOR");
            String respuesta=scanner.nextLine().toLowerCase();
            String siguienteCarta=mazo.mostrarUnaCarta();
            int valorCartaSiguiente=Integer.parseInt(siguienteCarta.substring(0,2).strip());
            System.out.println(siguienteCarta);
            if(respuesta.equals("mayor")){
                esMayor=true;
            }else if(respuesta.equals("menor")){
                esMayor=false;
            }else {
                System.out.println("Respuesta incorrecta,ingrese mayor o menor");
                continue;
            }
            if(respuesta.equals("mayor")&&valorCartaSiguiente>valorCartaActual &&esMayor
                    || respuesta.equals("menor")&&valorCartaSiguiente<valorCartaActual&&!esMayor
                    ||respuesta.equals("mayor")&&valorCartaSiguiente==valorCartaActual
                    ||respuesta.equals("menor")&&valorCartaSiguiente==valorCartaActual){
                System.out.println("Acertaste!!!!");
                cartaActual=siguienteCarta;
                valorCartaActual=valorCartaSiguiente;
            }else {
                System.out.println("No acertaste el juego termino");
                partidasPerdidas++;
                System.out.println(resultados());
                volverAJugar();
                break;
            }

        }
        System.out.println("Felicitaciones!!!, has ganado!!");
        partidasGanadas++;
        System.out.println(resultados());
        volverAJugar();
    }
    public static String resultados(){
        return "Partidas ganadas="+partidasGanadas+"\n"+
                "Partidas perdidas="+partidasPerdidas;
    }

    private static boolean volverAJugar() {
        boolean aux=false;
        System.out.println("Quieres volver a jugar? s/n");
        String nuevoJuego=scanner.nextLine().toLowerCase();
        if(nuevoJuego.equals("s")){
            aux=true;
            mazo.mezclarCartas();
            jugar();
        }else{
            aux=false;
            System.out.println("Gracias por Jugar");
            System.exit(0);
        }
        return aux;
    }
}
