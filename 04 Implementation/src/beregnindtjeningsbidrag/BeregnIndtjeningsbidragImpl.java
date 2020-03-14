package beregnindtjeningsbidrag;

import beregnKKO.BeregnKKO;
import entities.Indtjeningsbidrag;
import entities.IndtjeningsbidragImpl;
import entities.KKO;
import entities.Markedsfoeringsbidrag;

public class BeregnIndtjeningsbidragImpl implements BeregnIndtjeningsbidrag {
    BeregnKKO kko;
    Markedsfoeringsbidrag markedsfoeringsbidrag;
    Indtjeningsbidrag indtjeningsbidrag;

    BeregnIndtjeningsbidragImpl() {
        indtjeningsbidrag = new IndtjeningsbidragImpl();
    }

    @Override
    public void beregnIndtjeningsbidrag(){
       if (markedsfoeringsbidrag != null || kko != null) {
           double resultat = markedsfoeringsbidrag.hentBeloeb() - kko.hentAlleBeloeb();
           indtjeningsbidrag.angivBeloeb(resultat);
       }
    }

    @Override
    public void angivKKO(BeregnKKO kko) {
        this.kko = kko;
    }

    @Override
    public void angivMarkedsfoeringsBidrag(Markedsfoeringsbidrag markedsfoeringsbidrag) {
        this.markedsfoeringsbidrag = markedsfoeringsbidrag;
    }

    @Override
    public Indtjeningsbidrag hentIndtjeningsbidrag() {
        return indtjeningsbidrag;
    }

}
