package beregnmarkedsfoeringsbidrag;

import entities.Markedsfoeringsbidrag;
import entities.Observable;
import entities.Observer;
import entities.exceptions.NegativBeloebException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnMarkedsfoeringsbidragController {
    private GrundUIController grundUIController;
    private BeregnMarkedsfoeringsbidrag beregnMarkedsfoeringsbidrag;

    @FXML
    private TextField bruttofortjenesteTf, ssoTf, markedsfoeringsbidragTf;

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void beregn() throws NegativBeloebException {
        double bruttofortjenesteInput = Double.parseDouble(bruttofortjenesteTf.getText());
        double ssoInput = Double.parseDouble(ssoTf.getText());
        beregnMarkedsfoeringsbidrag.angivBruttofortjenesteOgSSO(bruttofortjenesteInput, ssoInput);
    }

    public void setBeregnMarkedsfoeringsbidrag(BeregnMarkedsfoeringsbidrag beregnMarkedsfoeringsbidrag) {
        this.beregnMarkedsfoeringsbidrag = beregnMarkedsfoeringsbidrag;
        this.beregnMarkedsfoeringsbidrag.hentMarkedsfoeringsbidrag().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Markedsfoeringsbidrag) {
                    double changed = ((Markedsfoeringsbidrag) observable).hentBeloeb();
                    markedsfoeringsbidragTf.setText(String.valueOf(changed));
                }
            }
        });
    }
}
