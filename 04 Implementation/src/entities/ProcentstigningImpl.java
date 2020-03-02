package entities;

public class ProcentstigningImpl implements Procentstigning, Observable {
    private double decmaltal;
    ObserverManager observerManager;

    @Override
    public void angivDecimaltal(double decimaltal) {
        this.decmaltal = decimaltal;
        observerManager.notificerObservere(this);

    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }


}
