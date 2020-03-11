package beregnresultatfoerrenter;

import entities.Afskrivning;
import entities.Indtjeningsbidrag;
import entities.ResultatFoerRenter;

import java.util.LinkedHashMap;
import java.util.Map;

public class BeregnResultatFoerRenterImpl implements BeregnResultatFoerRenter {
    Afskrivning afskrivning;
    Indtjeningsbidrag indtjeningsbidrag;
    ResultatFoerRenter resultatFoerRenter;

    @Override
    public void angivAfskrivningerOgIndtjeningsbidrag(LinkedHashMap<String, Afskrivning> afskrivninger, Indtjeningsbidrag indtjeningsbidrag) {
        double afskrivningSum = 0;
        for (Map.Entry<String, Afskrivning> entry : afskrivninger.entrySet()) {
            afskrivningSum += entry.getValue().hentAfskrivningsvaerdi();
        }
    }
}
