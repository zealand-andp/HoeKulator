package entities;


public interface Indtjeningsbidrag extends Observable {
    void angivBeloeb(double beloeb);
    double hentBeloeb();
}
