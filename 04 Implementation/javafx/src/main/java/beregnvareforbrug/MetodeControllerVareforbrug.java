package beregnvareforbrug;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MetodeControllerVareforbrug {
    @FXML
    private TextField indkoebsprisTf, afsaetningTf, bruttofortjenesteTf, omsaetningTf, varelagerPrimoTf, varekoebTf, varelagerUltimoTf;

    public TextField getIndkoebsprisTf() {
        return indkoebsprisTf;
    }

    public TextField getAfsaetningTf() {
        return afsaetningTf;
    }

    public TextField getBruttofortjenesteTf() {
        return bruttofortjenesteTf;
    }

    public TextField getOmsaetningTf() {
        return omsaetningTf;
    }

    public TextField getVarelagerPrimoTf() {
        return varelagerPrimoTf;
    }

    public TextField getVarekoebTf() {
        return varekoebTf;
    }

    public TextField getVarelagerUltimoTf() {
        return varelagerUltimoTf;
    }
}
