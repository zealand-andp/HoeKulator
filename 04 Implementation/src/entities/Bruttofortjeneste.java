package entities;

import entities.exceptions.NegativBeloebException;

public interface Bruttofortjeneste {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    double hentBeloeb();
    void anvendOmsaetningOgVareforbrug(Omsaetning omsaetning, Vareforbrug vareforbrug);
    void hentBruttofortjeneste();
}
