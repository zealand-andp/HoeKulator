package beregnindtjeningsbidrag;

public class BeregnIndtjeningsbidragImpl implements BeregnIndtjeningsbidrag {

    HentKKO kkoRequest;
    HentMarkedsfoeringsbidrag mfbRequest;
    double indtjeningsbidrag;

    @Override
    public void beregnIndtjeningsbidrag(){
       double kko = kkoRequest.hentKKO();
       double mfb = mfbRequest.hentMarkedsfoeringsbidrag();
       this.indtjeningsbidrag = mfb - kko;
    }

}
