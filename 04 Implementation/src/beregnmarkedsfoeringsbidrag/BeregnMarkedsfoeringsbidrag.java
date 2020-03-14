package beregnmarkedsfoeringsbidrag;

import beregnsso.BeregnSSO;
import entities.Bruttofortjeneste;
import entities.Markedsfoeringsbidrag;
import entities.exceptions.NegativBeloebException;

public interface BeregnMarkedsfoeringsbidrag {
    void angivSSO(BeregnSSO sso);
    void angivBruttofortjeneste(Bruttofortjeneste bruttofortjeneste);
    void angivBruttofortjenesteOgSSO(double bruttofortjeneste, double sso) throws NegativBeloebException;
    void beregnMarkedsfoeringsbidrag();
    Markedsfoeringsbidrag hentMarkedsfoeringsbidrag();
}
