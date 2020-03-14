package beregnKKO;

import entities.*;
import entities.exceptions.*;

public class BeregnKKOImpl implements BeregnKKO, Observable {
    ObserverManager observerManager;
    KKO kko;

    public BeregnKKOImpl() {
        observerManager = newObserverManager();
        kko = new KKOImpl();
    }


    public void angivKKO(String navn, double beloeb, String foraeldersNavn) throws NegativBeloebException, NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException {
        if (beloeb < 0) {
            throw new NegativBeloebException("Beløbet må ikke være negativt");
        }

        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaelderEksistererIkkeException();
        }

        KKO nykko = new KKOImpl(navn, beloeb, foraeldersNavn);
        kko.tilfoejKKO(nykko);
        observerManager.notificerObservere(this);

    }

    public void angivKKO(String navn, double beloeb, String foraeldersNavn,Aendringstype aendringstype, double aendringssats) throws NegativBeloebException, NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException {
        if (beloeb < 0) {
            throw new NegativBeloebException("Beløbet må ikke være negativt");
        }

        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaelderEksistererIkkeException();
        }

        KKO nykko = new KKOImpl(navn, beloeb, foraeldersNavn,aendringstype, aendringssats);
        kko.tilfoejKKO(nykko);
        observerManager.notificerObservere(this);

    }

    public void angivKKO(String navn, String foraeldersNavn) throws NavnEksistererException, ForaelderEksistererIkkeException, ManglendeForaelderNavnException, ManglendeNavnException {
        if (kko.navnEksisterer(navn)) {
            throw new NavnEksistererException();
        }

        if (!kko.foraelderEksisterer(foraeldersNavn)) {
            throw new ForaelderEksistererIkkeException();
        }

        KKO nykko = new KKOImpl(navn, foraeldersNavn);
        kko.tilfoejKKO(nykko);
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

    protected ObserverManager newObserverManager() {
        return new ObserverManagerImpl();
    }
}
