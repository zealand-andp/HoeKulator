package omsaetning;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BeregnOmsaetningController {
    String nuvaerendeMetode;
    MetodeController metodeController = new MetodeController();
    @FXML
    private Pane metodePane;

    @FXML
    private ChoiceBox<String> metodeComboBox;

    @FXML
    private Button opdaterButton;

    public void initialize() {
        metodeComboBox.getItems().addAll("Afsætning og salgspris", "Bruttofortjeneste og vareforbrug", "Primoårsomsætning og procentstigning");
        metodeComboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                String metode = metodeComboBox.getItems().get((Integer) new_value);
                try {
                    aendreMetode(metode);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void aendreMetode(String metode) throws IOException {
        FXMLLoader loader = null;
        Node node = null;
        switch (metode) {
            case "Afsætning og salgspris":
                loader = new FXMLLoader(getClass().getResource("Afsaetning_og_salgspris.fxml"));
                nuvaerendeMetode = "Afsætning og salgspris";
                break;
            case "Bruttofortjeneste og vareforbrug":
                loader = new FXMLLoader(getClass().getResource("Bruttofortjeneste_og_vareforbrug.fxml"));
                nuvaerendeMetode = "Bruttofortjeneste og vareforbrug";
                break;
            case "Primoårsomsætning og procentstigning":
                loader = new FXMLLoader(getClass().getResource("Primo_Aarsomsaetning_og_procentstigning.fxml"));
                nuvaerendeMetode = "Primoårsomsætning og procentstigning";
                break;
        }
        metodeController = loader.getController();
        node = loader.load();
        metodePane.getChildren().setAll(node);

    }

    public void beregn() {
        int afsaetning;
        double salgspris;
        double bruttofortjeneste;
        double vareforbrug;
        double primoAar;
        double procentstigning;
        switch (nuvaerendeMetode) {
            case "Afsætning og salgspris":
                afsaetning = Integer.parseInt(metodeController.getAfsaetningTf().getText());
                salgspris = Double.parseDouble(metodeController.getSalgsprisTf().getText());
                break;
            case "Bruttofortjeneste og vareforbrug":
                bruttofortjeneste = Double.parseDouble(metodeController.getBruttofortjenesteTf().getText());
                vareforbrug = Double.parseDouble(metodeController.getVareforbrugTf().getText());
                break;
            case "Primoårsomsætning og procentstigning":
                primoAar = Double.parseDouble(metodeController.getPrimoaarTf().getText());
                procentstigning = Double.parseDouble(metodeController.getProcentstigningTf().getText());
                break;
        }



    }
}
