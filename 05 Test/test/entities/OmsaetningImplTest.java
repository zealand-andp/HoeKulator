package entities;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class OmsaetningImplTest {

  private static double DELTA = 0.001;
  private static MockObserverManager mockObserverManager;

  // UC010105

    @Test
    void anvendBruttofortjenesteOgVareforbrugOghentOmsaetning() throws NegativBeloebException {
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
     double resultat = 34320.0;
     assertEquals(resultat, omsaetning.hentOmsaetning());


    }

    @Test
    void anvendAfsaetningOgSalgspris() {
      mockObserverManager = new MockObserverManager();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      Mockafsaetning mockafsaetning = new Mockafsaetning();
      MockSalgspris mockSalgspris = new MockSalgspris();
      assertEquals(21622, mockafsaetning.afsaetning);
      assertEquals(66666, mockSalgspris.salgspris);
      assertEquals(0, mockObserverManager.notificationsTaeller);


      omsaetning.anvendAfsaetningOgSalgspris(mockafsaetning, mockSalgspris );

      assertEquals(1, mockObserverManager.notificationsTaeller);
      double resultat = 1.441452252E9;
      assertEquals(resultat, omsaetning.hentOmsaetning());

    }

    @Test
    void anvendPrimoAarsomsaetningOgProcentstigning() {
      mockObserverManager = new MockObserverManager();
      OmsaetningImpl omsaetning = new OmsaetningImpl();
      MockProcentstigning mockProcentstigning = new MockProcentstigning();
      MockPrimoAarsomsaetning mockPrimoAarsomsaetning = new MockPrimoAarsomsaetning();
      assertEquals(100000, mockPrimoAarsomsaetning.primoAarsomsaetning);
      assertEquals(5.0, mockProcentstigning.procentstigning);
      assertEquals(0, mockObserverManager.notificationsTaeller);

      omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(mockPrimoAarsomsaetning, mockProcentstigning);

      assertEquals(1, mockObserverManager.notificationsTaeller);

      double resultat = 5000;
      assertEquals(resultat, omsaetning.hentOmsaetning());



    }


    @Test
    void tilmeldObserver() {
      mockObserverManager = new MockObserverManager();
      MockObserver mockObserver = new MockObserver();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      omsaetning.tilmeldObserver(mockObserver);
      assertFalse(mockObserverManager.tilmeldtObserver.contains(mockObserver));

    }

    @Test
    void afmeldObserver() {
      mockObserverManager = new MockObserverManager();
      MockObserver mockObserver = new MockObserver();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      omsaetning.afmeldObserver(mockObserver);
      assertFalse(mockObserverManager.afmeldtObserver.contains(mockObserver));
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
      return beloeb;
    }
  }

  private class MockVareforbrug implements Vareforbrug {
      public double beloeb = 21622;
    @Override
    public void angivBeloeb(double beloeb) throws NegativBeloebException {

    }

    @Override
    public double hentBeloeb() {
      return beloeb;
    }
  }

  private class Mockafsaetning implements Afsaetning{
      public double afsaetning = 21622;

    public void angivAntal(int antal) throws NegativAntalException {

    }

    @Override
    public double hentAntal() {
      return afsaetning;
    }
  }

  private class MockSalgspris implements Salgspris {
      public double salgspris = 66666;

    @Override
    public void angivPris(double pris) throws NegativPrisException {

    }

    @Override
    public double hentPris() {
      return salgspris;
    }
  }
private class MockPrimoAarsomsaetning implements entities.PrimoAarsomsaetning {
 public double primoAarsomsaetning = 100000;

  @Override
  public void angivBeloeb(double beloeb) {

  }

  @Override
  public double hentBeloeb() {
    return primoAarsomsaetning;
  }
}

private class MockProcentstigning implements entities.Procentstigning {
public double procentstigning = 5.0;
  @Override
  public void angivDecimaltal(double decimaltal) {

  }

  @Override
  public double hentDecimaltal() {
    return procentstigning;
  }
}

}