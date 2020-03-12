package entities;

import entities.exceptions.NegativBeloebException;

public class RenteomkostningerImpl implements Renteomkostninger {
    private double renteomkostningerUltimo;
    private double renteomkostningerPrimo;
    private double procentændring;

    @Override
    public void angivRenteomkostninger(double renteomkostninger) throws NegativBeloebException {
        if (renteomkostninger < 0) {
            throw new NegativBeloebException("Renteomkostninger må ikke være negative");
        }
        renteomkostningerPrimo = renteomkostninger;
    }

    @Override
    public void angivRenteomkostningerPrimoOgProcentændring(double renteomkostningerPrimo, double procentændring) {
        this.renteomkostningerPrimo = renteomkostningerPrimo;
        this.procentændring = procentændring;
    }

    @Override
    public void beregnRenteomkostninger() throws NegativBeloebException {
        renteomkostningerUltimo = renteomkostningerPrimo * (procentændring / 100 + 1);
        if (renteomkostningerUltimo < 0) {
            renteomkostningerUltimo = 0;
            throw new NegativBeloebException("Renteomkostninger må ikke være negative");
        }
    }

    @Override
    public double hentRenteomkostninger() {
        return renteomkostningerUltimo;
    }
}
