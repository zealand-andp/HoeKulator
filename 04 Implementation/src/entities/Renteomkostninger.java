package entities;

import entities.exceptions.NegativBeloebException;

public interface Renteomkostninger extends Observable {
    void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException;
    void angivRenteomkostningerPrimoOgProcentændring(double renteomkostningerPrimo, double procentændring) throws NegativBeloebException;
    void beregnRenteomkostninger() throws NegativBeloebException;
    double hentRenteomkostninger();
}
