package beregnafskrivning;

import entities.*;
import entities.exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeregnAfskrivningImplTest {
    private static MockObserverManager mockObserverManager;
    @Test
    void angivStraksAfskrivning() throws NegativVaerdiException, KanIkkeBeregneAfskrivningException, NegativAfskrivningsprocentException, OverMaksbeloebException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, NegativEllerNulVaerdiException {
        mockObserverManager = new MockObserverManager();
        String navn = "Cykler";
        double anskaffelsesvaerdi = 5000;
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        beregnAfskrivning.angivStraksafskrivning(navn, anskaffelsesvaerdi);

        assertEquals(1, mockObserverManager.notificationsTaeller);
    }
    @Test
    void TilmeldObserver() {
        mockObserverManager = new MockObserverManager();
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        MockObserver mockObserver = new MockObserver();

        beregnAfskrivning.tilmeldObserver(mockObserver);

        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    @Test
    void AfmeldObserver() {
        mockObserverManager = new MockObserverManager();
        BeregnAfskrivningImpl beregnAfskrivning = new BeregnAfskrivningImpl();
        MockObserver mockObserver = new MockObserver();

        beregnAfskrivning.afmeldObserver(mockObserver);

        assertTrue(mockObserverManager.afmeldtObserver.contains(mockObserver));
    }

    private class MockObserverManager implements ObserverManager {
        public int notificationsTaeller = 0;
        public ArrayList<Observer> tilmeldtObserver = null;
        public ArrayList<Observer> afmeldtObserver = null;

        @Override
        public void notificerObservere(Observable observable) {
            notificationsTaeller++;
        }

        @Override
        public void tilmeldObserver(Observer observer) {
            tilmeldtObserver = new ArrayList<>();
            tilmeldtObserver.add(observer);
        }

        @Override
        public void afmeldObserver(Observer observer) {
            afmeldtObserver = new ArrayList<>();
            afmeldtObserver.add(observer);
        }
    }

    private class MockObserver implements Observer {
        @Override
        public void opdater(Observable observable) {

        }

    }
}
