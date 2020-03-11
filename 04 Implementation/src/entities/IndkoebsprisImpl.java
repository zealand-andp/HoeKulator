package entities;


import entities.exceptions.NegativPrisException;

public class IndkoebsprisImpl implements Indkoebspris, Observable {
    private double pris;
    ObserverManager observerManager;

    public IndkoebsprisImpl(){ observerManager = newObserverManager();}


    @Override
    public void angivPris (double pris) throws NegativPrisException{
        if (pris < 0){
            throw new NegativPrisException("Beløbet må ikke være negativt");
        }
        this.pris = pris;
        observerManager.notificerObservere(this);
    }


    @Override
    public void tilmeldObserver(Observer observer) { observerManager.tilmeldObserver(observer);}

    @Override
    public void afmeldObserver(Observer observer) {observerManager.afmeldObserver(observer); }

    public double hentPris(){ return pris; }

    protected ObserverManager newObserverManager(){ return new ObserverManagerImpl(); }
}
