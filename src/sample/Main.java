package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try{
            startGame(primaryStage);
        } catch (IOException e){
            System.out.println("Unable to start game.");
        }

    }
    void startGame(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/sample.fxml"));
        primaryStage.setTitle("ChessFX");
        primaryStage.getIcons().add(new Image("views/chessSheets/whiteKing.png"));
        primaryStage.setScene(new Scene(root, 760, 560));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    void restart(Stage primaryStage) {
        cleanup();
        try{
            startGame(primaryStage);
        } catch (IOException e){
            System.out.println("Unable to start game.");
        }
    }

    void cleanup() {
        // stop animations reset model ect.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
