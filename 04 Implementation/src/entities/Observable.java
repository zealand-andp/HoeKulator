// TODO Tilføj JavaDoc der forklarer at Observable skal være super interface for alle entities.

package entities;

public interface Observable {
    void tilmeldObserver(Observer observer);
    void afmeldObserver(Observer observer);
}
