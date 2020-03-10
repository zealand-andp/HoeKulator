package systemtest;

import beregnafskrivning.BeregnAfskrivningImpl;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class STD0803Test {

    private final static double DELTA = 0.001;

    @Test
    void test0803_negativAfskrivningsprocent() {
        double afskrivningsprocent = -0.01;
        double anskaffelsesvaerdi = 500;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();

        assertNotNull(beregnAfskrivning.getAfskrivninger()); // ???
        try {
            beregnAfskrivning.angivSaldoafskrivning(navn, anskaffelsesvaerdi, afskrivningsprocent);
            fail();
        } catch (AfskrivningsprocentOutOfRangeException e) {
            // success
        }
    }

    @Test
    void test0803_forHoejAfskrivningsprocent() {
        double afskrivningsprocent = 1.01;
        double anskaffelsesvaerdi = 500;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();

        assertNotNull(beregnAfskrivning.getAfskrivninger()); // ???
        try {
            beregnAfskrivning.angivSaldoafskrivning(navn, anskaffelsesvaerdi, afskrivningsprocent);
            fail();
        } catch (AfskrivningsprocentOutOfRangeException e) {
            // success
        }
    }

    @Test
    void test0803_negativAnskaffelsesvaerdi() {
        double afskrivningsprocent = 0.5;
        double anskaffelsesvaerdi = -500;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();

        assertNotNull(beregnAfskrivning.getAfskrivninger()); // ???
        try {
            beregnAfskrivning.angivSaldoafskrivning(navn, anskaffelsesvaerdi, afskrivningsprocent);
            fail();
        } catch (NegativAnskaffelsesvaerdiException e) {
            // success
        }
    }
}
