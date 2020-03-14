package entities;

import entities.exceptions.ForaelderEksistererIkkeException;
import entities.exceptions.NavnEksistererException;

public interface KKO {
    boolean navnEksisterer(String navn);
    boolean foraelderEksisterer(String foraeldersNavn);
    void tilfoejKKO(KKO nyKKO) throws NavnEksistererException, ForaelderEksistererIkkeException;
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    String hentNavn();
    String hentForaeldersNavn();
    KKO hentKKO(String navn);
}
