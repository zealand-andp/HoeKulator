package beregnbruttofortjeneste;

import entities.*;
import entities.exceptions.NegativBeloebException;

public class BeregnBruttofortjenesteImpl implements BeregnBruttofortjeneste {
    private Omsaetning omsaetning;
    private Vareforbrug vareforbrug;
    private Bruttofortjeneste bruttofortjeneste;

    public BeregnBruttofortjenesteImpl(){
        omsaetning = new OmsaetningImpl();
        vareforbrug = new VareforbrugImpl();
        bruttofortjeneste = new BruttofortjenesteImpl();
    }

    @Override
    public void angivOmsaetningOgVareforbrug(double omsaetning, double vareforbrug) throws NegativBeloebException {
        this.omsaetning.angivBeloeb(omsaetning);
        this.vareforbrug.angivBeloeb(vareforbrug);
        this.bruttofortjeneste.anvendOmsaetningOgVareforbrug(this.omsaetning, this.vareforbrug);
    }

    @Override
    public Bruttofortjeneste getBruttofortjeneste() {
        return bruttofortjeneste;
    }
}
