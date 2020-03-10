package entities;

public interface Omsaetning {
    void anvendBruttofortjenesteOgVareforbrug(Bruttofortjeneste bruttofortjeneste, Vareforbrug vareforbrug);
    void anvendAfsaetningOgSalgspris(Afsaetning afsaetning, Salgspris salgspris);
    void anvendPrimoAarsomsaetningOgProcentstigning(PrimoAarsomsaetning primoAarsomsaetning, Procentstigning procentstigning);
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    double hentOmsaetning();
}
