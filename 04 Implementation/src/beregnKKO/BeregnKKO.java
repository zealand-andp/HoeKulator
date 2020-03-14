package beregnKKO;

import entities.Aendringstype;
import entities.exceptions.*;

public interface BeregnKKO {
void angivKKO(String navn, double beloeb, String foraeldersNavn) throws NegativBeloebException, NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException;
void angivKKO(String navn, double beloeb, String foraeldersNavn, Aendringstype aendringstype, double aendringssats) throws NegativBeloebException, NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException;
void angivKKO(String navn, String foraeldersNavn) throws NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException;

}
