package entities;
import entities.*;
import entities.exceptions.NegativBeloebException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import entities.ObserverManager;
import entities.ObserverManagerImpl;
import entities.Observer;


class OmsaetningImplTest {

  private static double DELTA = 0.001;
  private static MockObserverManager mockObserverManager;

  // UC010105

    @Test
    void anvendBruttofortjenesteOgVareforbrug() throws NegativBeloebException {
      mockObserverManager = new MockObserverManager();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      MockBruttofortjeneste bruttofortjeneste = new MockBruttofortjeneste();
      MockVareforbrug vareforbrug = new MockVareforbrug();
      assertEquals(12698.0, bruttofortjeneste.beloeb, DELTA);
      assertEquals(21622.0, vareforbrug.beloeb, DELTA);
      assertEquals(0, mockObserverManager.notificationsTaeller);

      ;

      omsaetning.anvendBruttofortjenesteOgVareforbrug(bruttofortjeneste, vareforbrug);

      assertEquals(1, mockObserverManager.notificationsTaeller);
      assertNull(omsaetning.hentPrimoAarsomsaetning());
      assertNull(omsaetning.hentProcentstigning());
      assertNull(omsaetning.hentAfsaetning());
      assertNull(omsaetning.hentSalgspris());
    }

    @Test
    void anvendAfsaetningOgSalgspris() {
    }

    @Test
    void anvendPrimoAarsomsaetningOgProcentstigning() {

    }

    @Test
    void hentOmsaetning() {

    }

    @Test
    void tilmeldObserver() {
        mockObserverManager.tilmeldObserver(null);

    }

    @Test
    void afmeldObserver() {
    }


  private class MockObserverManager implements ObserverManager {
    public int notificationsTaeller = 0;
    public ArrayList<Observer> tilmeldtObserver = new ArrayList<>();
    public ArrayList<Observer> afmeldtObserver = new ArrayList<>();

    @Override
    public void notificerObservere(Observable observable) {
      notificationsTaeller++;
    }

    @Override
    public void tilmeldObserver(Observer observer) {
      tilmeldtObserver.add(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
      afmeldtObserver.add(observer);
    }

  }

  private class MockObserver implements Observer{

    @Override
    public void opdater(Observable observable) {

    }
  }

  private class TestbarOmsaetning extends OmsaetningImpl {
    @Override
    protected ObserverManager newObserverManager() {
      return mockObserverManager;
    }
  }

  private class  MockBruttofortjeneste implements Bruttofortjeneste {
    public double beloeb = 12698;
    @Override
    public void angivBeloeb(double beloeb) throws NegativBeloebException {

    }

    @Override
    public double hentbeloeb() {
      return 0;
    }
  }

  private class MockVareforbrug implements Vareforbrug {
      public double beloeb = 21622;
    @Override
    public void angivBeloeb(double beloeb) throws NegativBeloebException {

    }

    @Override
    public double hentBeloeb() {
      return 0;
    }
  }
}