package entities;

import entities.exceptions.NegativBeloebException;

public class BruttofortjenesteImpl implements Bruttofortjeneste, Observable {
    private double beloeb;
    ObserverManager observerManager;

    public BruttofortjenesteImpl() {
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
    public double hentbeloeb() {
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

    public double hentBeloeb() {
        return beloeb;
    }

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
