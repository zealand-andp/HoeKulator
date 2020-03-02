package entities;

public class PrimoAarsomsaetningImpl implements PrimoAarsomsaetning, Observable {
    private double beloeb;
    ObserverManager observerManager;

    @Override
    public void angivBeloeb(double beloeb) {
        this.beloeb = beloeb;
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentBeloeb() {
return beloeb;
    }

    public double getBeloeb() {
        return beloeb;
    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }


}
