package entities;

import java.util.LinkedHashMap;

public interface ResultatFoerRenter {
    double hentResultatFoerRenter();
    void angivAfskrivning(Afskrivning afskrivninger);
    void angivIndtjeningsbidrag(Indtjeningsbidrag indtjeningsbidrag);
}
