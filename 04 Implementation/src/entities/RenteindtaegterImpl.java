package entities;

import entities.exceptions.NegativBeloebException;

public class RenteindtaegterImpl implements Renteindtaegter {
    private double renteindtaegterUltimo;
    private double renteindtaegterPrimo;
    private double procentændring;
    private ObserverManager observerManager;

    public RenteindtaegterImpl() {
        observerManager = new ObserverManagerImpl();
    }


    @Override
    public void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException {
        if (renteindtaegter < 0) {
            throw new NegativBeloebException("Renteindtægter må ikke være negative.");
        }
        renteindtaegterUltimo = renteindtaegter;
        observerManager.notificerObservere(this);
    }

    @Override
    public void angivRenteindtaegterPrimoOgProcentaendring(double renteindtaegterPrimo, double procentændring) throws NegativBeloebException {
        this.procentændring = procentændring;
        this.renteindtaegterPrimo = renteindtaegterPrimo;
        beregnRenteindtaegter();
    }

    @Override
    public void beregnRenteindtaegter() throws NegativBeloebException {
        renteindtaegterUltimo = renteindtaegterPrimo * (procentændring / 100 + 1);
        if (renteindtaegterUltimo < 0) {
            renteindtaegterUltimo = 0;
            throw new NegativBeloebException("Renteindtægter må ikke være negative.");
        } else {
            observerManager.notificerObservere(this);
        }
    }

    @Override
    public double hentRenteindtaegter() {
        return renteindtaegterUltimo;
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
