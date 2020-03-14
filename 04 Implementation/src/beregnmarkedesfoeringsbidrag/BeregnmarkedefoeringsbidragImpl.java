//package beregnmarkedesfoeringsbidrag;
//
//import entities.Bruttofortjeneste;
//import entities.Observer;
//import entities.ObserverManager;
//import entities.ObserverManagerImpl;
//import entities.exceptions.NegativBeloebException;
//
//public class BeregnmarkedefoeringsbidragImpl implements Beregnmarkedefoeringsbidrag {
//    double beloeb;
//    ObserverManager observerManager;
//    private entities.Bruttofortjeneste Bruttofortjeneste;
//
//
//    @Override
//    public double hentMarkedefoeringsbidrag(){
//        double markedefoeringsbidrag ;
//        Bruttofortjeneste = new Bruttofortjeneste() {
//            @Override
//            public void angivBeloeb(double beloeb) throws NegativBeloebException {
//
//            }
//
//            @Override
//            public double hentBeloeb() {
//                return beloeb;
//            }
//        };
//        return beloeb;
//    }
//
//    public void tilmeldObserver(Observer observer){
//        observerManager.tilmeldObserver(observer);
//    }
//
//    public void afmeldobserver(Observer observer){
//        observerManager.afmeldObserver(observer);
//
//    }
//
//    @Override
//    public void angivBeloeb(double beloeb) throws NegativBeloebException {
//
//    }
//
//    @Override
//    public double hentBeloeb() {
//        return beloeb;
//    }
//
//    protected ObserverManager observerManager(){
//        return new ObserverManagerImpl();
//    }
//}
