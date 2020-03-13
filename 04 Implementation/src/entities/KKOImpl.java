//package entities;
//
//import entities.exceptions.ForaeldereksistererikkeException;
//import entities.exceptions.NavnEksistererException;
//import entities.exceptions.NegativBeloebException;
//
//public class KKOImpl implements KKO, Observable{
//    private ObserverManager observerManager;
//    String navn;
//    double beloeb;
//    String foraeldersNavn;
//    //     KKO[] efterfoelgerer;
//    Aendringstype aendringstype;
//    double aendringssats;
//
//    public KKOImpl() {
//        observerManager = newObserverManager();
//    }
//
//
//    public void angivKKO(String navn, double beloeb, String foraeldersNavn){
//        this.navn = navn;
//        this.beloeb = beloeb;
//        this.foraeldersNavn = foraeldersNavn;
//    }
//
//    public void angivKKO(String navn, double beloeb, String foraeldersNavn,String aendringstype, double aendringssats){
//        this.navn = navn;
//        this.beloeb = beloeb;
//        this.foraeldersNavn = foraeldersNavn;
//        this.aendringstype = aendringstype;
//        this.aendringssats = aendringssats;
//    }
//
//    public void angivKKO(String navn, String foraeldersNavn){
//        this.navn = navn;
//        this.foraeldersNavn = foraeldersNavn;
//
//        observerManager.notificerObservere(this);
//    }
//
//    @Override
//    public void tilmeldObserver(Observer observer) {
//        observerManager.tilmeldObserver(observer);
//    }
//
//    @Override
//    public void afmeldObserver(Observer observer) {
//        observerManager.afmeldObserver(observer);
//    }
//
//
//    protected  ObserverManager newObserverManager(){
//        return new ObserverManagerImpl();
//    }
//
//}
