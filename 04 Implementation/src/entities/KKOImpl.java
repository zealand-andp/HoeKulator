package entities;

import entities.exceptions.ForaeldereksistererikkeException;
import entities.exceptions.NavnEksistererException;
import entities.exceptions.NegativBeloebException;

import java.util.ArrayList;

public class KKOImpl implements KKO, Observable{
    private ObserverManager observerManager;

    private String navn;
    double beloeb;
    private String foraeldersNavn;
    ArrayList<KKO> efterfoelgerer;
    Aendringstype aendringstype;
    double aendringssats;

    public KKOImpl() {
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, String foraeldersNavn) {
        this.navn = navn;
        this.foraeldersNavn = foraeldersNavn;
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, double beloeb, String foraeldersNavn) {
        this.navn = navn;
        this.beloeb = beloeb;
        this.foraeldersNavn = foraeldersNavn;
        observerManager = newObserverManager();
    }

    public KKOImpl(String navn, double beloeb, String foraeldersNavn, Aendringstype aendringstype, double aendringssats) {
        this.navn = navn;
        this.beloeb = beloeb;
        this.foraeldersNavn = foraeldersNavn;
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
            for (int i = 0; i < efterfoelgerer.size(); i++) {
                efterfoelgerer.get(i).navnEksisterer(navn);
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
            for (int i = 0; i < efterfoelgerer.size(); i++) {
                efterfoelgerer.get(i).navnEksisterer(foraeldersNavn);
            }
        }
        return false;
    }

    @Override
    public void tilføjkko(KKO nykko) {
        for (int i = 0; i < efterfoelgerer.size(); i++) {
            if (efterfoelgerer.get(i).getNavn().equals(nykko.getForaeldersNavn())) {
                efterfoelgerer.add(nykko);
            }
            else {
                efterfoelgerer.get(i).tilføjkko(nykko);
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

    public String getNavn() {
        return navn;
    }

    public String getForaeldersNavn() {
        return foraeldersNavn;
    }
}
