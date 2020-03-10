package beregnafskrivning;

public interface AfskrivningRequest {
    boolean erBeregnet();
    void angivAfskrivning(double beloeb);
    double hentAfskrivning();
    Afskrivningsmetoder hentAfskrivningsmetode();
    double hentAnskaffelsesvaerdi();
}
