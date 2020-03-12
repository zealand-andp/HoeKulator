package beregnresultatfoerskat;

import entities.*;
import entities.exceptions.NegativBeloebException;

public class BeregnResultatFoerSkatImpl implements BeregnResultatFoerSkat {
    private Renteindtaegter renteindtaegter;
    private Renteomkostninger renteomkostninger;
    private ResultatFoerRenter resultatFoerRenter;
    private ResultatFoerSkat resultatFoerSkat;

    public BeregnResultatFoerSkatImpl() {
        renteindtaegter = new RenteindtaegterImpl();
        renteomkostninger = new RenteomkostningerImpl();
        resultatFoerSkat = new ResultatFoerSkatImpl();
    }

    public void angivResultatFoerRenter(ResultatFoerRenter resultatFoerRenter) {
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
        if (resultatFoerRenter == null) {
            resultatFoerRenter = new ResultatFoerRenterImpl();
        }
        resultatFoerSkat.angivRenteindtaegter(renteindtaegter);
        resultatFoerSkat.angivRenteomkostninger(renteomkostninger);
        resultatFoerSkat.angivResultatFoerRenter(resultatFoerRenter);
        resultatFoerSkat.hentResultatFoerSkat();
    }

    @Override
    public ResultatFoerSkat HentResultat() {
        return resultatFoerSkat;
    }

    @Override
    public Renteindtaegter hentRenteindtaegter() {
        return renteindtaegter;
    }

    @Override
    public Renteomkostninger hentRenteomkostninger() {
        return renteomkostninger;
    }
}
