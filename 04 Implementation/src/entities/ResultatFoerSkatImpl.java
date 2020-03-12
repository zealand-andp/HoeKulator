package entities;

public class ResultatFoerSkatImpl implements ResultatFoerSkat, Observable {
    private ObserverManager observerManager;
    private ResultatFoerRenter resultatFoerRenter;
    private Renteindtaegter renteindtaegter;
    private Renteomkostninger renteomkostninger;
    private double resultat;

    public ResultatFoerSkatImpl() {
        observerManager = new ObserverManagerImpl();
    }

    @Override
    public void angivRenteindtaegter(Renteindtaegter renteindtaegter) {
        this.renteindtaegter = renteindtaegter;
    }

    @Override
    public void angivRenteomkostninger(Renteomkostninger renteomkostninger) {
        this.renteomkostninger = renteomkostninger;
    }

    @Override
    public void angivResultatFoerRenter(ResultatFoerRenter resultatFoerRenter) {
        this.resultatFoerRenter = resultatFoerRenter;
    }

    @Override
    public void hentResultatFoerSkat() {
            double ri = renteindtaegter.hentRenteindtaegter();
            double ro = renteomkostninger.hentRenteomkostninger();
            double rfr = resultatFoerRenter.hentResultatFoerRenter();
            resultat = rfr - ro + ri;
        }

    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }
}
