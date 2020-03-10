package systemtest;

import entities.BruttofortjenesteImpl;
import entities.OmsaetningImpl;
import entities.VareforbrugImpl;
import entities.exceptions.NegativBeloebException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class STD0101Test {

    private final static double DELTA = 0.001;

    @Test
    void test010101() throws NegativBeloebException {
        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        bruttofortjeneste.angivBeloeb(12698);

        VareforbrugImpl vareforbrug = new VareforbrugImpl();
        vareforbrug.angivBeloeb(21622);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendBruttofortjenesteOgVareforbrug(bruttofortjeneste, vareforbrug);

        double resultat = omsaetning.hentOmsaetning();
        assertEquals(34320, resultat, DELTA);
    }

    @Test
    void test010102() throws NegativBeloebException {
        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        assertThrows(NegativBeloebException.class, () -> bruttofortjeneste.angivBeloeb(-2698));

        VareforbrugImpl vareforbrug = new VareforbrugImpl();
        vareforbrug.angivBeloeb(21622);
    }

    @Test
    void test010103() throws NegativBeloebException {
        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        bruttofortjeneste.angivBeloeb(12698);

        VareforbrugImpl vareforbrug = new VareforbrugImpl();
        assertThrows(NegativBeloebException.class, () -> vareforbrug.angivBeloeb(-1622));
    }
}
