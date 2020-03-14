package beregnindtjeningsbidrag;

import beregnKKO.BeregnKKO;
import beregnKKO.BeregnKKOImpl;
import entities.*;

public class BeregnIndtjeningsbidragImpl implements BeregnIndtjeningsbidrag {
    BeregnKKO kko;
    Markedsfoeringsbidrag markedsfoeringsbidrag;
    Indtjeningsbidrag indtjeningsbidrag;

    public BeregnIndtjeningsbidragImpl() {
        indtjeningsbidrag = new IndtjeningsbidragImpl();
        markedsfoeringsbidrag = new MarkedsfoeringsbidragImpl();
        kko = new BeregnKKOImpl();
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
    public void angivMarkedsfoeringsbidragOgKKO(double markedsfoeringsbidrag, double kko) {
        this.markedsfoeringsbidrag.angivBeloeb(markedsfoeringsbidrag);
        this.kko.angivSum(kko);
        beregnIndtjeningsbidrag();
    }

    @Override
    public Indtjeningsbidrag hentIndtjeningsbidrag() {
        return indtjeningsbidrag;
    }

}
