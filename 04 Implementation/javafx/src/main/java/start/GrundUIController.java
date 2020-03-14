package start;

import beregnKKO.BeregnKKO;
import beregnKKO.BeregnKKOImpl;
import beregnafskrivning.BeregnAfskrivningController;
import beregnafskrivning.BeregnAfskrivningImpl;
import beregnbruttofortjeneste.BeregnBruttofortjenesteImpl;
import beregnindtjeningsbidrag.BeregnIndtjeningsbidrag;
import beregnindtjeningsbidrag.BeregnIndtjeningsbidragController;
import beregnindtjeningsbidrag.BeregnIndtjeningsbidragImpl;
import beregnmarkedesfoeringsbidrag.BeregnMarkedsfoeringsbidrag;
import beregnmarkedesfoeringsbidrag.BeregnMarkedsfoeringsbidragImpl;
import beregnomsaetning.BeregnOmsaetningController;
import beregnomsaetning.BeregnOmsaetningImpl;
import beregnresultat.BeregnResultat;
import beregnresultat.BeregnResultatImpl;
import beregnresultat.BeregnSkatteprocentController;
import beregnresultatfoerrenter.BeregnResultatFoerRenterImpl;
import beregnresultatfoerskat.BeregnRenteindtaegterController;
import beregnresultatfoerskat.BeregnRenteomkostningerController;
import beregnresultatfoerskat.BeregnResultatFoerSkat;
import beregnresultatfoerskat.BeregnResultatFoerSkatImpl;
import beregnbruttofortjeneste.BeregnBruttofortjenesteController;
import beregnsso.BeregnSSO;
import beregnvareforbrug.BeregnVareforbrugController;
import beregnvareforbrug.BeregnVareforbrugImpl;
import entities.Afskrivning;
import entities.Indtjeningsbidrag;
import entities.IndtjeningsbidragImpl;
import entities.VareforbrugImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class GrundUIController {
    private double afskrivningsPaneLayoutY = 38;
    private ArrayList<Node> afskrivninger;
    private BeregnOmsaetningImpl beregnOmsaetning;
    private BeregnVareforbrugImpl beregnVareforbrug;
    private BeregnBruttofortjenesteImpl beregnBruttofortjeneste;
    private BeregnSSO beregnSSO;
    private BeregnMarkedsfoeringsbidrag beregnMarkedsfoeringsbidrag;
    private BeregnKKO beregnKKO;
    private BeregnIndtjeningsbidrag beregnIndtjeningsbidrag;
    private BeregnAfskrivningImpl beregnAfskrivning;
    private BeregnResultatFoerRenterImpl beregnResultatFoerRenter;
    private BeregnResultatFoerSkat beregnResultatFoerSkat;
    private BeregnResultat beregnResultat;

    @FXML
    private Label omsaetningResultatLabel;

    @FXML
    private Label vareforbrugResultatLabel;

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
    private Label skatteprocentResultatLabel, resultatResultatLabel;

    @FXML
    private Pane omsaetningPane, vareforbrugPane, bruttofortjenestePane, afskrivningPane, indtjeningsbidragPane, renteindtaegterPane, renteomkostningerPane, skatteprocentPane;

    public GrundUIController() {
    }

    public void initialize() throws IOException {
        beregnOmsaetning = new BeregnOmsaetningImpl();
        beregnVareforbrug = new BeregnVareforbrugImpl();
        beregnBruttofortjeneste = new BeregnBruttofortjenesteImpl();
        beregnMarkedsfoeringsbidrag = new BeregnMarkedsfoeringsbidragImpl();
        beregnMarkedsfoeringsbidrag.angivBruttofortjeneste(beregnBruttofortjeneste.getBruttofortjeneste());
        beregnMarkedsfoeringsbidrag.angivSSO(beregnSSO);
        afskrivninger = new ArrayList<>();
        beregnKKO = new BeregnKKOImpl();
        beregnIndtjeningsbidrag = new BeregnIndtjeningsbidragImpl();
        beregnAfskrivning = new BeregnAfskrivningImpl();
        beregnResultatFoerRenter = new BeregnResultatFoerRenterImpl();
        beregnResultatFoerSkat = new BeregnResultatFoerSkatImpl();
        beregnResultat = new BeregnResultatImpl();
        loadOmsaetning();
        loadVareforbrug();
        loadBruttofortjeneste();
        loadIndtjeningsbidrag();
        loadAfskrivning();
        loadRenteintaegter();
        loadRenteomkostninger();
        loadSkatteprocent();
    }

    public void loadOmsaetning() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnomsaetning/Beregn_omsaetning.fxml"));
        Node node = fxmlLoader.load();
        BeregnOmsaetningController beregnOmsaetningController = fxmlLoader.getController();
        beregnOmsaetningController.setGrundUIController(this);
        beregnOmsaetningController.setBeregnOmsaetning(beregnOmsaetning);
        omsaetningPane.getChildren().add(node);
    }

    public void loadBruttofortjeneste() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnbruttofortjeneste/Beregn_bruttofortjeneste.fxml"));
        Node node = fxmlLoader.load();
        BeregnBruttofortjenesteController beregnBruttofortjenesteController = fxmlLoader.getController();
        beregnBruttofortjenesteController.setGrundUIController(this);
        beregnBruttofortjenesteController.setBeregnBruttofortjeneste(beregnBruttofortjeneste);
        bruttofortjenestePane.getChildren().add(node);
    }

    public void loadVareforbrug() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnvareforbrug/Beregn_vareforbrug.fxml"));
        Node node = fxmlLoader.load();
        BeregnVareforbrugController beregnVareforbrugController = fxmlLoader.getController();
        beregnVareforbrugController.setGrundUIController(this);
        beregnVareforbrugController.setBeregnVareforbrug(beregnVareforbrug);
        vareforbrugPane.getChildren().add(node);
    }

    public void loadIndtjeningsbidrag() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnindtjeningsbidrag/Beregn_indtjeningsbidrag.fxml"));
        Node node = fxmlLoader.load();
        BeregnIndtjeningsbidragController beregnIndtjeningsbidragController = fxmlLoader.getController();
        beregnIndtjeningsbidragController.setGrundUIController(this);
        beregnIndtjeningsbidragController.setBeregnIndtjeningsbidrag(beregnIndtjeningsbidrag);
        indtjeningsbidragPane.getChildren().add(node);
    }

    public void loadAfskrivning() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnafskrivning/Beregn_afskrivning.fxml"));
        Node node = fxmlLoader.load();
        BeregnAfskrivningController beregnAfskrivningController;
        beregnAfskrivningController = fxmlLoader.getController();
        beregnAfskrivningController.setGrundUIController(this);
        beregnAfskrivningController.setBeregnAfskrivning(beregnAfskrivning);
        afskrivningPane.getChildren().add(node);
        afskrivninger.add(node);
        beregnAfskrivningController.setNode(node);
    }

    public void loadRenteintaegter() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnresultatfoerskat/Beregn_renteindtaegter.fxml"));
        Node node = fxmlLoader.load();
        BeregnRenteindtaegterController beregnRenteindtaegterController = fxmlLoader.getController();
        beregnRenteindtaegterController.setGrundUIController(this);
        beregnRenteindtaegterController.setBeregnResultatFoerSkat(beregnResultatFoerSkat);
        renteindtaegterPane.getChildren().add(node);
    }

    public void loadRenteomkostninger() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnresultatfoerskat/Beregn_renteomkostninger.fxml"));
        Node node = fxmlLoader.load();
        BeregnRenteomkostningerController beregnRenteomkostningerController = fxmlLoader.getController();
        beregnRenteomkostningerController.setGrundUIController(this);
        beregnRenteomkostningerController.setBeregnResultatFoerSkat(beregnResultatFoerSkat);
        renteomkostningerPane.getChildren().add(node);
    }

    public void loadSkatteprocent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../beregnresultat/Beregn_skatteprocent.fxml"));
        Node node = fxmlLoader.load();
        BeregnSkatteprocentController beregnSkatteprocentController = fxmlLoader.getController();
        beregnSkatteprocentController.setGrundUIController(this);
        beregnSkatteprocentController.setBeregnResultat(beregnResultat);
        skatteprocentPane.getChildren().add(node);
    }

    @FXML
    public void tilfoejOmsaetningTilResultatBudget(){
        omsaetningResultatLabel.setText(String.valueOf(beregnOmsaetning.getOmsaetning().hentOmsaetning()));
    }

    @FXML
    public void tilfoejVareforbrugTilResultatbudget(){
        vareforbrugResultatLabel.setText(String.valueOf(beregnVareforbrug.getVareforbrug().hentVareforbrug()));
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
        String formatted = String.format("%.2f", sum);
        afskrivningResultatLabel.setText(formatted);
        opdaterResultatFoerRenter();
    }

    public void opdaterIndtjeningsbidrag() {
        beregnMarkedsfoeringsbidrag.hentMarkedsfoeringsbidrag().hentBeloeb();
        beregnKKO.hentAlleBeloeb();
        beregnIndtjeningsbidrag.beregnIndtjeningsbidrag();
    }

    public void opdaterResultatFoerRenter() {
        Indtjeningsbidrag indtjeningsbidrag;
        if (beregnIndtjeningsbidrag.hentIndtjeningsbidrag() != null) {
            indtjeningsbidrag = beregnIndtjeningsbidrag.hentIndtjeningsbidrag();
        }
        else {
            indtjeningsbidrag = new IndtjeningsbidragImpl();
            indtjeningsbidrag.angivBeloeb(0);
        }
        beregnResultatFoerRenter.angivAfskrivningerOgIndtjeningsbidrag(beregnAfskrivning.hentAfskrivninger(), indtjeningsbidrag);
        double tal = beregnResultatFoerRenter.hentResultat().hentResultatFoerRenter();
        String formatted = String.format("%.2f", tal);
        resultatFoerRenterResultatLabel.setText(formatted);
        beregnResultatFoerSkat.angivResultatFoerRenter(beregnResultatFoerRenter.hentResultat());
        opdaterResultatFoerSkat();
    }

    public void opdaterRenteindtaegter() {
        double tal = beregnResultatFoerSkat.hentRenteindtaegter().hentRenteindtaegter();
        String formatted = String.format("%.2f", tal);
        renteindtaegterResultatLabel.setText(formatted);
    }

    public void opdaterRenteomkostninger() {
        double tal = beregnResultatFoerSkat.hentRenteomkostninger().hentRenteomkostninger();
        String formatted = String.format("%.2f", tal);
        renteomkostningerResultatLabel.setText(formatted);
    }


    public void opdaterResultatFoerSkat() {
        beregnResultatFoerSkat.beregnResultat();
        double tal = beregnResultatFoerSkat.HentResultat().hentResultatFoerSkat();
        String formatted = String.format("%.2f", tal);
        resultatFoerSkatResultatLabel.setText(formatted);
        beregnResultat.angivResultatFoerSkat(beregnResultatFoerSkat.HentResultat());
        opdaterResultat();
    }

    public void opdaterSkatteprocent() {
        double tal = beregnResultat.hentSkatteprocent().hentVaerdi();
        String formatted = String.format("%.1f", tal);
        skatteprocentResultatLabel.setText(formatted + "%");
        opdaterResultat();
    }

    public void opdaterResultat() {
        beregnResultat.beregnResultat();
        double tal = beregnResultat.hentResultat().hentBeloeb();
        String formatted = String.format("%.2f", tal);
        resultatResultatLabel.setText(formatted);
    }
}
