package entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultatFoerRenterImpl implements ResultatFoerRenter, Observable {
    private double resultat;
    private ObserverManager observerManager;
    private Afskrivning afskrivninger;
    private Indtjeningsbidrag indtjeningsbidrag;

    public ResultatFoerRenterImpl(){
        observerManager = newObserverManager();
    }

    @Override
    public double hentResultatFoerRenter() {
        double afskrivingsbeloeb = afskrivninger.hentAfskrivningsvaerdi();
        double indtjeningsbidragBeloeb = indtjeningsbidrag.hentBeloeb();
        resultat = indtjeningsbidragBeloeb - afskrivingsbeloeb;
        return resultat;
    }

    @Override
    public void angivAfskrivning(Afskrivning afskrivninger) {
        this.afskrivninger = afskrivninger;
    }

    @Override
    public void angivIndtjeningsbidrag(Indtjeningsbidrag indtjeningsbidrag) {
        this.indtjeningsbidrag = indtjeningsbidrag;
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
