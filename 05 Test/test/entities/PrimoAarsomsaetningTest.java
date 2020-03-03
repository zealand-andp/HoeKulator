package entities;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PrimoAarsomsaetningTest {

    private static  final double DELTA = 0.001;
    private static  MockObserverManager mockObserverManager;


    //UT0501
    @Test
    void  angivBeloeb()   {
        mockObserverManager = new MockObserverManager();
        PrimoAarsomsaetningImpl primoAarsomsaetning = new TestbarPrimoAarsomsaetning();
        assertEquals(0.0, primoAarsomsaetning.hentBeloeb(),DELTA);

        double beloeb = 11720.1;

        primoAarsomsaetning.angivBeloeb(beloeb);

        assertEquals(11720.1, primoAarsomsaetning.hentBeloeb(),DELTA);
        assertEquals(1, mockObserverManager.notificationsTaeller);
    }


    //UT0504
    @Test
    void testTilmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        PrimoAarsomsaetningImpl primoAarsomsaetning = new TestbarPrimoAarsomsaetning();
        primoAarsomsaetning.tilmeldObserver(mockObserver);
        assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));
    }

    //UT0505
    @Test
    void testAfmeldObserver() {
        mockObserverManager = new MockObserverManager();
        MockObserver mockObserver = new MockObserver();
        PrimoAarsomsaetningImpl primoAarsomsaetning = new TestbarPrimoAarsomsaetning();
        primoAarsomsaetning.afmeldObserver(mockObserver);
        assertTrue(mockObserverManager.afmeldtObserver.contains(mockObserver));
    }

    private class  MockObserverManager implements  ObserverManager {
        public  int notificationsTaeller = 0;
        public ArrayList<Observer> tilmeldtObserver = new ArrayList<>();
        public ArrayList<Observer> afmeldtObserver = new ArrayList<>();

        @Override
        public void notificerObservere (Observable observable) { notificationsTaeller++;}

        @Override
        public void tilmeldObserver(Observer observer) { tilmeldtObserver.add(observer);}

        @Override
        public void afmeldObserver(Observer observer) {afmeldtObserver.add(observer);}

    }

    private class MockObserver implements  Observer {
        @Override
        public void opdater(Observable observable) {

        }
    }

    private class TestbarPrimoAarsomsaetning extends PrimoAarsomsaetningImpl {
        @Override
        protected  ObserverManager newObserverManager() { return mockObserverManager;}
    }

}
