package entities;

import entities.exceptions.NegativAntalException;

public class AfsaetningImpl implements Afsaetning {
    private int antal = 0;
    private ObserverManager observerManager;

    public AfsaetningImpl() {
        observerManager = newObserverManager();
    }

    @Override
    public void angivAntal(int antal) throws NegativAntalException {
        if (antal < 0){
            throw new NegativAntalException();
        }
        this.antal = antal;
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentAntal() {
        return antal;
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
