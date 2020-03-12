package start;

import beregnafskrivning.BeregnAfskrivningController;
import beregnafskrivning.BeregnAfskrivningImpl;
import beregnbruttofortjeneste.BeregnBruttofortjenesteImpl;
import beregnomsaetning.BeregnOmsaetningController;
import beregnomsaetning.BeregnOmsaetningImpl;
import beregnresultatfoerrenter.BeregnResultatFoerRenterImpl;
import beregnresultatfoerskat.BeregnRenteindtaegterController;
import beregnresultatfoerskat.BeregnRenteomkostningerController;
import beregnresultatfoerskat.BeregnResultatFoerSkat;
import beregnresultatfoerskat.BeregnResultatFoerSkatImpl;
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
    private BeregnRenteindtaegterController beregnRenteindtaegterController;
    private BeregnRenteomkostningerController beregnRenteomkostningerController;
    private BeregnOmsaetningController beregnOmsaetningController;
    private BeregnBruttofortjenesteController beregnBruttofortjenesteController;
    private ArrayList<BeregnAfskrivningController> beregnAfskrivningControllers;
    private double afskrivningsPaneLayoutY = 38;
    private ArrayList<Node> afskrivninger;
    private BeregnOmsaetningImpl beregnOmsaetning;
    private BeregnBruttofortjenesteImpl beregnBruttofortjeneste;
    private BeregnAfskrivningImpl beregnAfskrivning;
    private BeregnResultatFoerRenterImpl beregnResultatFoerRenter;
    private BeregnResultatFoerSkat beregnResultatFoerSkat;


    @FXML
    private Label omsaetningResultatLabel;

    @FXML
    private Label afskrivningResultatLabel;
  
    @FXML
    private Label bruttofortjenesteResultatLabel;

    @FXML
    private Label indtjeningsbidragResultatLabel;

    @FXML
    private Label resultatFoerSkatResultatLabel;

    @FXML
    private Label resultatFoerRenterResultatLabel;

    @FXML
    private Label renteindtaegterResultatLabel, renteomkostningerResultatLabel;

    @FXML
    private Pane omsaetningPane, afskrivningPane, renteindtaegterPane, renteomkostningerPane, bruttofortjenestePane;

    public GrundUIController() {
    }

    public void initialize() throws IOException {
        afskrivninger = new ArrayList<>();
        beregnAfskrivningControllers = new ArrayList<>();
        beregnAfskrivning = new BeregnAfskrivningImpl();
        beregnResultatFoerRenter = new BeregnResultatFoerRenterImpl();
        beregnResultatFoerSkat = new BeregnResultatFoerSkatImpl();
        beregnOmsaetning = new BeregnOmsaetningImpl();
        beregnBruttofortjeneste = new BeregnBruttofortjenesteImpl();
        loadOmsaetning();
        loadAfskrivning();
        loadRenteintaegter();
        loadRenteomkostninger();
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnbruttofortjeneste/Beregn_bruttofortjeneste.fxml"));
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

    public void loadRenteintaegter() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnresultatfoerskat/Beregn_renteindtaegter.fxml"));
        Node node = fxmlLoader.load();
        beregnRenteindtaegterController = fxmlLoader.getController();
        beregnRenteindtaegterController.setGrundUIController(this);
        beregnRenteindtaegterController.setBeregnResultatFoerSkat(beregnResultatFoerSkat);
        renteindtaegterPane.getChildren().add(node);
    }

    public void loadRenteomkostninger() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnresultatfoerskat/Beregn_renteomkostninger.fxml"));
        Node node = fxmlLoader.load();
        beregnRenteomkostningerController = fxmlLoader.getController();
        beregnRenteomkostningerController.setGrundUIController(this);
        beregnRenteomkostningerController.setBeregnResultatFoerSkat(beregnResultatFoerSkat);
        renteomkostningerPane.getChildren().add(node);
    }

    @FXML
    public void tilfoejOmsaetningTilResultatBudget(){
        omsaetningResultatLabel.setText(String.valueOf(beregnOmsaetning.getOmsaetning().hentOmsaetning()));
    }

    @FXML
    public void tilfoejBruttofortjenesteTilResultatBudget(){
        bruttofortjenesteResultatLabel.setText(String.valueOf(beregnBruttofortjeneste.getBruttofortjeneste().hentBruttofortjeneste()));
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
        afskrivningResultatLabel.setText(sum + "");
        opdaterResultatFoerRenter();
    }

    public void opdaterResultatFoerRenter() {
        Indtjeningsbidrag indtjeningsbidrag = new IndtjeningsbidragImpl();
        indtjeningsbidrag.angivBeloeb(0);
        beregnResultatFoerRenter.angivAfskrivningerOgIndtjeningsbidrag(beregnAfskrivning.hentAfskrivninger(), indtjeningsbidrag);
        String resultat = String.valueOf(beregnResultatFoerRenter.hentResultat().hentResultatFoerRenter());
        beregnResultatFoerSkat.angivResultatFoerRenter(beregnResultatFoerRenter.hentResultat());
        resultatFoerRenterResultatLabel.setText(resultat);
        opdaterResultatFoerSkat();
    }

    public void opdaterRenteindtaegter() {
        String tal = String.valueOf(beregnResultatFoerSkat.hentRenteindtaegter().hentRenteindtaegter());
        renteindtaegterResultatLabel.setText(tal);
    }

    public void opdaterRenteomkostninger() {
        String tal = String.valueOf(beregnResultatFoerSkat.hentRenteomkostninger().hentRenteomkostninger());
        renteomkostningerResultatLabel.setText(tal);
    }


    public void opdaterResultatFoerSkat() {
        beregnResultatFoerSkat.beregnResultat();
        resultatFoerSkatResultatLabel.setText(String.valueOf(beregnResultatFoerSkat.HentResultat().hentResultatFoerSkat()));
    }
}
