package beregnafskrivning;

public class LinearAfskrivningsRequestImpl implements LinearAfskrivningsRequest, AfskrivningsRequest {
    int brugstid;
    double scrapvaerdi;
    double anskaffelsesvaerdi;
    Afskrivningsmetoder afskrivningsmetode;


    public LinearAfskrivningsRequestImpl(int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) {
        this.brugstid = brugstid;
        this.scrapvaerdi = scrapvaerdi;
        this.anskaffelsesvaerdi = anskaffelsesvaerdi;
        afskrivningsmetode = Afskrivningsmetoder.LINEAER;
    }

    @Override
    public boolean erBeregnet() {
        return false;
    }

    @Override
    public void angivAfskrivning(double beloeb) {

    }

    @Override
    public double hentAfskrivning() {
        return 0;
    }

    @Override
    public Afskrivningsmetoder hentAfskrivningsmetode() {
        return null;
    }

    @Override
    public int hentBrugstid() {
        return 0;
    }

    @Override
    public double hentScrapvaerdi() {
        return 0;
    }

    @Override
    public double hentAnskaffelsesvaedi() {
        return 0;
    }
}
