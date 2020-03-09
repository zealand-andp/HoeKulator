package systemtest;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class STD0104Test {
    private final static double DELTA = 0.001;
    @Test
    void test010401() throws NegativBeloebException {
        VareforbrugImpl vareforbrug = new VareforbrugImpl();
        vareforbrug.angivBeloeb(21622);

        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        bruttofortjeneste.angivBeloeb(12698);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendBruttofortjenesteOgVareforbrug( bruttofortjeneste, vareforbrug);
        assertEquals(34320, omsaetning.hentOmsaetning(), DELTA);
    }

    @Test
    void test010402(){
        PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        primoAarsomsaetning.angivBeloeb(31200);

        ProcentstigningImpl procentstigning = new ProcentstigningImpl();
        procentstigning.angivDecimaltal(10);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
        assertEquals(34320, omsaetning.hentOmsaetning(),DELTA);

    }

    @Test
    void test010403() throws NegativPrisException, NegativAntalException {
        SalgsprisImpl salgspris = new SalgsprisImpl();
        salgspris.angivPris(9);

        AfsaetningImpl afsaetning = new AfsaetningImpl();
        afsaetning.angivAntal(1000);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendAfsaetningOgSalgspris(afsaetning, salgspris);
        assertEquals(9000, omsaetning.hentOmsaetning(),DELTA);

    }
/*
    @Test
    void test010404() throws NegativBeloebException {
        VareforbrugImpl vareforbrug = new VareforbrugImpl();
        vareforbrug.angivBeloeb(12500);

        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        bruttofortjeneste.angivBeloeb(-5000);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
      ofortjeneste burde  omsaetning .anvendBruttofortjenesteOgVareforbrug(bruttofortjeneste,vareforbrug);
        assertEquals(7500, omsaetning.hentOmsaetning(), DELTA);

    } TODO brutt kunne være negativt, især i nyere virksomheder der stadig vækster */

    @Test
    void test010406() throws  NegativBeloebException {
        PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        primoAarsomsaetning.angivBeloeb(31565.00);

        ProcentstigningImpl procentstigning = new ProcentstigningImpl();
        procentstigning.angivDecimaltal(-10);

        OmsaetningImpl omsaetning = new OmsaetningImpl();
        omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
        assertEquals(28408.5, omsaetning.hentOmsaetning(), DELTA);
    }
}

