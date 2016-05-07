package ohtu.kivipaperisakset.tekoaly;

/**
 *
 * @author emivo
 */
public class Siirto implements Comparable<Siirto> {
    private String siirto;
    private int maara;

    public Siirto(String siirto) {
        this.siirto = siirto;
        this.maara = 0;
    }

    public String getSiirto() {
        return siirto;
    }

    public int getMaara() {
        return maara;
    }
     public void lisaaSiirtojenMaara() {
         maara++;
//         if (maara + 1 == Integer.MAX_VALUE) {
////             do something
//         }
     }

    @Override
    public int compareTo(Siirto o) {
        return this.maara - o.getMaara();
    }
    
}
