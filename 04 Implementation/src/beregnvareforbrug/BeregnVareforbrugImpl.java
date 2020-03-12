package beregnvareforbrug;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;

public class BeregnVareforbrugImpl implements BeregnVareforbrug {
    private ObserverManager observerManager;
    private Bruttofortjeneste bruttofortjeneste;
    private Omsaetning omsaetning;
    private Indkoebspris indkoebspris;
    private Afsaetning afsaetning;
    private VarelagerPrimo varelagerPrimo;
    private VarelagerUltimo varelagerUltimo;
    private Varekoeb varekoeb;
    private Vareforbrug vareforbrug;

    @Override
    public void angivIndkoebsprisOgAfsaetning(double indkoebspris, int afsaetning) throws NegativAntalException, NegativPrisException {
        this.indkoebspris.angivPris(indkoebspris);
        this.afsaetning.angivAntal(afsaetning);
        this.vareforbrug.anvendIndkoebsprisOgAfsaetning(this.indkoebspris, this.afsaetning);
    }

    @Override
    public void angivBruttofortjenesteOgOmsætning(double bruttofortjeneste, double omsaetning) throws NegativBeloebException {
        this.bruttofortjeneste.angivBeloeb(bruttofortjeneste);
        this.omsaetning.hentOmsaetning(omsaetning); //omsætningen skal være resultatet man får efter beregn omsætning
        this.vareforbrug.anvendBruttofortjenesteOgOmsætning(this.bruttofortjeneste, this.omsaetning);
    }

    @Override
    public void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo ) throws NegativBeloebException {
        this.varelagerPrimo.angivBeloeb(varelagerPrimo);
        this.varekoeb.angivBeloeb(varekoeb);
        this.varelagerUltimo.angivBeloeb(varelagerUltimo);
        this.vareforbrug.anvendVarelagerPrimoOgVarekoebOgVarelagerUltimo(this.varelagerPrimo, this.varekoeb, this.varelagerUltimo);
    }
}
