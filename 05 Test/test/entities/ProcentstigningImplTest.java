package entities;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ProcentstigningImplTest {

    private static  final double DELTA = 0.001;
    private  static MockObserverManager mockObserverManager;


    //UT0601
    @Test
    void  angivDecimaltal() {
        mockObserverManager = new MockObserverManager();
        ProcentstigningImpl procentstigning = new TestbarProcentstigning();
        assertEquals(0.0, procentstigning.hentDecimaltal(), DELTA);

        double beloeb =6.20;

        procentstigning.angivDecimaltal(beloeb);

        assertEquals(6.20, procentstigning.hentDecimaltal(), DELTA);
        assertEquals(1, mockObserverManager.notificationsTaeller);
    }

    //UT0602
    @Test
    void angivDecimaltalMinus() {
        mockObserverManager = new MockObserverManager();
        Procentstigning procentstigning = new TestbarProcentstigning();
        assertEquals(0.0,procentstigning.hentDecimaltal(),DELTA);

        double beloeb = -4.24;

        procentstigning.angivDecimaltal(beloeb);

        assertEquals(-4.24, procentstigning.hentDecimaltal(),DELTA);
        assertEquals(1, mockObserverManager.notificationsTaeller);
    }

    //UT0604
    @Test
    void testTilmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        ProcentstigningImpl procentstigning = new TestbarProcentstigning();
        procentstigning.tilmeldObserver(mockObserver);
        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    //Ut0606
    @Test
    void testAfmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        ProcentstigningImpl procentstigning = new TestbarProcentstigning();
        procentstigning.afmeldObserver(mockObserver);
        assertTrue(mockObserverManager.afmeldtObserver.contains(mockObserver));
    }

    private class  MockObserverManager implements  ObserverManager {
        public int notificationsTaeller = 0;
        public ArrayList<Observer> tilmeldtObserver = new ArrayList<>();
        public ArrayList<Observer> afmeldtObserver = new ArrayList<>();

        @Override
        public void notificerObservere (Observable observable) {notificationsTaeller++;        }

        @Override
        public void  tilmeldObserver(Observer observer) {tilmeldtObserver.add(observer);}

        @Override
        public void afmeldObserver( Observer observer)  {afmeldtObserver.add(observer);}
    }

    private class  MockObserver implements  Observer {
        @Override
        public void opdater(Observable observable) {

        }
    }

    private class  TestbarProcentstigning extends  ProcentstigningImpl {
        @Override
        protected ObserverManager newObserverManager() {return mockObserverManager;}
    }

}
