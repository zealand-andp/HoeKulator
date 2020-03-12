package entities;

import entities.exceptions.NegativBeloebException;

public interface Bruttofortjeneste {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
    double hentBruttofortjeneste();
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    void anvendOmsaetningOgVareforbrug(Omsaetning omsaetning, Vareforbrug vareforbrug);
}
