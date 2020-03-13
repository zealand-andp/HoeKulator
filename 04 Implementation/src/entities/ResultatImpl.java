package entities;

public class ResultatImpl implements Resultat {
    private ObserverManager observerManager;
    private ResultatFoerSkat resultatFoerSkat;
    private Skatteprocent skatteprocent;
    private double beloeb;

    public ResultatImpl() {
        observerManager = newObserverManager();
    }

    @Override
    public void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat) {
        this.resultatFoerSkat = resultatFoerSkat;
    }

    @Override
    public void angivSkatteprocent(Skatteprocent skatteprocent) {
        this.skatteprocent = skatteprocent;
    }

    @Override
    public void beregnResultat() {
        if (resultatFoerSkat == null) {
            return;
        }
        if (skatteprocent == null) {
            skatteprocent = new SkatteprocentImpl();
        }
        beloeb = resultatFoerSkat.hentResultatFoerSkat() - (resultatFoerSkat.hentResultatFoerSkat() * skatteprocent.hentVaerdi() / 100);
        observerManager.notificerObservere(this);
    }

    @Override
    public double hentBeloeb() {
        return beloeb;
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
