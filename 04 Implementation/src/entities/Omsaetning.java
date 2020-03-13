package entities;

import entities.exceptions.NegativBeloebException;

public interface Omsaetning {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    void anvendBruttofortjenesteOgVareforbrug(Bruttofortjeneste bruttofortjeneste, Vareforbrug vareforbrug);
    void anvendAfsaetningOgSalgspris(Afsaetning afsaetning, Salgspris salgspris);
    void anvendPrimoAarsomsaetningOgProcentstigning(PrimoAarsomsaetning primoAarsomsaetning, Procentstigning procentstigning);
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    double hentBeloeb();
    double hentOmsaetning();
}
