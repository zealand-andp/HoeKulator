package beregnvareforbrug;

import entities.Vareforbrug;

public interface BeregnVareforbrug {
    void angivIndkoebsprisOgAfsaetning(double indkoebspris, double afsaetning);
    void angivBruttofortjenesteOgOmsaetning(double bruttofortjeneste, double omsaetning);
    void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo);
    public Vareforbrug getVareforbrug();
}
