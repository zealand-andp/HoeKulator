package beregnresultatfoerskat;

import entities.Observable;
import entities.Observer;
import entities.Renteindtaegter;
import entities.RenteindtaegterImpl;
import entities.exceptions.NegativBeloebException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnRenteindtaegterController {
    private BeregnResultatFoerSkat beregnResultatFoerSkat;
    private GrundUIController grundUIController;

    @FXML
    private TextField rentePrimoTf, procentaendringTf, renteindtaegtTf;

    public void setBeregnResultatFoerSkat(BeregnResultatFoerSkat beregnResultatFoerSkat) {
        this.beregnResultatFoerSkat = beregnResultatFoerSkat;
        beregnResultatFoerSkat.hentRenteindtaegter().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                grundUIController.opdaterResultatFoerSkat();
            }
        });
    }

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void mellemregning() throws NegativBeloebException {
        Renteindtaegter renteindtaegter = new RenteindtaegterImpl();

        double input1 = Double.parseDouble(rentePrimoTf.getText());
        double input2 = Double.parseDouble(procentaendringTf.getText());
        renteindtaegter.angivRenteindtaegterPrimoOgProcentaendring(input1, input2);
        renteindtaegtTf.setText(String.valueOf(renteindtaegter.hentRenteindtaegter()));
    }

    public void beregn() throws NegativBeloebException {
        beregnResultatFoerSkat.angivRenteindtaegter(Double.parseDouble(renteindtaegtTf.getText()));
        grundUIController.opdaterRenteindtaegter();
    }


}
