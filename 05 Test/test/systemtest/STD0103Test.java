package systemtest;

import entities.OmsaetningImpl;
import entities.PrimoAarsomsaetningImpl;
import entities.ProcentstigningImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class STD0103Test {

    @Test
    void test010301() {
        PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        primoAarsomsaetning.angivBeloeb(2500);

        ProcentstigningImpl procentstigning = new ProcentstigningImpl();
        procentstigning.angivDecimaltal(5);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
        double resultat = omsaetning.hentOmsaetning();
        assertEquals(2625, resultat);

    }

    @Test
    void test010302() {
        PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        primoAarsomsaetning.angivBeloeb(-500);

        ProcentstigningImpl procentstigning = new ProcentstigningImpl();
        procentstigning.angivDecimaltal(5);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
        double resultat = omsaetning.hentOmsaetning();
        assertEquals(-525, resultat);

    }

    @Test
    void test010303() {
        PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        primoAarsomsaetning.angivBeloeb(2500);

        ProcentstigningImpl procentstigning = new ProcentstigningImpl();
        procentstigning.angivDecimaltal(-5);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
        double resultat = omsaetning.hentOmsaetning();
        assertEquals(2375, resultat);
    }
}
