package ohtu.kivipaperisakset.pelilogiikka;

import java.util.HashMap;
import java.util.Map;

public class Tuomari {

    private final int ensimmaisenPelaajanPisteet;
    private final int toisenPelaajanPisteet;

    private final int tasapelit;
    private final Map<Integer, Integer> tilanne;
    private final Map<String, String> voittoTaulu;

    public Tuomari() {
        this.ensimmaisenPelaajanPisteet = 1;
        this.toisenPelaajanPisteet = -1;
        this.tasapelit = 0;
        this.voittoTaulu = new HashMap<>();
        this.tilanne = new HashMap<>();
        alustaTaulut();
    }

    private void alustaTaulut() {
        this.voittoTaulu.put("k", "s");
        this.voittoTaulu.put("s", "p");
        this.voittoTaulu.put("p", "k");
        this.tilanne.put(ensimmaisenPelaajanPisteet, 0);
        this.tilanne.put(toisenPelaajanPisteet, 0);
        this.tilanne.put(tasapelit, 0);
    }
    
    public int getEnsimmaisenPelaajanPisteet() {
        return tilanne.get(ensimmaisenPelaajanPisteet);
    }

    public int getToisenPelaajanPisteet() {
        return tilanne.get(toisenPelaajanPisteet);
    }

    public int getTasapelit() {
        return tilanne.get(tasapelit);
    }
    
    private int voitto(String eka, String toka) {
        if (voittoTaulu.get(eka).equals(toka)) return 1;
        if (voittoTaulu.get(toka).equals(eka)) return -1;
        return 0;
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        int i = voitto(ekanSiirto, tokanSiirto);
        tilanne.put(i, tilanne.get(i) + 1);
    }
    @Override
    public String toString() {
        return "Pelitilanne: "
                + getEnsimmaisenPelaajanPisteet()
                + " - "
                + getToisenPelaajanPisteet()
                + "\nTasepelit: "
                + getTasapelit()
                + "\n";
    }

    public void tulostaTilanne() {
        System.out.println(toString());
    }
}
