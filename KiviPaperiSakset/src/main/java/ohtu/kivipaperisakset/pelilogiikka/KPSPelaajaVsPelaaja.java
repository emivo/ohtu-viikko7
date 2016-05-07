package ohtu.kivipaperisakset.pelilogiikka;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    public KPSPelaajaVsPelaaja(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }

    @Override
    String toisenPelaajanSiirto(String toisenPelaajanEdellinenSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }

}
