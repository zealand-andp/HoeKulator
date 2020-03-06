package entities;

public interface Afskrivning {
    void containsKey(String navn);
    void get(String navn);
    void put(String navn, Afskrivning afskrivning);
    void angivloneaerAfskrvning(double anskaffelsesvaerdi);
}
