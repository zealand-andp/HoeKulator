package entities;

public interface Resultat extends Observable {
    void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat);
    void angivSkatteprocent(Skatteprocent skatteprocent);
    void beregnResultat();
    double hentBeloeb();
}
