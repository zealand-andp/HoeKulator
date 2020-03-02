package beregnomsaetning;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public class BeregnOmsaetningImpl implements BeregnOmsaetning {
    private Vareforbrug vareforbrug;
    private Bruttofortjeneste bruttofortjeneste;
    private Afsaetning afsaetning;
    private Salgspris salgspris;
    private Omsaetning omsaetning;

    @Override
    public void angivBruttofortjenesteOgVareforbrug(double bruttofortjeneste, double vareforbrug) throws NegativBeloebException {
        this.vareforbrug.angivBeloeb(vareforbrug);
        this.bruttofortjeneste.angivBeloeb(bruttofortjeneste);
        this.omsaetning.anvendBruttofortjenesteOgVareforbrug(this.bruttofortjeneste, this.vareforbrug);
    }

    @Override
    public void angivAfsaetningOgSalgspris(double salgspris, int afsaetning) throws NegativAntalException, NegativPrisException {
        this.afsaetning.angivAntal(afsaetning);
        this.salgspris.angivPris(salgspris);
        this.omsaetning.anvendAfsaetningOgSalgspris(this.afsaetning, this.salgspris);
    }
}
