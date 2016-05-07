package ohtu.kivipaperisakset.pelilogiikka;

import ohtu.kivipaperisakset.tekoaly.TekoalyPelaaja;
import ohtu.kivipaperisakset.tekoaly.Tekoaly;
import ohtu.kivipaperisakset.tekoaly.TekoalyParannettu;
import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    private TekoalyPelaaja tekoaly;

    public KPSTekoaly(Scanner scanner, Tuomari tuomari, boolean parannettu) {
        super(scanner, tuomari);
        if (parannettu) {
            this.tekoaly = new TekoalyParannettu(20);
        } else {
            this.tekoaly = new Tekoaly();
        }
    }

    @Override
    public String toisenPelaajanSiirto(String toisenPelaajanEdellinenSiirto) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        tekoaly.asetaSiirto(toisenPelaajanEdellinenSiirto);
        return siirto;
    }
}
