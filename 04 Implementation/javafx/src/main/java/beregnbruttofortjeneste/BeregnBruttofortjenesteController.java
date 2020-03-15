package beregnbruttofortjeneste;

import entities.Bruttofortjeneste;
import entities.Observable;
import entities.Observer;
import entities.exceptions.NegativBeloebException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnBruttofortjenesteController {
    private GrundUIController grundUIController;
    private BeregnBruttofortjenesteImpl beregnBruttofortjeneste;

    @FXML
    private TextField bruttofortjenesteTf, omsaetningTf, vareforbrugTf;

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void beregn() throws NegativBeloebException {
        double omsaetningInput = Double.parseDouble(omsaetningTf.getText());
        double vareforbrugInput = Double.parseDouble(vareforbrugTf.getText());
        beregnBruttofortjeneste.angivOmsaetningOgVareforbrug(omsaetningInput, vareforbrugInput);
        grundUIController.tilfoejBruttofortjenesteTilResultatBudget();
        grundUIController.getOmsaetningResultatLabel().setText(String.valueOf(omsaetningInput));
        grundUIController.getVareforbrugResultatLabel().setText(String.valueOf(vareforbrugInput));
    }

    public void setBeregnBruttofortjeneste(BeregnBruttofortjenesteImpl beregnBruttofortjeneste) {
        this.beregnBruttofortjeneste = beregnBruttofortjeneste;
        this.beregnBruttofortjeneste.getBruttofortjeneste().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Bruttofortjeneste) {
                    double changed = ((Bruttofortjeneste) observable).hentBruttofortjeneste();
                    bruttofortjenesteTf.setText(String.valueOf(changed));
                }
            }
        });
    }
}
