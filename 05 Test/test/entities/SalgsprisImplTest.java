package entities;

import entities.exceptions.NegativPrisException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalgsprisImplTest {
    private static MockObserverManager mockObserverManager;
    private static final double DELTA = 0.001;

    @Test
    void ut010201() throws NegativPrisException {
        mockObserverManager = new MockObserverManager();
        SalgsprisImpl salgspris = new TestbarSalgspris();
        assertEquals(0, salgspris.hentPris());

        double pris = 9;

        salgspris.angivPris(pris);

        assertEquals(9, salgspris.hentPris(), DELTA);
        assertEquals(1, mockObserverManager.notificationsTaeller);
    }

    @Test
    void ut010202() throws NegativPrisException {
        mockObserverManager = new MockObserverManager();
        SalgsprisImpl salgspris = new TestbarSalgspris();
        assertEquals(0, salgspris.hentPris());

        double pris = 0;

        salgspris.angivPris(pris);

        assertEquals(0, salgspris.hentPris(), DELTA);
    }

    @Test
    void ut010203() {
        mockObserverManager = new MockObserverManager();
        SalgsprisImpl salgspris = new TestbarSalgspris();
        assertEquals(0, salgspris.hentPris());

        double pris = -15;
        assertThrows(
                NegativPrisException.class, () -> salgspris.angivPris(pris)
        );
    }

    @Test
    void ut010204() {
        mockObserverManager = new MockObserverManager();
        SalgsprisImpl salgspris = new TestbarSalgspris();
        MockObserver mockObserver = new MockObserver();

        salgspris.tilmeldObserver(mockObserver);

        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    @Test
    void afmeldObserver() {
        mockObserverManager = new MockObserverManager();
        SalgsprisImpl salgspris = new TestbarSalgspris();
        MockObserver mockObserver = new MockObserver();

        salgspris.afmeldObserver(mockObserver);

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

    private class TestbarSalgspris extends SalgsprisImpl {
        @Override
        protected ObserverManager newObserverManager() {
            return mockObserverManager;
        }
    }
}