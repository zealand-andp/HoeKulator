package beregnafskrivning;

import beregnomsaetning.MetodeController;
import entities.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BeregnAfskrivningController {
    String nuvaerendeMetode;
    MetodeController metodeController;
    private Afskrivning afskrivning;

    @FXML
    private Pane metodePane;

    @FXML
    private ChoiceBox<String> metodeChoiceBox;

    @FXML
    private Button beregnButton;

    @FXML
    private TextField afskrivningTf;

    public void initialize() {
//        afskrivning = new AfskrivningImpl();
//        afskrivning.tilmeldObserver(new Observer() {
//            @Override
//            public void opdater(Observable observable) {
//                if (observable instanceof Omsaetning) {
//                    double changed = ((Omsaetning) observable).hentOmsaetning();
//                    afskrivningTf.setText(String.valueOf(changed));
//                }
//            }
//        });
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
                loader = new FXMLLoader(getClass().getResource("Lineaer_metode.fxml"));
                nuvaerendeMetode = "Lineær Afskrivning";
                break;
            case "Saldoafskrivning":
                loader = new FXMLLoader(getClass().getResource("Saldo_metode.fxml"));
                nuvaerendeMetode = "Saldoafskrivning";
                break;
            case "Straksafskrivning":
                loader = new FXMLLoader(getClass().getResource("Straks.fxml"));
                nuvaerendeMetode = "Straksafskrivning";
                break;
        }
        assert loader != null;
        node = loader.load();
        metodeController = loader.getController();
        metodePane.getChildren().setAll(node);
    }
}
