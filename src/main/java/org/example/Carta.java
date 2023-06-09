package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Carta {
    Palo palo;
    Integer valor;
    @Override
    public String toString(){
        return valor+" de "+palo;
    }
}