package entities;

public class OmsaetningImpl implements Omsaetning, Observable {
    private ObserverManager observerManager;
    private Bruttofortjeneste bruttofortjeneste;
    private Vareforbrug vareforbrug;
    private PrimoAarsomsaetning primoAarsomsaetning;
    private Procentstigning procentstigning;
    private Afsaetning afsaetning;
    private Salgspris salgspris;

    @Override
    public void anvendBruttofortjenesteOgVareforbrug(Bruttofortjeneste bruttofortjeneste, Vareforbrug vareforbrug) {
        this.bruttofortjeneste = bruttofortjeneste;
        this.vareforbrug = vareforbrug;
        this.primoAarsomsaetning = null;
        this.procentstigning = null;
        this.afsaetning = null;
        this.salgspris = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendAfsaetningOgSalgspris(Afsaetning afsaetning, Salgspris salgspris) {
        this.afsaetning = afsaetning;
        this.salgspris = salgspris;
        this.primoAarsomsaetning = null;
        this.procentstigning = null;
        this.bruttofortjeneste = null;
        this.vareforbrug = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
}