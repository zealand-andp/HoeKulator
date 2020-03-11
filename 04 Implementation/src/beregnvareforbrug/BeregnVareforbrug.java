package beregnvareforbrug;

import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public interface BeregnVareforbrug {
    void angivIndkoebsprisOgAfsaetning(double indkoebspris, int afsaetning) throws NegativAntalException, NegativPrisException;
    void angivBruttofortjenesteOgOmsætning(double bruttofortjeneste, double omsaetning) throws NegativBeloebException;
    void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo ) throws NegativBeloebException;
}
