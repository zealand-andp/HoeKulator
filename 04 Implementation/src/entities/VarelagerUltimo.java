package entities;

import entities.exceptions.NegativBeloebException;

public interface VarelagerUltimo {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
}
