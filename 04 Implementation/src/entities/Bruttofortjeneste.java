package entities;

import entities.exceptions.NegativBeloebException;

public interface Bruttofortjeneste {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    void anvendOmsaetningOgVareforbrug(Omsaetning omsaetning, Vareforbrug vareforbrug);
    double hentbeloeb();
    void hentBruttofortjeneste();
}
