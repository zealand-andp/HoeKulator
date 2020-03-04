package entities;

import java.util.ArrayList;

public class ObserverManagerImpl implements ObserverManager {
    private ArrayList<Observer> observers = new ArrayList<>();
    @Override
    public void tilmeldObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificerObservere(Observable observable) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).opdater(this);
        }
    }
}
