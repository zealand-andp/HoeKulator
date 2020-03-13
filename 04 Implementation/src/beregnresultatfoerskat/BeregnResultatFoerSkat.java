package beregnresultatfoerskat;

import entities.Renteindtaegter;
import entities.Renteomkostninger;
import entities.ResultatFoerRenter;
import entities.ResultatFoerSkat;
import entities.exceptions.NegativBeloebException;

public interface BeregnResultatFoerSkat {
    void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException;
    void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException;
    void angivResultatFoerRenter(ResultatFoerRenter resultatFoerRenter);
    void beregnResultat();
    ResultatFoerSkat HentResultat();
    Renteindtaegter hentRenteindtaegter();
    Renteomkostninger hentRenteomkostninger();
}
