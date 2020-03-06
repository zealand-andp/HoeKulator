package beregnafskrivning;

public interface AfskrivningsRequest {
    boolean erBeregnet();
    void angivAfskrivning(double beloeb);
    double hentAfskrivning();
    Afskrivningsmetoder hentAfskrivningsmetode();
    int hentBrugstid();
    double hentScrapvaerdi();
    double hentAnskaffelsesvaedi();
}
