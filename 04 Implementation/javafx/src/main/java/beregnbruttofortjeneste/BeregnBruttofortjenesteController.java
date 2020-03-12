package beregnbruttofortjeneste;

import beregnomsaetning.BeregnOmsaetningImpl;
import entities.Bruttofortjeneste;
import entities.Observable;
import entities.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnBruttofortjenesteController {
    private GrundUIController grundUIController;
    private BeregnBruttofortjenesteImpl beregnBruttofortjeneste;

    @FXML
    private TextField bruttofortjenesteTf;

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void setBeregnBruttofortjeneste(BeregnBruttofortjenesteImpl beregnBruttofortjeneste) {
        this.beregnBruttofortjeneste = beregnBruttofortjeneste;
        this.beregnBruttofortjeneste.getBruttofortjeneste().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Bruttofortjeneste) {
                    double changed = ((Bruttofortjeneste) observable).hentBruttofortjeneste();
//                    bruttofortjenesteTf.setText(String.valueOf(changed));
//                    grundUIController.tilfoejOmsaetningTilResultatBudget();
                }
            }
        });
    }
}
