package entities;

import entities.exceptions.NegativAntalException;

public class AfsaetningImpl implements Afsaetning, Observable {
    private int antal;
    private ObserverManager observerManager;

    @Override
    public void angivAntal(int antal) throws NegativAntalException {
        if (antal < 0){
            throw new NegativAntalException();
        }
        this.antal = antal;
        observerManager.notificerObservere(this);
    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
}
