package beregnbruttofortjeneste;

import entities.Bruttofortjeneste;
import entities.Omsaetning;
import entities.Vareforbrug;
import entities.exceptions.NegativBeloebException;

public interface BeregnBruttofortjeneste {
    void angivOmsaetningOgVareforbrug(double omsaetning, double vareforbrug) throws NegativBeloebException;
}
