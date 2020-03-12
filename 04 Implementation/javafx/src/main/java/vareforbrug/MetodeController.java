package vareforbrug;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MetodeController {
    @FXML
    private TextField afsaetningTf, indskoebsprisTf, omsætningTf, bruttofortjensteTf, varelagerPrimoTf, varekoebTf, varelagerUltimoTf1;

    public TextField getAfsaetningTf(){ return afsaetningTf; }

    public TextField getIndskoebsprisTf(){ return indskoebsprisTf; }

    public TextField getOmsætningTf(){ return omsætningTf; }

    public TextField getBruttofortjensteTf(){ return bruttofortjensteTf; }

    public TextField getVarelagerPrimoTf(){ return  varelagerPrimoTf; }

    public  TextField getVarekoebTf(){ return varekoebTf; }

    public  TextField getVarelagerUltimoTf1(){ return varelagerUltimoTf1; }
}
