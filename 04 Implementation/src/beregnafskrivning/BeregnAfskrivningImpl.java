package beregnafskrivning;

import entities.Afskrivning;
import entities.AfskrivningImpl;
import entities.Observable;
import entities.Observer;

import java.util.LinkedHashMap;

public class BeregnAfskrivningImpl implements BeregnAfskrivning, Observable {
    LinkedHashMap<String, Afskrivning> afskrivninger;
    AfskrivningImpl afskrivning;
    @Override
    public void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) {
        afskrivning.containsKey(navn);
    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
}
