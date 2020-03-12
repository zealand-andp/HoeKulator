package entities;

public interface ResultatFoerSkat extends Observable {
    void angivRenteindtaegter(Renteindtaegter renteindtaegter);
    void angivRenteomkostninger(Renteomkostninger renteomkostninger);
    void angivResultatFoerRenter(ResultatFoerRenter resultatFoerRenter);
    double hentResultatFoerSkat();
}
