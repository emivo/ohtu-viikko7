package ohtu.kivipaperisakset.pelilogiikka;

import java.util.HashMap;
import java.util.Map;

public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;
    private final Map<String, String> voittoTaulu;

    public Tuomari() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
        this.voittoTaulu = new HashMap<>();
        alustaTaulu();
    }

    private void alustaTaulu() {
        this.voittoTaulu.put("k", "s");
        this.voittoTaulu.put("s", "p");
        this.voittoTaulu.put("p", "k");
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        } else {
            tokanPisteet++;
        }
    }

    private boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    private boolean ekaVoittaa(String eka, String toka) {
        return voittoTaulu.get(eka).equals(toka);
    }

    @Override
    public String toString() {
        return "Pelitilanne: "
                + ekanPisteet
                + " - "
                + tokanPisteet
                + "\nTasepelit: "
                + tasapelit
                + "\n";
    }

    public void tulostaTilanne() {
        System.out.println(toString());
    }
}
