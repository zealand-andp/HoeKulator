package entities;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class OmsaetningImplTest {

  private static double DELTA = 0.001;
  private static MockObserverManager mockObserverManager;

  // UC010105

    @Test
    void anvendBruttofortjenesteOgVareforbrugOghentOmsaetning()  {
      mockObserverManager = new MockObserverManager();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      MockBruttofortjeneste bruttofortjeneste = new MockBruttofortjeneste();
      MockVareforbrug vareforbrug = new MockVareforbrug();
      vareforbrug.angivBeloeb(12698.0);
      assertEquals(12698.0, bruttofortjeneste.beloeb, DELTA);
      assertEquals(21622.0, vareforbrug.hentBeloeb(), DELTA);
      assertEquals(0, mockObserverManager.notificationsTaeller);



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
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      MockProcentstigning mockProcentstigning = new MockProcentstigning();
      MockPrimoAarsomsaetning mockPrimoAarsomsaetning = new MockPrimoAarsomsaetning();
      assertEquals(100000, mockPrimoAarsomsaetning.primoAarsomsaetning, DELTA);
      assertEquals(5.0, mockProcentstigning.procentstigning, DELTA );
      assertEquals(0, mockObserverManager.notificationsTaeller);

      omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(mockPrimoAarsomsaetning, mockProcentstigning);

      assertEquals(1, mockObserverManager.notificationsTaeller);

      double resultat = 105000;
      assertEquals(resultat, omsaetning.hentOmsaetning());



    }


    @Test
    void tilmeldObserver() {
      mockObserverManager = new MockObserverManager();
      MockObserver mockObserver = new MockObserver();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      omsaetning.tilmeldObserver(mockObserver);
      assertTrue(mockObserverManager.tilmeldtObserver.contains(mockObserver));

    }

    @Test
    void afmeldObserver() {
      mockObserverManager = new MockObserverManager();
      MockObserver mockObserver = new MockObserver();
      OmsaetningImpl omsaetning = new TestbarOmsaetning();
      omsaetning.afmeldObserver(mockObserver);
      assertTrue(mockObserverManager.afmeldtObserver.contains(mockObserver));
    }


  private static class MockObserverManager implements ObserverManager {
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

  private static class MockObserver implements Observer{

    @Override
    public void opdater(Observable observable) {

    }
  }

  private static class TestbarOmsaetning extends OmsaetningImpl {
    @Override
    protected ObserverManager newObserverManager() {
      return mockObserverManager;
    }
  }

  private static class  MockBruttofortjeneste implements Bruttofortjeneste {
    public double beloeb = 12698;
    @Override
    public void angivBeloeb(double beloeb) {

    }

    @Override
    public double hentbeloeb() {
      return beloeb;
    }
  }

  private static class MockVareforbrug implements Vareforbrug {
      private double beloeb;
      @Override
      public void angivBeloeb(double beloeb)  {
        this.beloeb = beloeb;
      }

    @Override
      public double hentBeloeb() {
      return beloeb;
    }
      }

  private static class Mockafsaetning implements Afsaetning{
      public double afsaetning = 21622;

      public void angivAntal(int antal)  {

      }

      @Override
      public double hentAntal() {
      return afsaetning;
    }
      }

  private static class MockSalgspris implements Salgspris {
      public double salgspris = 66666;

      @Override
      public void angivPris(double pris)  {

      }

      @Override
      public double hentPris() {
      return salgspris;
    }
      }
  private static class MockPrimoAarsomsaetning implements entities.PrimoAarsomsaetning {
      public double primoAarsomsaetning = 100000;

      @Override
      public void angivBeloeb(double beloeb) {

      }

      @Override
      public double hentBeloeb() {
    return primoAarsomsaetning;
  }
      }

  private static class MockProcentstigning implements entities.Procentstigning {
      public double procentstigning = 5.0;
      @Override
      public void angivDecimaltal(double procentstigning) {

      }

      @Override
      public double hentDecimaltal() {
    return procentstigning;
  }
      }

}