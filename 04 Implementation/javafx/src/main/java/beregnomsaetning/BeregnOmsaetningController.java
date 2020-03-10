package beregnomsaetning;

import entities.*;
import entities.exceptions.NegativAntalException;
import entities.exceptions.NegativBeloebException;
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

public class BeregnOmsaetningController {
    String nuvaerendeMetode;
    MetodeControllerOmsaetning metodeControllerOmsaetning;

    Omsaetning omsaetning;
    @FXML
    private Pane metodePane;

    @FXML
    private ChoiceBox<String> metodeComboBox;

    @FXML
    private Button beregnButton;

    @FXML
    private TextField omsaetningTf;

    public void initialize() {
        omsaetning = new OmsaetningImpl();
        omsaetning.tilmeldObserver(new Observer() {
            @Override
            public void opdater(Observable observable) {
                if (observable instanceof Omsaetning) {
                    double changed = ((Omsaetning) observable).hentOmsaetning();
                    omsaetningTf.setText(String.valueOf(changed));
                }
            }
        });
        metodeComboBox.getItems().addAll("Afsætning og salgspris", "Bruttofortjeneste og vareforbrug", "Primoårsomsætning og procentstigning");
        metodeComboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                String metode = metodeComboBox.getItems().get((Integer) new_value);
                try {
                    aendreMetode(metode);
                    omsaetningTf.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        metodeComboBox.getSelectionModel().select(0);
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
        assert loader != null;
        node = loader.load();
        metodeControllerOmsaetning = loader.getController();
        metodePane.getChildren().setAll(node);
    }

    public void beregn() throws NegativAntalException, NegativBeloebException {
        int afsaetningInput;
        double salgsprisInput;
        double bruttofortjenesteInput;
        double vareforbrugInput;
        double primoAarInput;
        double procentstigningInput;
        switch (nuvaerendeMetode) {
            case "Afsætning og salgspris":
                afsaetningInput = Integer.parseInt(metodeControllerOmsaetning.getAfsaetningTf().getText());
                AfsaetningImpl afsaetning = new AfsaetningImpl();
                afsaetning.angivAntal(afsaetningInput);
                salgsprisInput = Double.parseDouble(metodeControllerOmsaetning.getSalgsprisTf().getText());
                SalgsprisImpl salgspris = new SalgsprisImpl();
                salgspris.angivPris(salgsprisInput);
                omsaetning.anvendAfsaetningOgSalgspris(afsaetning, salgspris);
                break;
            case "Bruttofortjeneste og vareforbrug":
                bruttofortjenesteInput = Double.parseDouble(metodeControllerOmsaetning.getBruttofortjenesteTf().getText());
                BruttofortjenesteImpl bruttofortjeneste = new BruttofortjenesteImpl();
                bruttofortjeneste.angivBeloeb(bruttofortjenesteInput);
                vareforbrugInput = Double.parseDouble(metodeControllerOmsaetning.getVareforbrugTf().getText());
                VareforbrugImpl vareforbrug = new VareforbrugImpl();
                vareforbrug.angivBeloeb(vareforbrugInput);
                omsaetning.anvendBruttofortjenesteOgVareforbrug(bruttofortjeneste, vareforbrug);
                break;
            case "Primoårsomsætning og procentstigning":
                primoAarInput = Double.parseDouble(metodeControllerOmsaetning.getPrimoaarTf().getText());
                PrimoAarsomsaetningImpl primoAarsomsaetning = new PrimoAarsomsaetningImpl();
                primoAarsomsaetning.angivBeloeb(primoAarInput);
                procentstigningInput = Double.parseDouble(metodeControllerOmsaetning.getProcentstigningTf().getText());
                ProcentstigningImpl procentstigning = new ProcentstigningImpl();
                procentstigning.angivDecimaltal(procentstigningInput);
                omsaetning.anvendPrimoAarsomsaetningOgProcentstigning(primoAarsomsaetning, procentstigning);
                break;
        }
    }

    public TextField getOmsaetningTf() {
        return omsaetningTf;
    }

    public Omsaetning getOmsaetning() {
        return omsaetning;
    }
}
