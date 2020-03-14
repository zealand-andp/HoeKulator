package beregnresultat;

import entities.Observable;
import entities.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnSkatteprocentController {
    private GrundUIController grundUIController;
    private BeregnResultat beregnResultat;

    @FXML
    private TextField skatteprocentTf;

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void setBeregnResultat(BeregnResultat beregnResultat) {
        this.beregnResultat = beregnResultat;
    }

    public void angiv() {
        beregnResultat.angivSkatteprocent(Double.parseDouble(skatteprocentTf.getText()));
        grundUIController.opdaterSkatteprocent();
    }
}
