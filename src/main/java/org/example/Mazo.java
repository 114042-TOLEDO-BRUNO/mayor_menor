package org.example;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter

@NoArgsConstructor
public class Mazo {
    private List<Carta>cartas;
    /**
     * Este metodo mezcla las cartas del mazo para jugar
     *
     * Ver Clase Collections
     */

    public void mezclarCartas() {
        cartas=inicializarMazo();
        Collections.shuffle(cartas);
    }
    public String mostrarUnaCarta(){
        Random rand = new Random();
        int indiceCarta = rand.nextInt(cartas.size());
        String cartaAMostrar=cartas.get(indiceCarta).toString();
        cartas.remove(indiceCarta);
        int cartasRestantes=cartas.size();
        return cartaAMostrar + "\nCartas Restantes="+cartasRestantes;
    }

    /**
     * Este metodo muestra la lista completa de las cartas del Mazo
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builer = new StringBuilder();
        for (Carta carta : cartas) {
            builer.append(carta.getValor().intValue()+" de "+carta.getPalo()).append("\n");
        }
        return builer.toString();
    }

    /**
     * Este metodo crea cada carta y la agrega al mazo, como resultado retorna un mazo de 40 cartas españolas
     * @return
     */
    private List<Carta> inicializarMazo() {//crea las 40 cartas
        cartas=new ArrayList<>();
        for(int c=1;c<=10;c++){
            cartas.add(new Carta(Palo.ORO,c));
            cartas.add(new Carta(Palo.BASTO,c));
            cartas.add(new Carta(Palo.COPA,c));
            cartas.add(new Carta(Palo.ESPADA,c));
        }
        return cartas;
    }

    public boolean quedanCartas() {
        return !cartas.isEmpty();
    }
}
