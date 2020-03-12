package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HoeMain extends Application{


    public static void main(String[] args) {
        launch(args);
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
        Parent root = FXMLLoader.load(getClass().getResource("GrundUI2.fxml"));
        //Parent root = loader.load(myFxmlURL);
        primaryStage.setTitle("HoeKulator");
        Scene scene = new Scene(root, 1388, 720);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);


        primaryStage.show();
    }
}
