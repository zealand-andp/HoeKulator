package entities;

import entities.exceptions.NegativBeloebException;

public class RenteindtaegterImpl implements Renteindtaegter {
    private double renteindtaegterUltimo;
    private double renteindtaegterPrimo;
    private double procentændring;

    @Override
    public void angivRenteindtaegter(double renteindtaegter) throws NegativBeloebException {
        if (renteindtaegter < 0) {
            throw new NegativBeloebException("Renteindtægter må ikke være negative.");
        }
        renteindtaegterUltimo = renteindtaegter;
    }

    @Override
    public void angivRenteindtaegterPrimoOgProcentaendring(double renteindtaegterPrimo, double procentændring) throws NegativBeloebException {
        this.procentændring = procentændring;
        this.renteindtaegterPrimo = renteindtaegterPrimo;
        beregnRenteindtaegter();
    }

    @Override
    public void beregnRenteindtaegter() throws NegativBeloebException {
        renteindtaegterUltimo = renteindtaegterPrimo * (procentændring / 100 + 1);
        if (renteindtaegterUltimo < 0) {
            renteindtaegterUltimo = 0;
            throw new NegativBeloebException("Renteindtægter må ikke være negative.");
        }
    }

    @Override
    public double hentRenteindtaegter() {
        return renteindtaegterUltimo;
    }
}
