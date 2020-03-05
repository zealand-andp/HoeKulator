package entities;

import entities.exceptions.NegativBeloebException;

public class VareforbrugImpl implements Vareforbrug, Observable {
    private double beloeb;
    ObserverManager observerManager;
    public VareforbrugImpl(){
        observerManager = newObserverManager();
    }

    @Override
    public void angivBeloeb(double beloeb) throws NegativBeloebException {
        if (beloeb < 0) {
           throw new NegativBeloebException();

        }
        this.beloeb = beloeb;
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentBeloeb() {
        return beloeb;
    }

    @Override
    public void tilmeldObserver(Observer observer) { observerManager.tilmeldObserver(observer);


    }

    @Override
    public void afmeldObserver(Observer observer) {
            observerManager.afmeldObserver(observer);
    }
    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
