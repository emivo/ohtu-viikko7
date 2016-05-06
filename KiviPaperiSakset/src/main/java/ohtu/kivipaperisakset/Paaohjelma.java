package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        Pelitehdas tehdas = new Pelitehdas(scanner);
        
        while (true) {
            tulostaOhje();
            String vastaus = scanner.nextLine();
            KPSPeli peli = tehdas.valitsePeli(vastaus);
            if (peli != null) {
                peli.tulostaPeliOhje();
                peli.pelaa();
                continue;
            }
            break;
        }

    }

    private static void tulostaOhje() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }
}
