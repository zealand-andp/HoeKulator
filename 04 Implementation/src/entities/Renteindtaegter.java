package entities;

import entities.exceptions.NegativBeloebException;

public interface Renteindtaegter {
    void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException;
    void angivRenteindtaegterPrimoOgProcentaendring(double renteindtaegterPrimo, double procentændring) throws NegativBeloebException;
    void beregnRenteindtaegter() throws NegativBeloebException;
    double hentRenteindtaegter();
}
