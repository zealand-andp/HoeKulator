package entities;

import entities.exceptions.NegativBeloebException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BruttofortjenesteImplTest {

    private static final double DELTA = 0.001;
    private static MockObserverManager mockObserverManager;

    //UT010101
    @Test
    void angivBeloeb() throws NegativBeloebException {
        mockObserverManager = new MockObserverManager();
        BruttofortjenesteImpl bruttofortjeneste = new TestbarBruttofortjeneste();
        assertEquals(0.0, bruttofortjeneste.hentBeloeb(), DELTA);

        double beloeb = 12698.0;

        bruttofortjeneste.angivBeloeb(beloeb);

        assertEquals(12698.0, bruttofortjeneste.hentBeloeb(), DELTA);
        assertEquals(1, mockObserverManager.notificationsTaeller);
    }

    //UT010102
    @Test
    void testException() {
        BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
        double beloeb = -2698;
        assertThrows(NegativBeloebException.class, () -> {
            bruttofortjeneste.angivBeloeb(beloeb);
        });
        assertEquals(0.0, bruttofortjeneste.hentBeloeb(), DELTA);
    }



    //UT010106
    @Test
    void testTilmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        BruttofortjenesteImpl bruttofortjeneste = new TestbarBruttofortjeneste();
        bruttofortjeneste.tilmeldObserver(mockObserver);
        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    //UT010107
    @Test
    void testAfmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        BruttofortjenesteImpl bruttofortjeneste = new TestbarBruttofortjeneste();
        bruttofortjeneste.afmeldObserver(mockObserver);
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

    private class TestbarBruttofortjeneste extends BruttofortjenesteImpl {
        @Override
        protected ObserverManager newObserverManager() {
            return mockObserverManager;
        }
    }
}