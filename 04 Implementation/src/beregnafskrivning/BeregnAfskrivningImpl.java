package beregnafskrivning;

import entities.Afskrivning;

import java.util.LinkedHashMap;

public class BeregnAfskrivningImpl implements BeregnAfskrivning{
    LinkedHashMap<String, Afskrivning> afskrivninger;

    @Override
    public void angivLinearAfskrivning(String navn, int brugstid, double scrapvaerdi, double anskaffelsesvaerdi) {

    }
}
