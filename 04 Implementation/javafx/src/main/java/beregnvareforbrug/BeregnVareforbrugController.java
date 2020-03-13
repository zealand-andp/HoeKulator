package beregnvareforbrug;

import entities.Indkoebspris;
import entities.Observable;
import entities.Observer;
import entities.Vareforbrug;
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

public class BeregnVareforbrugController {
    private GrundUIController grundUIController;
    private String nuvaerendeMetode;
    private BeregnVareforbrugImpl beregnVareforbrug;
    private MetodeControllerVareforbrug metodeControllerVareforbrug;

    @FXML
    private Pane metodePane;

    @FXML
    private ChoiceBox<String> metodeComboBox;

    @FXML
    private Button beregnButton;

    @FXML
    private TextField vareforbrugTf;

    public void initialize() {
        metodeComboBox.getItems().addAll("Indkøbspris og afsætning", "Bruttofortjeneste og omsætning", "Varelager primo, varekøb og varelager ultimo");
        metodeComboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                String metode = metodeComboBox.getItems().get((Integer) new_value);
                try {
                    aendreMetode(metode);
                    vareforbrugTf.setText("");
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        metodeComboBox.getSelectionModel().select(0);
    }

    private void aendreMetode(String metode) throws IOException {
        FXMLLoader loader = null;
        Node node = null;
        switch (metode){
            case "Indkøbspris og afsætning":
                loader = new FXMLLoader(getClass().getResource("Indkoebspris_og_afsaetning.fxml"));
                nuvaerendeMetode = "Indkøbspris og afsætning";
                break;
            case "Bruttofortjeneste og omsætning":
                loader = new FXMLLoader(getClass().getResource("Bruttofortjeneste_og_omsaetning.fxml"));
                nuvaerendeMetode = "Bruttofortjeneste og omsætning";
                break;
            case "Varelager primo, varekøb og varelager ultimo":
                loader = new FXMLLoader(getClass().getResource("Varelager_primo_og_varekoeb_og_varelager_ultimo.fxml"));
                nuvaerendeMetode = "Varelager primo, varekøb og varelager ultimo";
                break;
        }
        assert loader != null;
        node = loader.load();
        metodeControllerVareforbrug = loader.getController();
        metodePane.getChildren().setAll(node);
    }

    public void setGrundUIController(GrundUIController grundUIController) {
        this.grundUIController = grundUIController;
    }

    public void setBeregnVareforbrug(BeregnVareforbrugImpl beregnVareforbrug){
        this.beregnVareforbrug = beregnVareforbrug;
        this.beregnVareforbrug.getVareforbrug().tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Vareforbrug){
                    double changed = ((Vareforbrug) observable).hentVareforbrug();
                    vareforbrugTf.setText(String.valueOf(changed));
                    grundUIController.tilfoejVareforbrugTilResultatbudget();
                }
            }
        });
    }
}
