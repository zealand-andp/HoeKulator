package entities;

import entities.exceptions.NegativBeloebException;

public interface Renteomkostninger {
    void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException;
    void angivRenteomkostningerPrimoOgProcentændring(double renteomkostningerPrimo, double procentændring);
    void beregnRenteomkostninger() throws NegativBeloebException;
    double hentRenteomkostninger();
}
