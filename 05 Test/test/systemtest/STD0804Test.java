package systemtest;

import beregnafskrivning.BeregnAfskrivningImpl;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.OverMaksbeloebException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class STD0804Test {

    private final static double DELTA = 0.001;

    @Test
    void test080401(){
        double beloeb = 5000;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        assertNotNull(beregnAfskrivning.getAfskrivninger());

        beregnAfskrivning.angivStraksAfskrivning(navn, beloeb);

        assertNotNull(beregnAfskrivning.getAfskrivninger().get(navn));
        assertEquals(beregnAfskrivning.getAfskrivninger().get(navn).getAfskrivningsvaerdi(), 5000, DELTA);
    }

    @Test
    void test080402(){
        //pre conditions
        double beloeb = 14201;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        assertNotNull(beregnAfskrivning.getAfskrivninger());
        assertThrows(OverMaksbeloebException.class, () -> beregnAfskrivning.angivStraksAfskrivning(navn, beloeb));
    }

    @Test
    void test080403(){
        //pre conditions
        double beloeb = -5000;
        String navn = "cykler";
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        assertNotNull(beregnAfskrivning.getAfskrivninger());
        assertThrows(NegativBeloebException.class, () -> beregnAfskrivning.angivStraksAfskrivning(navn, beloeb));
    }
}
