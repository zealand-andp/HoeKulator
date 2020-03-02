package beregnomsaetning;

import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public interface BeregnOmsaetning {
    void angivBruttofortjenesteOgVareforbrug(double bruttofortjeneste, double vareforbrug) throws NegativBeloebException;
    void angivAfsaetningOgSalgspris(double salgspris, int afsaetning) throws NegativAntalException, NegativPrisException;
}
