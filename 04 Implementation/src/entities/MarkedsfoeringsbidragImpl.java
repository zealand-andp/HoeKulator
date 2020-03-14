package entities;

public class MarkedsfoeringsbidragImpl implements Markedsfoeringsbidrag {
    private ObserverManager observerManager;
    private double beloeb;

    public MarkedsfoeringsbidragImpl() {
        observerManager = newObserverManager();
    }


    @Override
    public void angivBeloeb(double beloeb) {
        this.beloeb = beloeb;
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
        afmeldObserver(observer);
    }

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
