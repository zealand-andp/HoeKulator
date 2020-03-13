package beregnomsaetning;

import entities.Omsaetning;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public interface BeregnOmsaetning {
    void angivBruttofortjenesteOgVareforbrug(double bruttofortjeneste, double vareforbrug) throws NegativBeloebException;
    void angivAfsaetningOgSalgspris(double salgspris, int afsaetning) throws NegativAntalException, NegativPrisException;
    void angivPrimoAarsomsaetningOgProcentstigning(double primoAarsomsaetning, double procentstigning);
    public Omsaetning getOmsaetning();
}
