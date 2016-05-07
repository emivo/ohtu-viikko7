package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelilogiikka.Pelitehdas;
import java.util.Scanner;

public class Paaohjelma {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pelitehdas tehdas = new Pelitehdas(scanner);
        tehdas.aloita();
    }
}
