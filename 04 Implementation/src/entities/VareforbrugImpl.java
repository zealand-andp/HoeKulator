package entities;

import entities.exceptions.NegativBeloebException;

public class VareforbrugImpl implements Vareforbrug, Observable {
    private Indkoebspris indkoebspris;
    private Afsaetning afsaetning;
    private Bruttofortjeneste bruttofortjeneste;
    private Omsaetning omsaetning;
    private VarelagerPrimo varelagerPrimo;
    private Varekoeb varekoeb;
    private VarelagerUltimo varelagerUltimo;
    private double beloeb;
    private ObserverManager observerManager;

    public VareforbrugImpl(){
        observerManager = newObserverManager();
    }

    @Override
    public void angivBeloeb(double beloeb) throws NegativBeloebException {
        if (beloeb < 0) {
           throw new NegativBeloebException("Beløbet må ikke være negativt");

        }
        this.beloeb = beloeb;
        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendIndkoebprisOgAfsaetning(Indkoebspris indkoebspris, Afsaetning afsaetning) {
        this.indkoebspris = indkoebspris;
        this.afsaetning = afsaetning;
        this.bruttofortjeneste = null;
        this.omsaetning = null;
        this.varelagerPrimo = null;
        this.varekoeb = null;
        this.varelagerUltimo = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendBruttofortjenesteOgOmsaetning(Bruttofortjeneste bruttofortjeneste, Omsaetning omsaetning) {
        this.indkoebspris = null;
        this.afsaetning = null;
        this.bruttofortjeneste = bruttofortjeneste;
        this.omsaetning = omsaetning;
        this.varelagerPrimo = null;
        this.varekoeb = null;
        this.varelagerUltimo = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(VarelagerPrimo varelagerPrimo, Varekoeb varekoeb, VarelagerUltimo varelagerUltimo) {
        this.indkoebspris = null;
        this.afsaetning = null;
        this.bruttofortjeneste = null;
        this.omsaetning = null;
        this.varelagerPrimo = varelagerPrimo;
        this.varekoeb = varekoeb;
        this.varelagerUltimo = varelagerUltimo;

        observerManager.notificerObservere(this);
    }

    @Override
    public double hentBeloeb() {
        return beloeb;
    }

    public double hentVareforbrug() {
        if (indkoebspris != null && afsaetning != null) {
            beloeb = indkoebspris.hentPris()*afsaetning.hentAntal();

        }

        else if (bruttofortjeneste != null && omsaetning != null) {
            beloeb = omsaetning.hentBeloeb()-bruttofortjeneste.hentBeloeb();

        }

        else if (varelagerPrimo != null && varekoeb != null && varelagerUltimo != null) {
            beloeb = varelagerPrimo.hentBeloeb()+varekoeb.hentBeloeb()-varelagerUltimo.hentBeloeb();

        }

        return beloeb;
    }

    @Override
    public void tilmeldObserver(Observer observer) { observerManager.tilmeldObserver(observer);


    }

    @Override
    public void afmeldObserver(Observer observer) {
            observerManager.afmeldObserver(observer);
    }

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
