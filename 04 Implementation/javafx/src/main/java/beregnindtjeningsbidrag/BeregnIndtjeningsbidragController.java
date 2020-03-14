package beregnindtjeningsbidrag;

import beregnbruttofortjeneste.BeregnBruttofortjenesteImpl;
import entities.Bruttofortjeneste;
import entities.Indtjeningsbidrag;
import entities.Observable;
import entities.Observer;
import entities.exceptions.NegativBeloebException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnIndtjeningsbidragController {
    private GrundUIController grundUIController;
    private BeregnIndtjeningsbidrag beregnIndtjeningsbidrag;

    @FXML
    private TextField mfbTf, kkoTf, indtjeningsbidragTf;

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void beregn() {
        double mfbTfInput = Double.parseDouble(mfbTf.getText());
        double kkoTfInput = Double.parseDouble(kkoTf.getText());
        beregnIndtjeningsbidrag.angivMarkedsfoeringsbidragOgKKO(mfbTfInput, kkoTfInput);
        grundUIController.tilfoejBruttofortjenesteTilResultatBudget();
    }

    public void setBeregnIndtjeningsbidrag(BeregnIndtjeningsbidrag beregnIndtjeningsbidrag) {
        this.beregnIndtjeningsbidrag = beregnIndtjeningsbidrag;
        this.beregnIndtjeningsbidrag.hentIndtjeningsbidrag().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Indtjeningsbidrag) {
                    double changed = ((Indtjeningsbidrag) observable).hentBeloeb();
                    indtjeningsbidragTf.setText(String.valueOf(changed));
                }
            }
        });
    }
}
