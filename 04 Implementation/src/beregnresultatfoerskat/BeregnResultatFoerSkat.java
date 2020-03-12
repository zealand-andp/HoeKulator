package beregnresultatfoerskat;

import entities.ResultatFoerSkat;
import entities.exceptions.NegativBeloebException;

public interface BeregnResultatFoerSkat {
    void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException;
    void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException;
    void beregnResultat();
    ResultatFoerSkat HentResultat();
}
