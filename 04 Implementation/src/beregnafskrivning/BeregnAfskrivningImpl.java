package beregnafskrivning;

import entities.Afskrivning;
import entities.Observable;
import entities.Observer;

import java.util.LinkedHashMap;

public class BeregnAfskrivningImpl implements BeregnAfskrivning, Observable {
    LinkedHashMap<String, Afskrivning> afskrivninger;

    @Override
    public void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) {

    }

    @Override
    public void tilmeldObserver(Observer observer) {

    }

    @Override
    public void afmeldObserver(Observer observer) {

    }
}
