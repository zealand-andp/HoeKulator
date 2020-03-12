package systemtest;

import entities.exceptions.NegativBeloebException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class STD0601Test {
    //det er udkommenteret, da det ikke er implementeret endnu
    /*
    @Test void test060101(){
        String navn = "Husleje";
        double beloeb = 2000;
        String foraeldersNavn = "kko";
        BeregnKKO beregnKKO = new BeregnKKO();
        beregnKKO.angivKKO(navn, beloeb, foraeldersNavn);
        //nu forventer vi, at kko findes i systemet.
        //Derfor hvis jeg kalder funktionen igen med samme navn bør vi få en NavnEksistererException.
        assertThrows(NavnEksistererException.class, () -> beregnKKO.angivKKO(navn, beloeb, foraeldersNavn));
    }

    @Test void test060102(){
        String navn = "Husleje";
        double beloeb = -2000;
        String foraeldersNavn = "kko";
        BeregnKKO beregnKKO = new BeregnKKO();
        assertThrows(NegativBeloebException.class, () -> beregnKKO.angivKKO(navn, beloeb, foraeldersNavn));
    }

    @Test void test060103(){
        String navn = "kko";
        double beloeb = 2000;
        String foraeldersNavn = "kko";
        BeregnKKO beregnKKO = new BeregnKKO();
        assertThrows(NavnEksistererException.class, () -> beregnKKO.angivKKO(navn, beloeb, foraeldersNavn));
    }

    @Test void test060104(){
        String navn = "Husleje";
        double beloeb = 2000;
        String foraeldersNavn = "kkonavneksistererikke";
        BeregnKKO beregnKKO = new BeregnKKO();
        assertThrows(ForaeldereksistererIkkeException.class, () -> beregnKKO.angivKKO(navn, beloeb, foraeldersNavn));
    }
     */
}
