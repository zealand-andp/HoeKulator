package beregnresultatfoerrenter;

import entities.Afskrivning;
import entities.Indtjeningsbidrag;
import entities.ResultatFoerRenter;

import java.util.LinkedHashMap;

public interface BeregnResultatFoerRenter {
    void angivAfskrivningerOgIndtjeningsbidrag(LinkedHashMap<String, Afskrivning> afskrivninger, Indtjeningsbidrag indtjeningsbidrag);
    ResultatFoerRenter hentResultat();
}
