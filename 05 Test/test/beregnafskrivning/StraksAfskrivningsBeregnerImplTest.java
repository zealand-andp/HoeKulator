package beregnafskrivning;

import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StraksAfskrivningsBeregnerImplTest {
    @Test void beregnAfskrivningNegativ() {
        MockStraksAfskrivningsRequest1 mockStraksAfskrivningsRequest1 = new MockStraksAfskrivningsRequest1();
        StraksAfskrivningBeregnerImpl straksAfskrivningBeregner = new StraksAfskrivningBeregnerImpl();
        assertThrows(NegativBeloebException.class, straksAfskrivningBeregner.beregnAfskrivning(mockStraksAfskrivningsRequest1));
    }

    @Test void beregnAfskrivningOverMaks() {
        MockStraksAfskrivningsRequest2 mockStraksAfskrivningsRequest2 = new MockStraksAfskrivningsRequest2();
        StraksAfskrivningBeregnerImpl straksAfskrivningBeregner = new StraksAfskrivningBeregnerImpl();
        assertThrows(OverMaksbeloebException.class, straksAfskrivningBeregner.beregnAfskrivning(mockStraksAfskrivningsRequest2));
    }

    private class MockStraksAfskrivningsRequest1 implements StraksAfskrivningsRequest, AfskrivningsRequest {

        @Override
        public boolean erBeregnet() {
            return false;
        }

        @Override
        public void angivAfskrivning(double beloeb) {

        }

        @Override
        public double hentAfskrivning() {
            return 0;
        }

        @Override
        public Afskrivningsmetoder hentAfskrivningsmetode() {
            return Afskrivningsmetoder.STRAKS;
        }

        @Override
        public int hentBrugstid() {
            return 0;
        }

        @Override
        public double hentScrapvaerdi() {
            return 0;
        }

        @Override
        public double hentAnskaffelsesvaedi() {
            return -5000;
        }
    }

    private class MockStraksAfskrivningsRequest2 implements StraksAfskrivningsRequest, AfskrivningsRequest {

        @Override
        public boolean erBeregnet() {
            return false;
        }

        @Override
        public void angivAfskrivning(double beloeb) {

        }

        @Override
        public double hentAfskrivning() {
            return 0;
        }

        @Override
        public Afskrivningsmetoder hentAfskrivningsmetode() {
            return Afskrivningsmetoder.STRAKS;
        }

        @Override
        public int hentBrugstid() {
            return 0;
        }

        @Override
        public double hentScrapvaerdi() {
            return 0;
        }

        @Override
        public double hentAnskaffelsesvaedi() {
            return 14201;
        }
    }
}
