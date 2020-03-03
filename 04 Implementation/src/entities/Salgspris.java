package entities;

import entities.exceptions.NegativPrisException;

public interface Salgspris {

    void angivPris(double pris) throws NegativPrisException;
    double hentPris();
}
