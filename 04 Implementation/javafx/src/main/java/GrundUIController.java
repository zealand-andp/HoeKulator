import beregnafskrivning.BeregnAfskrivningController;
import beregnomsaetning.BeregnOmsaetningController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GrundUIController {
    private BeregnOmsaetningController beregnOmsaetningController;
    private BeregnAfskrivningController beregnAfskrivningController;

    @FXML
    Label omsaetningResultatLabel1, omsaetningResultatLabel2;

    @FXML
    private Pane omsaetningPane, afskrivningPane;

    public void initialize() throws IOException {
        loadOmsaetning();
        loadAfskrivning();
    }

    public void loadOmsaetning() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("beregnomsaetning/Beregn_omsaetning.fxml"));
        Node node = fxmlLoader.load();
        beregnOmsaetningController = fxmlLoader.getController();
        omsaetningPane.getChildren().add(node);
    }

    public void loadAfskrivning() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("beregnafskrivning/Tilfoej_dialog_base.fxml"));
        Node node = fxmlLoader.load();
        beregnAfskrivningController = fxmlLoader.getController();
        afskrivningPane.getChildren().add(node);
    }

    @FXML
    public void tilfoejTilResultatBudget(){
        omsaetningResultatLabel1.setText(String.valueOf(beregnOmsaetningController.getOmsaetning().hentOmsaetning()));
        omsaetningResultatLabel2.setText(omsaetningResultatLabel1.getText());
    }
}
