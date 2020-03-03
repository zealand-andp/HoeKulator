package entities;

public interface Observable {
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
}
