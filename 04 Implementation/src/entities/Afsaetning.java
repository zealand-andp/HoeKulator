package entities;

import entities.exceptions.NegativAntalException;

public interface Afsaetning {
    void angivAntal(int antal) throws NegativAntalException;
    double hentAntal();
}
