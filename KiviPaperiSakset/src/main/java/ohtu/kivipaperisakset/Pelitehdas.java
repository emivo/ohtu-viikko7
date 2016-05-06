/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author airta
 */
public class Pelitehdas {

    private HashMap<String, KPSPeli> pelit;

    public Pelitehdas(Scanner scanner) {
        Tuomari tuomari = new Tuomari();
        pelit = new HashMap<>();
        pelit.put("a", new KPSPelaajaVsPelaaja(scanner, tuomari));
        pelit.put("b", new KPSTekoaly(scanner, tuomari));
        pelit.put("c", new KPSParempiTekoaly(scanner, tuomari));
    }

    public KPSPeli valitsePeli(String valinta) {
        return pelit.get(valinta);
    }

}
