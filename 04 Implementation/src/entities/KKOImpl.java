package entities;

import entities.exceptions.ForaelderEksistererIkkeException;
import entities.exceptions.ManglendeForaelderNavnException;
import entities.exceptions.ManglendeNavnException;
import entities.exceptions.NavnEksistererException;

import java.util.ArrayList;

public class KKOImpl implements KKO, Observable{
    private ObserverManager observerManager;

    private String navn;
    private double beloeb;
    private String foraeldersNavn;
    private ArrayList<KKO> efterfoelgere = new ArrayList<>();
    private Aendringstype aendringstype;
    private double aendringssats;

    public KKOImpl() {
        navn = "Kontante kapacitetsomkostninger";
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, String foraeldersNavn) throws ManglendeNavnException, ManglendeForaelderNavnException {
        if (navn == null || navn.equals("")) {
            throw new ManglendeNavnException();
        }
        if (foraeldersNavn == null || foraeldersNavn.equals("")) {
            throw new ManglendeForaelderNavnException();
        }
        this.navn = navn;
        this.foraeldersNavn = foraeldersNavn;
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, double beloeb, String foraeldersNavn) throws ManglendeNavnException, ManglendeForaelderNavnException {
        this(navn, foraeldersNavn);
        this.beloeb = beloeb;
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, double beloeb, String foraeldersNavn, Aendringstype aendringstype, double aendringssats) throws ManglendeNavnException, ManglendeForaelderNavnException {
        this(navn, beloeb, foraeldersNavn);
        this.aendringstype = aendringstype;
        this.aendringssats = aendringssats;
        observerManager = newObserverManager();
    }

    @Override
    public boolean navnEksisterer(String navn) {
        if (navn.equals(this.navn)) {
            return true;
        }
        else {
            for (int i = 0; i < efterfoelgere.size(); i++) {
                if (efterfoelgere.get(i).navnEksisterer(navn)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean foraelderEksisterer(String foraeldersNavn) {
        if (foraeldersNavn.equals(this.foraeldersNavn)) {
            return true;
        }
        else {
            for (int i = 0; i < efterfoelgere.size(); i++) {
                if (efterfoelgere.get(i).foraelderEksisterer(foraeldersNavn)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void tilfoejKKO(KKO nyKKO) throws NavnEksistererException, ForaelderEksistererIkkeException {
        tilfoejGaranteretUnikOgForaelderhavendeKKO(nyKKO);
    }

    private void tilfoejGaranteretUnikOgForaelderhavendeKKO(KKO nyKKO) throws NavnEksistererException, ForaelderEksistererIkkeException {
        if (nyKKO.hentForaeldersNavn().equals(this.navn)) {
            for (int i = 0; i < efterfoelgere.size(); i++) {
                if (efterfoelgere.get(i).navnEksisterer(nyKKO.hentNavn())) {
                    throw new NavnEksistererException();
                }
            }
            efterfoelgere.add(nyKKO);
        }
        else {
            for (int i = 0; i < efterfoelgere.size(); i++) {
                if (navnEksisterer(nyKKO.hentNavn())) {
                    throw new NavnEksistererException();
                }
                if (!foraelderEksisterer(nyKKO.hentForaeldersNavn())) {
                    throw new ForaelderEksistererIkkeException();
                }
                ((KKOImpl) efterfoelgere.get(i)).tilfoejGaranteretUnikOgForaelderhavendeKKO(nyKKO);
            }
        }
    }
    
    @Override
    public void tilmeldObserver(Observer observer) {
        observerManager.tilmeldObserver(observer);
    }

    @Override
    public void afmeldObserver(Observer observer) {
        observerManager.afmeldObserver(observer);
    }


    protected  ObserverManager newObserverManager(){
        return new ObserverManagerImpl();
    }

    public String hentNavn() {
        return navn;
    }

    public String hentForaeldersNavn() {
        return foraeldersNavn;
    }

    @Override
    public KKO hentKKO(String navn) {
        for (int i = 0; i < efterfoelgere.size(); i++) {
            if (efterfoelgere.get(i).hentNavn().equals(navn)) {
                return efterfoelgere.get(i);
            }
        }
        return null;
    }
}
