package beregnKKO;

import entities.*;
import entities.exceptions.ForaeldereksistererikkeException;
import entities.exceptions.NavnEksistererException;
import entities.exceptions.NegativBeloebException;

import java.util.ArrayList;

public class BeregnKKOImpl implements BeregnKKO, Observable {
    ObserverManager observerManager;
    KKO kko;


    public void angivKKO(String navn, double beloeb, String foraeldersNavn) throws NegativBeloebException, NavnEksistererException, ForaeldereksistererikkeException{
        if (beloeb < 0) {
            throw new NegativBeloebException("Beløbet må ikke være negativt");
        }

        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaeldereksistererikkeException();
        }

        KKO nykko = new KKOImpl(navn, beloeb, foraeldersNavn);
        kko.tilføjkko(nykko);
        observerManager.notificerObservere(this);

    }

    public void angivKKO(String navn, double beloeb, String foraeldersNavn,Aendringstype aendringstype, double aendringssats) throws NegativBeloebException, NavnEksistererException, ForaeldereksistererikkeException {
        if (beloeb < 0) {
            throw new NegativBeloebException("Beløbet må ikke være negativt");
        }

        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaeldereksistererikkeException();
        }

        KKO nykko = new KKOImpl(navn, beloeb, foraeldersNavn,aendringstype, aendringssats);
        kko.tilføjkko(nykko);
        observerManager.notificerObservere(this);

    }

    public void angivKKO(String navn, String foraeldersNavn) throws NavnEksistererException, ForaeldereksistererikkeException {
        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaeldereksistererikkeException();
        }

        KKO nykko = new KKOImpl(navn, foraeldersNavn);
        kko.tilføjkko(nykko);
        observerManager.notificerObservere(this);

    }


    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }
}
