package entities;

import entities.exceptions.ForaelderEksistererIkkeException;
import entities.exceptions.NavnEksistererException;

import java.util.ArrayList;

public interface KKO {
    boolean navnEksisterer(String navn);
    boolean foraelderEksisterer(String foraeldersNavn);
    void tilfoejKKO(KKO nyKKO) throws NavnEksistererException, ForaelderEksistererIkkeException;
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    String hentNavn();
    String hentForaeldersNavn();
    KKO hentKKO(String navn);
    ArrayList<KKO> hentEfterfoelgere();
    double hentBeloeb();
}
