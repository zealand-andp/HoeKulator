package entities;

import entities.exceptions.NegativAntalException;

public interface Afsaetning extends Observable {
    void angivAntal(int antal) throws NegativAntalException;
    double hentAntal();
}
