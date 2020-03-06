import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HoeMain extends Application{
    @FXML
    private Pane omsaetningPane;

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize() throws IOException {
        loadOmsaetning();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();*/

        //URL myFxmlURL = ClassLoader.getSystemResource("GrundUI.fxml");
        //FXMLLoader loader = new FXMLLoader(myFxmlURL);

        //URL fxmlUrl=getClass().getResource("/GrundUI.fxml");
        //Parent root = FXMLLoader.load(fxmlUrl);
        Parent root = FXMLLoader.load(getClass().getResource("/GrundUI.fxml"));
        //Parent root = loader.load(myFxmlURL);
        primaryStage.setTitle("HoeKulator");
        Scene scene = new Scene(root, 1388, 720);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);


        primaryStage.show();
    }

    public void loadOmsaetning() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("omsaetning/Beregn_omsaetning.fxml"));
        omsaetningPane.getChildren().add(node);
    }
}
