package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import views.ListPieces;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8;
    @FXML
    private ImageView blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8;
    @FXML
    private ImageView whiteRoof1, whiteRoof2, blackRoof1, blackRoof2, whiteKnight1, whiteKnight2, blackKnight1, blackKnight2;
    @FXML
    private ImageView whiteBishop1, whiteBishop2, blackBishop1, blackBishop2, whiteQueen, blackQueen, whiteKing, blackKing;
    @FXML
    private Rectangle rect00, rect01, rect02, rect03, rect04, rect05, rect06, rect07, rect10, rect11, rect12, rect13, rect14, rect15, rect16, rect17;
    @FXML
    private Rectangle rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27, rect30, rect31, rect32, rect33, rect34, rect35, rect36, rect37;
    @FXML
    private Rectangle rect40, rect41, rect42, rect43, rect44, rect45, rect46, rect47, rect50, rect51, rect52, rect53, rect54, rect55, rect56, rect57;
    @FXML
    private Rectangle rect60, rect61, rect62, rect63, rect64, rect65, rect66, rect67, rect70, rect71, rect72, rect73, rect74, rect75, rect76, rect77;
    @FXML
    private Group allPieces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ImageView[] listPieces = new ImageView[]{whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8,
                blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8,
                whiteRoof1, whiteRoof2, blackRoof1, blackRoof2, whiteKnight1, whiteKnight2, blackKnight1, blackKnight2,
                whiteBishop1, whiteBishop2, blackBishop1, blackBishop2, whiteQueen, blackQueen, whiteKing, blackKing
        };

        Rectangle[] board = new Rectangle[]{rect00, rect01, rect02, rect03, rect04, rect05, rect06, rect07,
                rect10, rect11, rect12, rect13, rect14, rect15, rect16, rect17,
                rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27,
                rect30, rect31, rect32, rect33, rect34, rect35, rect36, rect37,
                rect40, rect41, rect42, rect43, rect44, rect45, rect46, rect47,
                rect50, rect51, rect52, rect53, rect54, rect55, rect56, rect57,
                rect60, rect61, rect62, rect63, rect64, rect65, rect66, rect67,
                rect70, rect71, rect72, rect73, rect74, rect75, rect76, rect77};

        for (ImageView piece : listPieces) {
            ListPieces.addPieces(piece);
            piece.setOnMouseDragged(this::movePiece);
        }

        for (Rectangle square : board) {
            square.setOnMouseEntered(this::subSquare);
        }
    }
    /*
    public ImageView getPiece(ImageView piece){
        return piece;
    }
     */

    private void subSquare(MouseEvent e) {
        Rectangle square = (Rectangle) e.getTarget();
        Paint oldColor = square.getFill();
        square.setFill(Color.DARKSLATEGRAY);
        square.setOnMouseExited(ev -> desubSquare(e, oldColor));
    }

    private void desubSquare(MouseEvent e, Paint fill) {
        Rectangle square = (Rectangle) e.getTarget();
        square.setFill(fill);
    }

    private void movePiece(MouseEvent e) {
        ImageView piece = (ImageView) e.getTarget();
        piece.toFront();
        piece.setX(e.getX() - 25);
        piece.setY(e.getY() - 25);
        piece.setOnMouseClicked(this::placePiece);
        rect44.setOnMouseEntered(this::subSquare);
    }

    private void placePiece(MouseEvent e) {
        ImageView piece = (ImageView) e.getTarget();
        piece.relocate(Math.floor(e.getSceneX() / 70) * 70 + 10, Math.floor(e.getSceneY() / 70) * 70 + 10);
        allPieces.getChildren().remove(ListPieces.isPiece(piece, (int) Math.floor(e.getSceneX() / 70), (int) Math.floor(e.getSceneY() / 70)));
    }
}
