package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8;
    @FXML
    private ImageView blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8;
    @FXML
    private ImageView whiteRoof1, whiteRoof2, blackRoof1, blackRoof2, whiteKnight1, whiteKnight2,blackKnight1, blackKnight2;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*rect00.setOnMouseEntered(this::subSquare);
        rect01.setOnMouseEntered(this::subSquare);
        rect02.setOnMouseEntered(this::subSquare);
        rect03.setOnMouseEntered(this::subSquare);
        rect04.setOnMouseEntered(this::subSquare);
        rect05.setOnMouseEntered(this::subSquare);
        rect06.setOnMouseEntered(this::subSquare);
        rect07.setOnMouseEntered(this::subSquare);
        rect10.setOnMouseEntered(this::subSquare);
        rect11.setOnMouseEntered(this::subSquare);
        rect12.setOnMouseEntered(this::subSquare);
        rect13.setOnMouseEntered(this::subSquare);
        rect14.setOnMouseEntered(this::subSquare);
        rect15.setOnMouseEntered(this::subSquare);
        rect16.setOnMouseEntered(this::subSquare);
        rect17.setOnMouseEntered(this::subSquare);
        rect20.setOnMouseEntered(this::subSquare);
        rect21.setOnMouseEntered(this::subSquare);
        rect22.setOnMouseEntered(this::subSquare);
        rect23.setOnMouseEntered(this::subSquare);
        rect24.setOnMouseEntered(this::subSquare);
        rect25.setOnMouseEntered(this::subSquare);
        rect26.setOnMouseEntered(this::subSquare);
        rect27.setOnMouseEntered(this::subSquare);
        rect30.setOnMouseEntered(this::subSquare);
        rect31.setOnMouseEntered(this::subSquare);
        rect32.setOnMouseEntered(this::subSquare);
        rect33.setOnMouseEntered(this::subSquare);
        rect34.setOnMouseEntered(this::subSquare);
        rect35.setOnMouseEntered(this::subSquare);
        rect36.setOnMouseEntered(this::subSquare);
        rect37.setOnMouseEntered(this::subSquare);
        rect40.setOnMouseEntered(this::subSquare);
        rect41.setOnMouseEntered(this::subSquare);
        rect42.setOnMouseEntered(this::subSquare);
        rect43.setOnMouseEntered(this::subSquare);
        rect44.setOnMouseEntered(this::subSquare);
        rect45.setOnMouseEntered(this::subSquare);
        rect46.setOnMouseEntered(this::subSquare);
        rect47.setOnMouseEntered(this::subSquare);
        rect50.setOnMouseEntered(this::subSquare);
        rect51.setOnMouseEntered(this::subSquare);
        rect52.setOnMouseEntered(this::subSquare);
        rect53.setOnMouseEntered(this::subSquare);
        rect54.setOnMouseEntered(this::subSquare);
        rect55.setOnMouseEntered(this::subSquare);
        rect56.setOnMouseEntered(this::subSquare);
        rect57.setOnMouseEntered(this::subSquare);
        rect60.setOnMouseEntered(this::subSquare);
        rect61.setOnMouseEntered(this::subSquare);
        rect62.setOnMouseEntered(this::subSquare);
        rect63.setOnMouseEntered(this::subSquare);
        rect64.setOnMouseEntered(this::subSquare);
        rect65.setOnMouseEntered(this::subSquare);
        rect66.setOnMouseEntered(this::subSquare);
        rect67.setOnMouseEntered(this::subSquare);
        rect70.setOnMouseEntered(this::subSquare);
        rect71.setOnMouseEntered(this::subSquare);
        rect72.setOnMouseEntered(this::subSquare);
        rect73.setOnMouseEntered(this::subSquare);
        rect74.setOnMouseEntered(this::subSquare);
        rect75.setOnMouseEntered(this::subSquare);
        rect76.setOnMouseEntered(this::subSquare);
        rect77.setOnMouseEntered(this::subSquare);*/
        whitePawn1.setOnMouseDragged(this::movePiece);
        whitePawn2.setOnMouseDragged(this::movePiece);
        whitePawn3.setOnMouseDragged(this::movePiece);
        whitePawn4.setOnMouseDragged(this::movePiece);
        whitePawn5.setOnMouseDragged(this::movePiece);
        whitePawn6.setOnMouseDragged(this::movePiece);
        whitePawn7.setOnMouseDragged(this::movePiece);
        whitePawn8.setOnMouseDragged(this::movePiece);
        blackPawn1.setOnMouseDragged(this::movePiece);
        blackPawn2.setOnMouseDragged(this::movePiece);
        blackPawn3.setOnMouseDragged(this::movePiece);
        blackPawn4.setOnMouseDragged(this::movePiece);
        blackPawn5.setOnMouseDragged(this::movePiece);
        blackPawn6.setOnMouseDragged(this::movePiece);
        blackPawn7.setOnMouseDragged(this::movePiece);
        blackPawn8.setOnMouseDragged(this::movePiece);
        whiteRoof1.setOnMouseDragged(this::movePiece);
        whiteRoof2.setOnMouseDragged(this::movePiece);
        blackRoof1.setOnMouseDragged(this::movePiece);
        blackRoof2.setOnMouseDragged(this::movePiece);
        whiteKnight1.setOnMouseDragged(this::movePiece);
        whiteKnight2.setOnMouseDragged(this::movePiece);
        blackKnight1.setOnMouseDragged(this::movePiece);
        blackKnight2.setOnMouseDragged(this::movePiece);
        whiteBishop1.setOnMouseDragged(this::movePiece);
        whiteBishop2.setOnMouseDragged(this::movePiece);
        blackBishop1.setOnMouseDragged(this::movePiece);
        blackBishop2.setOnMouseDragged(this::movePiece);
        whiteQueen.setOnMouseDragged(this::movePiece);
        blackQueen.setOnMouseDragged(this::movePiece);
        whiteKing.setOnMouseDragged(this::movePiece);
        blackKing.setOnMouseDragged(this::movePiece);
    }

    private void subSquare(MouseEvent e){
        Rectangle square = (Rectangle) e.getTarget();
        Paint oldColor = square.getFill();
        square.setFill(Color.DARKSLATEGRAY);
        square.setOnMouseExited(ev -> desubSquare(e, oldColor));
    }

    private void desubSquare(MouseEvent e, Paint fill){
        Rectangle square = (Rectangle) e.getTarget();
        square.setFill(fill);
    }

    private void movePiece(MouseEvent e){
        ImageView piece = (ImageView) e.getTarget();
        piece.setX(e.getX()-25);
        piece.setY(e.getY()-25);
        piece.setOnMouseClicked(this::placePiece);
        rect44.setOnMouseEntered(this::subSquare);
    }

    private void placePiece(MouseEvent e){
        ImageView piece = (ImageView) e.getTarget();
        piece.relocate(Math.floor(e.getSceneX()/70)*70+10, Math.floor(e.getSceneY()/70)*70+10);
    }
}
