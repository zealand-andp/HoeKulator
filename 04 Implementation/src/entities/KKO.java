package entities;

import entities.exceptions.ForaeldereksistererikkeException;
import entities.exceptions.NavnEksistererException;
import entities.exceptions.NegativBeloebException;

public interface KKO {
    boolean navnEksisterer(String navn);
    boolean foraelderEksisterer(String foraeldersNavn);
    void tilføjkko(KKO nykko);
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
    String getNavn();
    String getForaeldersNavn();
}
