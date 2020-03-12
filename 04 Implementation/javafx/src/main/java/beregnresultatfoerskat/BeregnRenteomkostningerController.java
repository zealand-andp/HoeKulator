package beregnresultatfoerskat;

import entities.Observable;
import entities.Observer;
import entities.Renteomkostninger;
import entities.RenteomkostningerImpl;
import entities.exceptions.NegativBeloebException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import start.GrundUIController;

public class BeregnRenteomkostningerController {
    private BeregnResultatFoerSkat beregnResultatFoerSkat;
    private GrundUIController grundUIController;

    @FXML
    private TextField rentePrimoTf, procentaendringTf, renteomkostningTf;

    public void setBeregnResultatFoerSkat(BeregnResultatFoerSkat beregnResultatFoerSkat) {
        this.beregnResultatFoerSkat = beregnResultatFoerSkat;
        beregnResultatFoerSkat.hentRenteomkostninger().tilmeldObserver(new Observer() {
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
        Renteomkostninger renteomkostninger = new RenteomkostningerImpl();

        double input1 = Double.parseDouble(rentePrimoTf.getText());
        double input2 = Double.parseDouble(procentaendringTf.getText());
        renteomkostninger.angivRenteomkostningerPrimoOgProcentændring(input1, input2);
        renteomkostningTf.setText(String.valueOf(renteomkostninger.hentRenteomkostninger()));
    }

    public void beregn() throws NegativBeloebException {
        beregnResultatFoerSkat.angivRenteomkostninger(Double.parseDouble(renteomkostningTf.getText()));
        grundUIController.opdaterRenteomkostninger();
    }
}
