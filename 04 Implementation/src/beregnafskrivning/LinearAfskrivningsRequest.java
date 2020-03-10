package beregnafskrivning;

public interface
LinearAfskrivningsRequest extends AfskrivningRequest {
    int hentBrugstid();
    double hentScrapvaerdi();
}
