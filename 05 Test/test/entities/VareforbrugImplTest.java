package entities;

import entities.exceptions.NegativBeloebException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VareforbrugImplTest {
private static MockObserverManager mockObserverManager;
    private static final double DELTA = 0.001;

    @Test
    void angivBeloeb() throws NegativBeloebException {
        mockObserverManager = new MockObserverManager();
        VareforbrugImpl vareforbrug = new Testvarforbrug();
        assertEquals(0.0,vareforbrug.hentBeloeb());
        double beloeb = 21622.0;
        vareforbrug.angivBeloeb(beloeb);
        assertEquals(21622.0,vareforbrug.hentBeloeb(),DELTA);
        assertEquals(1,mockObserverManager.notifkationsteller);
    }
    @Test
    void vareforbrugbelobexceptiontest()  {
        mockObserverManager = new MockObserverManager();
        VareforbrugImpl vareforbrug = new Testvarforbrug();
        assertEquals(0.0,vareforbrug.hentBeloeb());
        double beloeb = -1622;
        assertThrows(NegativBeloebException.class, () -> {
            vareforbrug.angivBeloeb(beloeb);
        });
        assertEquals(0,mockObserverManager.notifkationsteller);

    }

    @Test
    void tilmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        VareforbrugImpl vareforbrug = new Testvarforbrug();
        vareforbrug.tilmeldObserver(mockObserver);
        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    @Test
    void afmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        VareforbrugImpl vareforbrug = new Testvarforbrug();
        vareforbrug.afmeldObserver(mockObserver);
        assertTrue(mockObserverManager.afmeldtObserver.contains(mockObserver));
    }
    private class MockObserverManager  implements ObserverManager {
    public int notifkationsteller = 0;
        public ArrayList<Observer> tilmeldtObserver = null;
        public ArrayList<Observer> afmeldtObserver = null;

        @Override
        public void notificerObservere(Observable observable) {
        notifkationsteller ++;
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
    private class Testvarforbrug extends VareforbrugImpl{

        @Override
        protected ObserverManager newObserverManager() {
            return mockObserverManager;
        }
    }
}