package beregnresultatfoerrenter;

import entities.*;

import java.util.LinkedHashMap;

public class BeregnResultatFoerRenterImpl implements BeregnResultatFoerRenter {
    private double resultat;
    private ResultatFoerRenter resultatFoerRenter;

    @Override
    public void angivAfskrivningerOgIndtjeningsbidrag(LinkedHashMap<String, Afskrivning> afskrivninger, Indtjeningsbidrag indtjeningsbidrag) {
        resultatFoerRenter = new ResultatFoerRenterImpl(afskrivninger, indtjeningsbidrag);
        resultat = resultatFoerRenter.hentResultatFoerRenter();
    }

    @Override
    public ResultatFoerRenter hentResultat() {
        return resultatFoerRenter;
    }
}
