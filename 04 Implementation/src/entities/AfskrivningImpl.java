package entities;

import beregnafskrivning.LinearAfskrivningsRequest;

public class AfskrivningImpl implements Afskrivning {
    private String navn;
    private int brugstid;
    private double scrapvaerdi;
    private double afskrivningsvaerdi;

    public AfskrivningImpl(String navn) {
        this.navn = navn;


    }


    @Override
    public void containsKey(String navn) {
    }

    @Override
    public void get(String navn) {

    }

    @Override
    public void put(String navn, Afskrivning afskrivning) {

    }

    @Override
    public void angivloneaerAfskrvning(double anskaffelsesvaerdi) {
        this.afskrivningsvaerdi = anskaffelsesvaerdi;
        LinearAfskrivningsRequest linearAfskrivningsRequest = new
    }
}
