package beregnafskrivning;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MetodeControllerAfskrivning {
    @FXML
    private TextField anskaffelsesvaerdiLineaerTf, scrapvaerdiTf, brugstidTf, anskaffelsesvaerdiSaldoTf, afskrivningsprocentTf, anskaffelsesvaerdiStraksTf;

    public TextField getAnskaffelsesvaerdiLineaerTf() {
        return anskaffelsesvaerdiLineaerTf;
    }

    public TextField getScrapvaerdiTf() {
        return scrapvaerdiTf;
    }

    public TextField getBrugstidTf() {
        return brugstidTf;
    }

    public TextField getAnskaffelsesvaerdiSaldoTf() {
        return anskaffelsesvaerdiSaldoTf;
    }

    public TextField getAfskrivningsprocentTf() {
        return afskrivningsprocentTf;
    }

    public TextField getAnskaffelsesvaerdiStraksTf() {
        return anskaffelsesvaerdiStraksTf;
    }
}
