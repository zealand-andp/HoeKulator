package entities;

import entities.exceptions.NegativPrisException;

public class SalgsprisImpl implements Salgspris, Observable {
    private double pris;
    private ObserverManager observerManager;

    @Override
    public void angivPris(double pris) throws NegativPrisException {
        if (pris < 0){
            throw new NegativPrisException();
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

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
}
