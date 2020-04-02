package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/sample.fxml"));
        primaryStage.setTitle("ChessFX");
        primaryStage.getIcons().add(new Image("views/chessSheets/whiteKing.png"));
        primaryStage.setScene(new Scene(root, 760, 560));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
