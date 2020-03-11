package beregnomsaetning;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MetodeControllerOmsaetning {
    @FXML
    private TextField afsaetningTf, salgsprisTf, vareforbrugTf, bruttofortjenesteTf, primoaarTf, procentstigningTf;

    public TextField getAfsaetningTf() {
        return afsaetningTf;
    }

    public TextField getSalgsprisTf() {
        return salgsprisTf;
    }

    public TextField getVareforbrugTf() {
        return vareforbrugTf;
    }

    public TextField getBruttofortjenesteTf() {
        return bruttofortjenesteTf;
    }

    public TextField getPrimoaarTf() {
        return primoaarTf;
    }

    public TextField getProcentstigningTf() {
        return procentstigningTf;
    }
}
