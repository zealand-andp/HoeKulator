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
    private PrimoAarsomsaetning primoAarsomsaetning;
    private Procentstigning procentstigning;

    public BeregnOmsaetningImpl() {
        vareforbrug = new VareforbrugImpl();
        bruttofortjeneste = new BruttofortjenesteImpl();
        afsaetning = new AfsaetningImpl();
        salgspris = new SalgsprisImpl();
        omsaetning = new OmsaetningImpl();
        primoAarsomsaetning = new PrimoAarsomsaetningImpl();
        procentstigning = new ProcentstigningImpl();
    }

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

    @Override
    public void angivPrimoAarsomsaetningOgProcentstigning(double primoAarsomsaetning, double procentstigning) {
        this.primoAarsomsaetning.angivBeloeb(primoAarsomsaetning);
        this.procentstigning.angivDecimaltal(procentstigning);
        this.omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(this.primoAarsomsaetning, this.procentstigning);
    }

    public Omsaetning getOmsaetning() {
        return omsaetning;
    }
}
