package entities;

public class SkatteprocentImpl implements Skatteprocent {
    private double vaerdi;
    private ObserverManager observerManager;

    public SkatteprocentImpl() {
        observerManager = newObserverManager();
    }

    @Override
    public void angivSkatteprocent(double vaerdi) {
        this.vaerdi = vaerdi;
    }

    @Override
    public double hentVaerdi() {
        return vaerdi;
    }

    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
