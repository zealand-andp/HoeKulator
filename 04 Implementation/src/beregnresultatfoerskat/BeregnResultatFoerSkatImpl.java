package beregnresultatfoerskat;

import entities.*;
import entities.exceptions.NegativBeloebException;

public class BeregnResultatFoerSkatImpl implements BeregnResultatFoerSkat {
    private RenteindtaegterImpl renteindtaegter;
    private RenteomkostningerImpl renteomkostninger;
    private ResultatFoerRenterImpl resultatFoerRenter;
    private ResultatFoerSkatImpl resultatFoerSkat;

    public BeregnResultatFoerSkatImpl() {
        renteindtaegter = new RenteindtaegterImpl();
        renteomkostninger = new RenteomkostningerImpl();
        resultatFoerSkat = new ResultatFoerSkatImpl();
    }

    public void angivResultatFoerRenter(ResultatFoerRenterImpl resultatFoerRenter) {
        this.resultatFoerRenter = resultatFoerRenter;
    }

    @Override
    public void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException {
        this.renteindtaegter.angivRenteindtaegter(renteindtaegter);
    }

    @Override
    public void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException {
        this.renteomkostninger.angivRenteomkostninger(renteomkostninger);
    }

    @Override
    public void beregnResultat() {
        resultatFoerSkat.angivRenteindtaegter(renteindtaegter);
        resultatFoerSkat.angivRenteomkostninger(renteomkostninger);
        resultatFoerSkat.angivResultatFoerRenter(resultatFoerRenter);
        resultatFoerSkat.hentResultatFoerSkat();
    }

    @Override
    public ResultatFoerSkat HentResultat() {
        return resultatFoerSkat;
    }
}
