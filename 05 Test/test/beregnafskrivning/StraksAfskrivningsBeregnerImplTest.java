package beregnafskrivning;

import entities.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StraksAfskrivningsBeregnerImplTest {
    @Test void beregnAfskrivningNegativ() throws NegativBeloebException, OverMaksbeloebException {
        MockStraksAfskrivningsRequest1 mockStraksAfskrivningsRequest1 = new MockStraksAfskrivningsRequest1();
        StraksAfskrivningBeregnerImpl straksAfskrivningBeregner = new StraksAfskrivningBeregnerImpl();
        assertThrows(NegativBeloebException.class, () -> straksAfskrivningBeregner.beregnAfskrivning(mockStraksAfskrivningsRequest1));
    }

    @Test void beregnAfskrivningOverMaks() throws NegativBeloebException, OverMaksbeloebException {
        MockStraksAfskrivningsRequest2 mockStraksAfskrivningsRequest2 = new MockStraksAfskrivningsRequest2();
        StraksAfskrivningBeregnerImpl straksAfskrivningBeregner = new StraksAfskrivningBeregnerImpl();
        assertThrows(OverMaksbeloebException.class, () -> straksAfskrivningBeregner.beregnAfskrivning(mockStraksAfskrivningsRequest2));
    }

    private class MockStraksAfskrivningsRequest1 implements StraksAfskrivningsRequest, AfskrivningRequest {

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
        public double hentAnskaffelsesvaerdi() {
            return -1;
        }
    }

    private class MockStraksAfskrivningsRequest2 implements StraksAfskrivningsRequest, AfskrivningRequest {

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
        public double hentAnskaffelsesvaerdi() {
            return 30000;
        }

    }
}
