package entities;


public interface Vareforbrug {
    void anvendIndkoebsprisOgAfsaetning(Indkoebspris indkoebspris, Afsaetning afsaetning);
    void anvendBruttofortjenesteOgOmsætning(Bruttofortjeneste bruttofortjeneste, Omsaetning omsaetning);
    void anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(VarelagerPrimo varelagerPrimo, Varekoeb varekoeb, VarelagerUltimo varelagerUltimo);
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    double hentVareforbrug();
}
