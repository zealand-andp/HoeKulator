package beregnmarkedesfoeringsbidrag;

import beregnsso.BeregnSSO;
import beregnsso.BeregnSSOImpl;
import entities.*;
import entities.exceptions.NegativBeloebException;

public class BeregnMarkedsfoeringsbidragImpl implements BeregnMarkedsfoeringsbidrag {
    private BeregnSSO sso;
    private Bruttofortjeneste bruttofortjeneste;
    private Markedsfoeringsbidrag markedsfoeringsbidrag;

    public BeregnMarkedsfoeringsbidragImpl() {
        sso = new BeregnSSOImpl();
        bruttofortjeneste = new BruttofortjenesteImpl();
        markedsfoeringsbidrag = new MarkedsfoeringsbidragImpl();
    }

    @Override
    public void angivSSO(BeregnSSO sso) {
        this.sso = sso;
    }

    @Override
    public void angivBruttofortjeneste(Bruttofortjeneste bruttofortjeneste) {
        this.bruttofortjeneste = bruttofortjeneste;
    }

    @Override
    public void angivBruttofortjenesteOgSSO(double bruttofortjeneste, double sso) throws NegativBeloebException {
        this.bruttofortjeneste.angivBeloeb(bruttofortjeneste);
        this.sso.angivSum(sso);
        beregnMarkedsfoeringsbidrag();
    }

    @Override
    public void beregnMarkedsfoeringsbidrag() {
        if (sso != null && bruttofortjeneste != null) {
            markedsfoeringsbidrag.angivBeloeb(bruttofortjeneste.hentBeloeb() - sso.hentSum());
        }
    }

    @Override
    public Markedsfoeringsbidrag hentMarkedsfoeringsbidrag() {
        return markedsfoeringsbidrag;
    }
}
