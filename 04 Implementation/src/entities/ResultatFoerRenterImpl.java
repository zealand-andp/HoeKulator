package entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultatFoerRenterImpl implements ResultatFoerRenter, Observable {
    private double resultat;
    private ObserverManager observerManager;
    private LinkedHashMap<String, Afskrivning> afskrivninger;
    private Indtjeningsbidrag indtjeningsbidrag;

    public ResultatFoerRenterImpl(LinkedHashMap<String, Afskrivning> afskrivninger, Indtjeningsbidrag indtjeningsbidrag) {
        this.afskrivninger = afskrivninger;
        this.indtjeningsbidrag = indtjeningsbidrag;
        observerManager = newObserverManager();
    }

    public ResultatFoerRenterImpl() {
        resultat = 0;
    }

    @Override
    public double hentResultatFoerRenter() {
        double afskrivingsbeloeb = 0;
        if (afskrivninger != null) {
            for (Map.Entry<String, Afskrivning> entry : afskrivninger.entrySet()) {
                afskrivingsbeloeb += entry.getValue().hentAfskrivningsvaerdi();
            }
        }
        if (indtjeningsbidrag != null) {
            double indtjeningsbidragBeloeb = indtjeningsbidrag.hentBeloeb();
            resultat = indtjeningsbidragBeloeb - afskrivingsbeloeb;
        }
        return resultat;
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
