package entities;

import entities.exceptions.NegativBeloebException;

public interface VarelagerPrimo {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
}
