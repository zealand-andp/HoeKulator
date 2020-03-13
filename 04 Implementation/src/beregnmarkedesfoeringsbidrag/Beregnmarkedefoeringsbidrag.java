package beregnmarkedesfoeringsbidrag;

import entities.Bruttofortjeneste;
import entities.exceptions.NegativBeloebException;
import entities.Observer;
import entities.ObserverManager;

public interface Beregnmarkedefoeringsbidrag extends Bruttofortjeneste {
    double hentMarkedefoeringsbidrag();

    @Override
    void angivBeloeb(double beloeb) throws NegativBeloebException;

    @Override
    double hentBeloeb();



}
