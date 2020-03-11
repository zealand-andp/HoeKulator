package beregnafskrivning;

import entities.*;
import entities.exceptions.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import start.GrundUIController;

import java.io.IOException;

public class BeregnAfskrivningController {
    String nuvaerendeMetode;
    MetodeControllerAfskrivning metodeController;
    GrundUIController grundUIController;
    Node node;
    BeregnAfskrivningImpl beregnAfskrivning;
    Observer observer;

    @FXML
    private Pane metodePane;

    @FXML
    private ChoiceBox<String> metodeChoiceBox;

    @FXML
    private Button beregnButton;

    @FXML
    private TextField afskrivningTf, navnTf;

    public void initialize() {
//        usedNames
        metodeChoiceBox.getItems().addAll("Lineær Afskrivning", "Saldoafskrivning", "Straksafskrivning");
        metodeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                String metode = metodeChoiceBox.getItems().get((Integer) new_value);
                try {
                    aendreMetode(metode);
                    afskrivningTf.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        metodeChoiceBox.getSelectionModel().select(0);
    }

    private void aendreMetode(String metode) throws IOException {
        FXMLLoader loader = null;
        Node node = null;
        switch (metode) {
            case "Lineær Afskrivning":
                loader = new FXMLLoader(getClass().getResource("Lineaer_afskrivning.fxml"));
                nuvaerendeMetode = "Lineær Afskrivning";
                break;
            case "Saldoafskrivning":
                loader = new FXMLLoader(getClass().getResource("Saldoafskrivning.fxml"));
                nuvaerendeMetode = "Saldoafskrivning";
                break;
            case "Straksafskrivning":
                loader = new FXMLLoader(getClass().getResource("Straksafskrivning.fxml"));
                nuvaerendeMetode = "Straksafskrivning";
                break;
        }
        assert loader != null;
        node = loader.load();
        metodeController = loader.getController();
        metodePane.getChildren().setAll(node);
    }

    public void beregn() throws NegativVaerdiException, OverMaksbeloebException, KanIkkeBeregneAfskrivningException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, NegativBeloebException, NegativAfskrivningsprocentException {
        double anskaffelesvaerdiInput;
        double scrapvaerdiInput;
        int brugstidInput;
        double afskrivningsprocentInput;
        switch(nuvaerendeMetode){
            case "Lineær Afskrivning":
                anskaffelesvaerdiInput = Double.parseDouble(metodeController.getAnskaffelsesvaerdiLineaerTf().getText());
                scrapvaerdiInput = Double.parseDouble(metodeController.getScrapvaerdiTf().getText());
                brugstidInput = Integer.parseInt(metodeController.getBrugstidTf().getText());
                beregnAfskrivning.angivLinearAfskrivning(navnTf.getText(), brugstidInput, scrapvaerdiInput, anskaffelesvaerdiInput);
                break;
            case "Saldoafskrivning":
                anskaffelesvaerdiInput = Double.parseDouble(metodeController.getAnskaffelsesvaerdiSaldoTf().getText());
                afskrivningsprocentInput = Double.parseDouble(metodeController.getAfskrivningsprocentTf().getText());
                beregnAfskrivning.angivSaldoafskrivning(navnTf.getText(), anskaffelesvaerdiInput, afskrivningsprocentInput);
                break;
            case "Straksafskrivning":
                anskaffelesvaerdiInput = Double.parseDouble(metodeController.getAnskaffelsesvaerdiStraksTf().getText());
                beregnAfskrivning.angivStraksafskrivning(navnTf.getText(), anskaffelesvaerdiInput);
                break;
        }
        navnTf.setEditable(false);
    }

    @FXML
    public void fjernSelv() throws IOException {
        beregnAfskrivning.afmeldObserver(observer);
        grundUIController.fjernAfkrivning(node, navnTf.getText());
    }

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setBeregnAfskrivning(BeregnAfskrivningImpl beregnAfskrivning) {
        this.beregnAfskrivning = beregnAfskrivning;
        observer = observable -> {
            if (observable instanceof BeregnAfskrivning) {
                Afskrivning changed = ((BeregnAfskrivning) observable).hentAfskrivninger().get(navnTf.getText());
                afskrivningTf.setText(String.valueOf(changed.hentAfskrivningsvaerdi()));
                grundUIController.opdaterAfskrivninger();
            }
        };
        beregnAfskrivning.tilmeldObserver(observer);
    }
}
