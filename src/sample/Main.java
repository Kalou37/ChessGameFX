package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import views.Pieces;

import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;
    private static boolean blitz;

    @Override
    public void start(Stage primaryStage) {
        blitz = false;
        Main.primaryStage = primaryStage;
        try{
            startGame(primaryStage);
        } catch (IOException e){
            System.out.println("Unable to start game.");
        }

    }
    void startGame(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/sample.fxml"));
        primaryStage.setTitle("ChessFX - " + ((blitz) ? "blitz" : "normal") + " mode");
        primaryStage.getIcons().add(new Image("views/chessSheets/whiteKing.png"));
        primaryStage.setScene(new Scene(root, 760, 560));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
           // Platform.exit();
            System.exit(0);
        });
    }

    public void restart(Stage primaryStage, Boolean blitz) {
        Main.blitz = blitz;
        cleanup();
        try{
            startGame(primaryStage);
        } catch (IOException e){
            System.out.println("Unable to start game.");
        }
    }

    public void cleanup() { Pieces.cleanList(); }

    public static Stage getPrimaryStage() { return primaryStage; }

    public static boolean getBlitz() {
        return blitz;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
