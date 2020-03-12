package start;

import beregnafskrivning.BeregnAfskrivningController;
import beregnafskrivning.BeregnAfskrivningImpl;
import beregnbruttofortjeneste.BeregnBruttofortjenesteImpl;
import beregnomsaetning.BeregnOmsaetningController;
import beregnomsaetning.BeregnOmsaetningImpl;
import beregnresultatfoerrenter.BeregnResultatFoerRenterImpl;
import beregnbruttofortjeneste.BeregnBruttofortjenesteController;
import entities.Afskrivning;
import entities.Indtjeningsbidrag;
import entities.IndtjeningsbidragImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GrundUIController {
    private BeregnOmsaetningController beregnOmsaetningController;
    ArrayList<BeregnAfskrivningController> beregnAfskrivningControllers;
    private BeregnBruttofortjenesteController beregnBruttofortjenesteController;
    double afskrivningsPaneLayoutY = 38;
    ArrayList<Node> afskrivninger;
    BeregnOmsaetningImpl beregnOmsaetning;
    BeregnBruttofortjenesteImpl beregnBruttofortjeneste;
    BeregnAfskrivningImpl beregnAfskrivning;
    BeregnResultatFoerRenterImpl beregnResultatFoerRenter;


    @FXML
    Label omsaetningResultatLabel1, omsaetningResultatLabel2;

    @FXML
    Label bruttofortjenesteResultatLabel1, bruttofortjenesteResultatLabel2;

    @FXML
    Label afskrivningResultatLabel1, afskrivningResultatLabel2;

    @FXML
    Label indtjeningsbidragResultatLabel1, indtjeningsbidragResultatLabel2;

    @FXML
    Label resultatFoerRenterResultatLabel1, resultatFoerRenterResultatLabel2;

    @FXML
    private Pane omsaetningPane, afskrivningPane, bruttofortjenestePane;

    public GrundUIController() {
    }

    public void initialize() throws IOException {
        afskrivninger = new ArrayList<>();
        beregnAfskrivningControllers = new ArrayList<>();
        beregnAfskrivning = new BeregnAfskrivningImpl();
        beregnResultatFoerRenter = new BeregnResultatFoerRenterImpl();
        beregnOmsaetning = new BeregnOmsaetningImpl();
        beregnBruttofortjeneste = new BeregnBruttofortjenesteImpl();
        loadOmsaetning();
        loadAfskrivning();
        loadBruttofortjeneste();
    }

    public void loadOmsaetning() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnomsaetning/Beregn_omsaetning.fxml"));
        Node node = fxmlLoader.load();
        beregnOmsaetningController = fxmlLoader.getController();
        beregnOmsaetningController.setGrundUIController(this);
        beregnOmsaetningController.setBeregnOmsaetning(beregnOmsaetning);
        omsaetningPane.getChildren().add(node);
    }

    public void loadBruttofortjeneste() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnbruttofortjeneste/beregn-bruttofortjeneste.fxml"));
        Node node = fxmlLoader.load();
        beregnBruttofortjenesteController = fxmlLoader.getController();
        beregnBruttofortjenesteController.setGrundUIController(this);
        beregnBruttofortjenesteController.setBeregnBruttofortjeneste(beregnBruttofortjeneste);
        bruttofortjenestePane.getChildren().add(node);
    }

    public void loadAfskrivning() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnafskrivning/Beregn_afskrivning.fxml"));
        Node node = fxmlLoader.load();
        BeregnAfskrivningController beregnAfskrivningController;
        beregnAfskrivningController = fxmlLoader.getController();
        beregnAfskrivningController.setGrundUIController(this);
        beregnAfskrivningController.setBeregnAfskrivning(beregnAfskrivning);
        beregnAfskrivningControllers.add(beregnAfskrivningController);
        afskrivningPane.getChildren().add(node);
        afskrivninger.add(node);
        beregnAfskrivningController.setNode(node);
    }

    @FXML
    public void tilfoejOmsaetningTilResultatBudget(){
        omsaetningResultatLabel1.setText(String.valueOf(beregnOmsaetning.getOmsaetning().hentOmsaetning()));
        omsaetningResultatLabel2.setText(omsaetningResultatLabel1.getText());
    }

    @FXML
    public void tilfoejBruttofortjenesteTilResultatBudget(){
        bruttofortjenesteResultatLabel1.setText(String.valueOf(beregnBruttofortjeneste.getBruttofortjeneste().hentBruttofortjeneste()));
        bruttofortjenesteResultatLabel2.setText(String.valueOf(beregnBruttofortjeneste.getBruttofortjeneste().hentBruttofortjeneste()));
    }

    @FXML
    public void tilfoejNyAfskrivning() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnafskrivning/Beregn_afskrivning.fxml"));
        Node node = fxmlLoader.load();
        afskrivninger.add(node);
        afskrivningsPaneLayoutY += 68;
        BeregnAfskrivningController beregnAfskrivningController;
        beregnAfskrivningController = fxmlLoader.getController();
        beregnAfskrivningController.setGrundUIController(this);
        beregnAfskrivningController.setBeregnAfskrivning(beregnAfskrivning);
        beregnAfskrivningControllers.add(beregnAfskrivningController);
        node.setLayoutY(afskrivningsPaneLayoutY);
        afskrivningPane.setPrefHeight(afskrivningPane.getPrefHeight() + 68);
        afskrivningPane.getChildren().add(node);
        beregnAfskrivningController.setNode(node);
        changeLayout();
    }

    @FXML
    public void fjernAfkrivning(Node node, String string) throws IOException{
        if (afskrivninger.size() <= 0){
            return;
        }
        if (!string.isEmpty()) {
            if (beregnAfskrivning.hentAfskrivninger().containsKey(string)) {
                beregnAfskrivning.hentAfskrivninger().remove(string);
                opdaterAfskrivninger();
            }
        }
        afskrivningPane.getChildren().remove(node);
        afskrivninger.remove(node);
        changeLayout();
        afskrivningPane.setPrefHeight(afskrivningPane.getPrefHeight() - 68);
    }

    @FXML
    public void changeLayout() {
        for (int i = 0; i < afskrivninger.size(); i++) {
            afskrivninger.get(i).setLayoutY(i * 68 + 38);
        }
    }

    @FXML
    public void opdaterAfskrivninger() {
        double sum = 0;
        for (Map.Entry<String, Afskrivning> entry : beregnAfskrivning.hentAfskrivninger().entrySet()) {
            sum += entry.getValue().hentAfskrivningsvaerdi();
        }
        afskrivningResultatLabel1.setText(sum + "");
        afskrivningResultatLabel2.setText(sum + "");
        opdaterResultatFoerRenter();
    }

    public void opdaterResultatFoerRenter() {
        Indtjeningsbidrag indtjeningsbidrag = new IndtjeningsbidragImpl();
        indtjeningsbidrag.angivBeloeb(0);
        beregnResultatFoerRenter.angivAfskrivningerOgIndtjeningsbidrag(beregnAfskrivning.hentAfskrivninger(), indtjeningsbidrag);
        String resultat = String.valueOf(beregnResultatFoerRenter.hentResultat());
        resultatFoerRenterResultatLabel1.setText(resultat);
        resultatFoerRenterResultatLabel2.setText(resultat);
    }
}
