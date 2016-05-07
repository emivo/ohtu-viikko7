package ohtu.kivipaperisakset.tekoaly;

// "Muistava tekoäly"
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TekoalyParannettu implements TekoalyPelaaja {

    private final Map<String, Siirto> siirtoMuisti;
    private final Map<String, String> siirtoValitsin;

    public TekoalyParannettu(int muistinKoko) {
        this.siirtoMuisti = new HashMap<>();
        alustaMuisti();
        this.siirtoValitsin = new HashMap<>();
        alustaValitsin();
    }

    private void alustaMuisti() {
        this.siirtoMuisti.put("k", new Siirto("k"));
        this.siirtoMuisti.put("p", new Siirto("p"));
        this.siirtoMuisti.put("s", new Siirto("s"));
    }

    private void alustaValitsin() {
        this.siirtoValitsin.put("k", "p");
        this.siirtoValitsin.put("p", "s");
        this.siirtoValitsin.put("s", "k");
    }

    @Override
    public void asetaSiirto(String siirto) {
        siirtoMuisti.get(siirto).lisaaSiirtojenMaara();
    }

    @Override
    public String annaSiirto() {
        ArrayList<Siirto> siirrotListana = new ArrayList<>(siirtoMuisti.values());
        Collections.sort(siirrotListana);
        Siirto enitenSiirtoja = siirrotListana.get(0);
        if (enitenSiirtoja.getMaara() <= 1) {
            // tämä lienee nyt tarpeeton
            return "k";
        }
        return siirtoValitsin.get(enitenSiirtoja.getSiirto());
    }
}
