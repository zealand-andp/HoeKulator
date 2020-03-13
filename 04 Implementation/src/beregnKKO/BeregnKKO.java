package beregnKKO;

import entities.Aendringstype;
import entities.exceptions.ForaelderEksistererIkkeException;
import entities.exceptions.NavnEksistererException;
import entities.exceptions.NegativBeloebException;

public interface BeregnKKO {
void angivKKO(String navn, double beloeb, String foraeldersNavn) throws NegativBeloebException, NavnEksistererException, ForaeldereksistererikkeException;
void angivKKO(String navn, double beloeb, String foraeldersNavn, Aendringstype aendringstype, double aendringssats) throws NegativBeloebException, NavnEksistererException, ForaeldereksistererikkeException;
void angivKKO(String navn, String foraeldersNavn) throws NavnEksistererException, ForaeldereksistererikkeException;

}
