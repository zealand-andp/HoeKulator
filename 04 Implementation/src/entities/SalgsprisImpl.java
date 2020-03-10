package entities;

import entities.exceptions.NegativPrisException;

public class SalgsprisImpl implements Salgspris, Observable {
    private double pris;
    private ObserverManager observerManager;

    public SalgsprisImpl() {
        observerManager = newObserverManager();
    }

    @Override
    public void angivPris(double pris) throws NegativPrisException {
        if (pris < 0){
            throw new NegativPrisException("Prisen må ikke være negativ");
        }
        this.pris = pris;
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentPris() {
        return pris;
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
