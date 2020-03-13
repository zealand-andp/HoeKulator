package entities;

import entities.exceptions.NegativBeloebException;

public interface Vareforbrug {
    void angivBeloeb(double beloeb) throws NegativBeloebException;
    void anvendIndkoebprisOgAfsaetning(Indkoebspris indkoebspris, Afsaetning afsaetning);
    void anvendBruttofortjenesteOgOmsaetning(Bruttofortjeneste bruttofortjeneste, Omsaetning omsaetning);
    void anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(VarelagerPrimo varelagerPrimo, Varekoeb varekoeb, VarelagerUltimo varelagerUltimo);
    double hentBeloeb();
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    double hentVareforbrug();
}
