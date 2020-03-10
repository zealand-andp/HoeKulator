package beregnafskrivning;

import entities.*;
import entities.exceptions.*;

import java.util.LinkedHashMap;

public class BeregnAfskrivningImpl implements BeregnAfskrivning, Observable {
    ObserverManager observerManager;
    LinkedHashMap<String, Afskrivning> afskrivninger;
    AfskrivningImpl afskrivning;

    public BeregnAfskrivningImpl() {
        observerManager = newOberserverManager();
    }

    @Override
    public void angivLinearAfskrivning(String navn, int brugstid,
                                       double scrapvaerdi, double anskaffelsesvaerdi) throws KanIkkeBeregneAfskrivningException, NegativVaerdiException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativBeloebException, NegativAfskrivningsprocentException {
       boolean afskrivningMedNavnFindes = afskrivninger.containsKey(navn);
       if (!afskrivningMedNavnFindes){
           Afskrivning afskrivning =  new AfskrivningImpl(navn);
           afskrivninger.put(navn, afskrivning);
       }
       Afskrivning afskrivning =  afskrivninger.get(navn);
       afskrivning.angivLineaerAfskrivning(anskaffelsesvaerdi,scrapvaerdi, brugstid);
       observerManager.notificerObservere(this);
    }

    @Override
    public void angivStraksafskrivning(String navn, int anskaffelsesvaerdi) throws NegativBeloebException, OverMaksbeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativAfskrivningsprocentException, NegativVaerdiException {
        boolean afskrivningMedNavnFindes = afskrivninger.containsKey(navn);
        if (!afskrivningMedNavnFindes) {
            Afskrivning afskrivning = new AfskrivningImpl(navn);
            afskrivning.put(navn, afskrivning);
        }
        Afskrivning afskrivning = afskrivninger.get(navn);
        afskrivning.angivStraksafskrivning(anskaffelsesvaerdi);
        observerManager.notificerObservere(this);
    }


    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }
    protected ObserverManager newOberserverManager(){
        return new ObserverManagerImpl();
    }
}
