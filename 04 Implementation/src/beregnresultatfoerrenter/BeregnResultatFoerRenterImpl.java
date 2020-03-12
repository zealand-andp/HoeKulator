package beregnresultatfoerrenter;

import entities.*;

import java.util.LinkedHashMap;

public class BeregnResultatFoerRenterImpl implements BeregnResultatFoerRenter {
    private double resultat;

    @Override
    public void angivAfskrivningerOgIndtjeningsbidrag(LinkedHashMap<String, Afskrivning> afskrivninger, Indtjeningsbidrag indtjeningsbidrag) {
        ResultatFoerRenter resultatFoerRenter = new ResultatFoerRenterImpl(afskrivninger, indtjeningsbidrag);
        resultat = resultatFoerRenter.hentResultatFoerRenter();
    }

    @Override
    public double hentResultat() {
        return resultat;
    }
}
