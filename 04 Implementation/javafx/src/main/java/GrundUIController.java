import beregnafskrivning.BeregnAfskrivningController;
import beregnomsaetning.BeregnOmsaetningController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class GrundUIController {
    private BeregnOmsaetningController beregnOmsaetningController;
    private BeregnAfskrivningController beregnAfskrivningController;
    double nodeY = 38;
    ArrayList<Node> afskrivninger;


    @FXML
    Label omsaetningResultatLabel1, omsaetningResultatLabel2;

    @FXML
    private Pane omsaetningPane, afskrivningPane;

    public void initialize() throws IOException {
        afskrivninger = new ArrayList<>();
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
        afskrivninger.add(node);
    }

    @FXML
    public void tilfoejTilResultatBudget(){
        omsaetningResultatLabel1.setText(String.valueOf(beregnOmsaetningController.getOmsaetning().hentOmsaetning()));
        omsaetningResultatLabel2.setText(omsaetningResultatLabel1.getText());
    }

    @FXML
    public void tilfoejNyAfskrivning() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("beregnafskrivning/Tilfoej_dialog_base.fxml"));
        Node node = fxmlLoader.load();
        afskrivninger.add(node);
        nodeY += 68;
        beregnAfskrivningController = fxmlLoader.getController();
        node.setLayoutY(nodeY);
        afskrivningPane.setPrefHeight(afskrivningPane.getPrefHeight() + 68);
        afskrivningPane.getChildren().add(node);

    }

    @FXML
    public void fjernAfkrivning() throws IOException{
        if (afskrivninger.size() <= 0){
            return;
        }
        afskrivningPane.getChildren().remove(afskrivninger.get(afskrivninger.size() - 1));
        afskrivninger.remove(afskrivninger.size()-1);
        nodeY -= 68;
        afskrivningPane.setPrefHeight(afskrivningPane.getPrefHeight() - 68);
    }
}
