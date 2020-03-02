package entities;

public interface Omsaetning {
    void anvendBruttofortjenesteOgVareforbrug(Bruttofortjeneste bruttofortjeneste, Vareforbrug vareforbrug);

    void anvendAfsaetningOgSalgspris(Afsaetning afsaetning, Salgspris salgspris);
}
