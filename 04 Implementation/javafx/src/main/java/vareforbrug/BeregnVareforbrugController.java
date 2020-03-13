package vareforbrug;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
import entities.exceptions.NegativPrisException;
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

public class BeregnVareforbrugController {
    String nuvaerendeMetode;
    MetodeController metodeController;

    Vareforbrug vareforbrug;
    @FXML
    private Pane vareforbrugMetodePane;

    @FXML
    private ChoiceBox<String> vareforbrugChoiceBox;

    @FXML
    private Button beregnVfButton;

    @FXML
    private TextField vareforbrugTf;

    public void initialize(){
        vareforbrug = new VareforbrugImpl();
        vareforbrug.tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Vareforbrug) {
                    double changed = ((Vareforbrug) observable).hentBeloeb();
                    vareforbrugTf.setText(String.valueOf(changed));
                }
            }
        });
        vareforbrugChoiceBox.getItems().addAll("Indkøbspris og afsætning", "Omsætning og bruttofortjenste", "Primo-varelager, varekøb, ultimo-varelager");
        vareforbrugChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value) {

                 String metode = vareforbrugChoiceBox.getItems().get((Integer) new_value);
                 try{
                     aendreMetode(metode);
                     vareforbrugTf.setText("");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
            }
        });
        vareforbrugChoiceBox.getSelectionModel().select(0);
    }

    private void aendreMetode(String metode) throws IOException {
        FXMLLoader loader = null;
        Node node = null;
        switch (metode){
            case "Indkøbspris og afsætning":
                loader = new FXMLLoader(getClass().getResource("indkoebspris_og_afsaetning.fxml"));
                nuvaerendeMetode = "Indkøbspris og afsætning";
                break;
            case "Omsætning og bruttofortjenste":
                loader = new FXMLLoader(getClass().getResource("omsaetning_og_bruttofortjenste.fxml"));
                nuvaerendeMetode = "Omsætning og bruttofortjenste";
                break;
            case "Primo-varelager, varekøb, ultimo-varelager":
                loader = new FXMLLoader(getClass().getResource("primo_varekoeb_og_ultimo.fxml"));
                nuvaerendeMetode = "Primo-varelager, varekøb, ultimo-varelager";
                break;
        }
        assert loader != null;
        node = loader.load();
        metodeController = loader.getController();
        vareforbrugMetodePane.getChildren().setAll(node);


    }
}
