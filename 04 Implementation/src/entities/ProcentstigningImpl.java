package entities;

public class ProcentstigningImpl implements Procentstigning, Observable {
    private double decmaltal;
    ObserverManager observerManager;

    public ProcentstigningImpl() {observerManager = newObserverManager();}


    @Override
    public void angivDecimaltal(double decimaltal) {
        this.decmaltal = decimaltal;
        observerManager.notificerObservere(this);

    }

    @Override
    public double hentDecimaltal() {
        return decmaltal;
    }

    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }

    protected ObserverManager newObserverManager() { return new ObserverManagerImpl();}


}
