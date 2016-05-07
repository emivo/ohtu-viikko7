package ohtu.kivipaperisakset.tekoaly;

import java.util.ArrayList;
import java.util.List;

public class Tekoaly implements TekoalyPelaaja {

    private int siirto;
    private List<String> siirrot;
    
    public Tekoaly() {
        this.siirrot = new ArrayList<>();
        alustaSiirtolista();
        siirto = 0;
    }

    protected void alustaSiirtolista() {
        siirrot.add("k");
        siirrot.add("p");
        siirrot.add("s");
    }

    @Override
    public String annaSiirto() {
        siirto++;
        return siirrot.get(siirto % siirrot.size());
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
