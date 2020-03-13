package entities;

import entities.exceptions.ForaelderEksistererIkkeException;
import entities.exceptions.NavnEksistererException;
import entities.exceptions.NegativBeloebException;

public interface KKO {
    boolean navnEksisterer(String navn);
    boolean foraelderEksisterer(String foraeldersNavn);
    void tilfoejKKO(KKO nyKKO);
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    String hentNavn();
    String hentForaeldersNavn();
}
