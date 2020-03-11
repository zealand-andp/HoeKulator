package entities;


import entities.exceptions.NegativPrisException;

public interface Indkoebspris {
    void angivPris(double pris) throws NegativPrisException;
    double hentPris();

}
