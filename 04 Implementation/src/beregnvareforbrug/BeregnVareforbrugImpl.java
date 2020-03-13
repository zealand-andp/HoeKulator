package beregnvareforbrug;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public class BeregnVareforbrugImpl implements BeregnVareforbrug{
    private Indkoebspris indkoebspris;
    private Afsaetning afsaetning;
    private Bruttofortjeneste bruttofortjeneste;
    private Omsaetning omsaetning;
    private VarelagerPrimo varelagerPrimo;
    private VarekoebImpl varekoeb;
    private VarelagerUltimo varelagerUltimo;
    private Vareforbrug vareforbrug;

    public BeregnVareforbrugImpl(){
        indkoebspris = new IndkoebsprisImpl();
        afsaetning = new AfsaetningImpl();
        bruttofortjeneste = new BruttofortjenesteImpl();
        omsaetning = new OmsaetningImpl();
        varelagerPrimo = new VarelagerPrimoImpl();
        varekoeb = new VarekoebImpl();
        varelagerUltimo = new VarelagerUltimoImpl();
    }

    @Override
    public void angivIndkoebsprisOgAfsaetning(double indkoebspris, int afsaetning) throws NegativPrisException, NegativAntalException {
        this.indkoebspris.angivPris(indkoebspris);
        this.afsaetning.angivAntal(afsaetning);
        this.vareforbrug.anvendIndkoebprisOgAfsaetning(this.indkoebspris, this.afsaetning);
    }

    @Override
    public void angivBruttofortjenesteOgOmsaetning(double bruttofortjeneste, double omsaetning) throws NegativBeloebException {
        this.bruttofortjeneste.angivBeloeb(bruttofortjeneste);
        this.omsaetning.angivBeloeb(omsaetning);
        this.vareforbrug.anvendBruttofortjenesteOgOmsaetning(this.bruttofortjeneste,this.omsaetning);
    }

    @Override
    public void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo) {
        this.varelagerPrimo.angivBeloeb(varelagerPrimo);
        this.varekoeb.angivBeloeb(varekoeb);
        this.varelagerUltimo.angivBeloeb(varelagerUltimo);
        this.vareforbrug.anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(this.varelagerPrimo, this.varekoeb, this.varelagerUltimo);
    }

    @Override
    public Vareforbrug getVareforbrug() {
        return vareforbrug;
    }
}
