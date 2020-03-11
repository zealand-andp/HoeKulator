package entities;

public class VareforbrugImpl implements Vareforbrug, Observable {
    private ObserverManager observerManager;
    private Bruttofortjeneste bruttofortjeneste;
    private Omsaetning omsaetning;
    private Indkoebspris indkoebspris;
    private Afsaetning afsaetning;
    private VarelagerPrimo varelagerPrimo;
    private VarelagerUltimo varelagerUltimo;
    private Varekoeb varekoeb;
    private double beloeb;

    public VareforbrugImpl(){observerManager = newObserverManager();}

    @Override
    public void anvendIndkoebsprisOgAfsaetning(Indkoebspris indkoebspris, Afsaetning afsaetning){
        this.indkoebspris = indkoebspris;
        this.afsaetning = afsaetning;
        this.bruttofortjeneste = null;
        this.omsaetning = null;
        this.varelagerPrimo = null;
        this.varelagerUltimo = null;
        this.varekoeb = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendBruttofortjenesteOgOmsætning(Bruttofortjeneste bruttofortjeneste, Omsaetning omsaetning){
        this.bruttofortjeneste = bruttofortjeneste;
        this.omsaetning = omsaetning;
        this.indkoebspris = null;
        this.afsaetning = null;
        this.varelagerPrimo = null;
        this.varelagerUltimo = null;
        this.varekoeb = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public void anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(VarelagerPrimo varelagerPrimo, Varekoeb varekoeb, VarelagerUltimo varelagerUltimo){
        this.varelagerPrimo = varelagerPrimo;
        this.varelagerUltimo = varelagerUltimo;
        this.varekoeb = varekoeb;
        this.bruttofortjeneste = null;
        this.omsaetning = null;
        this.indkoebspris = null;
        this.afsaetning = null;

        observerManager.notificerObservere(this);
    }

    @Override
    public double hentVareforbrug() {
        if (indkoebspris != null && afsaetning != null){
            beloeb = indkoebspris.hentPris()*afsaetning.hentAntal();
        }
        else if (bruttofortjeneste != null && omsaetning != null){
            beloeb = omsaetning.hentOmsaetning() - bruttofortjeneste.hentBeloeb();
        }
        else if (varelagerPrimo != null && varekoeb != null && varelagerUltimo != null){
            beloeb = (varelagerPrimo.hentBeloeb()+varekoeb.hentBeloeb()) - varelagerUltimo.hentBeloeb();
        }
        return beloeb;
    }


    @Override
    public void tilmeldObserver(Observer observer){ observerManager.tilmeldObserver(observer);}

    @Override
    public void afmeldObserver(Observer observer) { observerManager.afmeldObserver(observer);}


    protected ObserverManager newObserverManager() { return new ObserverManagerImpl();}

}
