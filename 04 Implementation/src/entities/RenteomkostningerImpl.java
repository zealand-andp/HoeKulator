package entities;

import entities.exceptions.NegativBeloebException;

public class RenteomkostningerImpl implements Renteomkostninger {
    private double renteomkostningerUltimo;
    private double renteomkostningerPrimo;
    private double procentændring;
    private ObserverManager observerManager;

    public RenteomkostningerImpl() {
        observerManager = new ObserverManagerImpl();
    }

    @Override
    public void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException {
        if (renteomkostninger < 0) {
            throw new NegativBeloebException("Renteomkostninger må ikke være negative");
        }
        renteomkostningerUltimo = renteomkostninger;
        observerManager.notificerObservere(this);
    }

    @Override
    public void angivRenteomkostningerPrimoOgProcentændring(double renteomkostningerPrimo, double procentændring) throws NegativBeloebException {
        this.renteomkostningerPrimo = renteomkostningerPrimo;
        this.procentændring = procentændring;
        beregnRenteomkostninger();
    }

    @Override
    public void beregnRenteomkostninger() throws NegativBeloebException {
        renteomkostningerUltimo = renteomkostningerPrimo * (procentændring / 100 + 1);
        if (renteomkostningerUltimo < 0) {
            renteomkostningerUltimo = 0;
            throw new NegativBeloebException("Renteomkostninger må ikke være negative");
        } else {
            observerManager.notificerObservere(this);
        }
    }

    @Override
    public double hentRenteomkostninger() {
        return renteomkostningerUltimo;
    }

    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }
}
