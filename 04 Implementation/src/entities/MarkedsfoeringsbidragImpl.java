package entities;

public class MarkedsfoeringsbidragImpl implements Markedsfoeringsbidrag, Observable {

    @Override
    public void hentMarkedsfoeringsbidrag() {

    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
