package entities;

import entities.exceptions.NegativBeloebException;

public interface Varekoeb {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
}
