package beregnafskrivning;

import entities.*;
import entities.exceptions.KanIkkeBeregneAfskrivningException;

import java.util.LinkedHashMap;

public class BeregnAfskrivningImpl implements BeregnAfskrivning, Observable {
    ObserverManager observerManager;
    LinkedHashMap<String, Afskrivning> afskrivninger;
    AfskrivningImpl afskrivning;

    public BeregnAfskrivningImpl() {
        observerManager = newOberserverManager();
    }

    @Override
    public void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) throws KanIkkeBeregneAfskrivningException {
       boolean afskrivningMedNavnFindes = afskrivninger.containsKey(navn);
       if (!afskrivningMedNavnFindes){
           Afskrivning afskrivning =  new AfskrivningImpl(navn);
           afskrivninger.put(navn, afskrivning);
       }
       Afskrivning afskrivning =  afskrivninger.get(navn);
       afskrivning.angivloneaerAfskrvning(anskaffelsesvaerdi,scrapvaerdi, brugstid);
       observerManager.notificerObservere(this);
    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
    protected ObserverManager newOberserverManager(){
        return new ObserverManagerImpl();
    }
}
