package entities;

public interface Skatteprocent extends Observable {
    void angivSkatteprocent(double vaerdi);
    double hentVaerdi();
}
