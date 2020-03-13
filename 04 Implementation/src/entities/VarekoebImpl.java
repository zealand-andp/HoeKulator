package entities;

public class VarekoebImpl implements Varekoeb, Observable {
    private double beloeb;
    ObserverManager observerManager;

    public VarekoebImpl() {observerManager = newObserverManager();}

    @Override
    public void angivBeloeb(double beloeb) {
        this.beloeb = beloeb;
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentBeloeb() {
        return beloeb;
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
