package beregnvareforbrug;

import entities.Vareforbrug;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public interface BeregnVareforbrug {
    void angivIndkoebsprisOgAfsaetning(double indkoebspris, int afsaetning) throws NegativPrisException, NegativAntalException;
    void angivBruttofortjenesteOgOmsaetning(double bruttofortjeneste, double omsaetning) throws NegativBeloebException;
    void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo);
    public Vareforbrug getVareforbrug();
}
