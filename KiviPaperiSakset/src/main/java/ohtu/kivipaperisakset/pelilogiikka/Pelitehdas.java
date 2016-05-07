package ohtu.kivipaperisakset.pelilogiikka;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author airta
 */
public class Pelitehdas {

    private final HashMap<String, KPSPeli> pelit;
    private final Scanner scanner;

    public Pelitehdas(Scanner scanner) {
        this.scanner = scanner;
        Tuomari tuomari = new Tuomari();
        pelit = new HashMap<>();
        pelit.put("a", new KPSPelaajaVsPelaaja(scanner, tuomari));
        pelit.put("b", new KPSTekoaly(scanner, tuomari, false));
        pelit.put("c", new KPSTekoaly(scanner, tuomari, true));
    }

    public void aloita() {
        tulostaOhje();
        String vastaus = scanner.nextLine();
        KPSPeli peli = pelit.get(vastaus);
        if (peli != null) {
            peli.tulostaPeliOhje();
            peli.pelaa();
            aloita(); // ehkä siistimpi kuin while true
        }
    }

    private void tulostaOhje() {
        String ohje = "\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan";
        System.out.println(ohje);
    }

}
