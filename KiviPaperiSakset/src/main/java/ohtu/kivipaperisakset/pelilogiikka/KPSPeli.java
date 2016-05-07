package ohtu.kivipaperisakset.pelilogiikka;

import java.util.Scanner;

/**
 *
 * @author airta
 */
public abstract class KPSPeli {

    protected Scanner scanner;
    protected Tuomari tuomari;

    public KPSPeli(Scanner scanner, Tuomari tuomari) {
        this.scanner = scanner;
        this.tuomari = tuomari;
    }

    public void pelaa() {

        String ekanSiirto = ekanPelaajanSiirto();
        String tokanSiirto = toisenPelaajanSiirto(ekanSiirto);

        while (onkoSiirrotValideja(ekanSiirto, tokanSiirto)) {
            tuomariKirjaaJaTulostaTilanne(ekanSiirto, tokanSiirto);
            ekanSiirto = ekanPelaajanSiirto();
            tokanSiirto = toisenPelaajanSiirto(ekanSiirto);
        }
        tulostaLopetus();
    }

    protected boolean onkoSiirrotValideja(String ekanSiirto, String tokanSiirto) {
        return onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto);
    }

    protected void tuomariKirjaaJaTulostaTilanne(String ekanSiirto, String tokanSiirto) {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        tuomari.tulostaTilanne();
    }

    protected String ekanPelaajanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    public void tulostaPeliOhje() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }

    protected boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected void tulostaLopetus() {
        System.out.println("\nKiitos!");
        tuomari.tulostaTilanne();
    }

    abstract String toisenPelaajanSiirto(String toisenPelaajanEdellinenSiirto);
}
