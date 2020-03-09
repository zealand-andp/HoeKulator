package entities;

import entities.exceptions.NegativBeloebException;

public interface Vareforbrug {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
}
