package beregnvareforbrug;

import entities.*;

public class BeregnVareforbrugImpl implements BeregnVareforbrug{
    private Indkoebspris indkoebspris;
    private Afsaetning afsaetning;
    private Bruttofortjeneste bruttofortjeneste;
    private Omsaetning omsaetning;
    private VarelagerPrimo varelagerPrimo;
    private VarekoebImpl varekoeb;
    private VarelagerUltimo varelagerUltimo;

    @Override
    public void angivIndkoebsprisOgAfsaetning(double indkoebspris, double afsaetning) {

    }

    @Override
    public void angivBruttofortjenesteOgOmsaetning(double bruttofortjeneste, double omsaetning) {

    }

    @Override
    public void angivVarelagerPrimoOgVarekoebOgVarelagerUltimo(double varelagerPrimo, double varekoeb, double varelagerUltimo) {

    }

    @Override
    public Vareforbrug getVareforbrug() {
        return null;
    }
}
