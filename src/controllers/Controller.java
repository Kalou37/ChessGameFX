package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import views.Pieces;
import views.TypePiece;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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
    @FXML
    private Rectangle rectPoint;
    @FXML
    private Label player;
    @FXML
    private Label labelTimeWhite;
    @FXML
    private Label labelTimeBlack;

    private Rectangle[] board;

    private boolean isPlayerWhiteTurn;

    Timer whiteTime = new Timer();
    Timer blackTime = new Timer();
    int timerWhite;
    int timerBlack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isPlayerWhiteTurn = true;
        rectPoint.setVisible(false);

        timerWhite = -1;
        timerBlack = -1;

        new Pieces("Black Roof 1", blackRoof1, false, 0, 0, TypePiece.ROOF);
        new Pieces("Black Roof 2", blackRoof2, false, 7, 0, TypePiece.ROOF);
        new Pieces("Black Knight 1", blackKnight1, false, 1, 0, TypePiece.KNIGHT);
        new Pieces("Black Knight 2", blackKnight2, false, 6, 0, TypePiece.KNIGHT);
        new Pieces("Black Bishop 2", blackBishop1, false, 2, 0, TypePiece.BISHOP);
        new Pieces("Black Bishop 2", blackBishop2, false, 5, 0, TypePiece.BISHOP);
        new Pieces("Black Queen", blackQueen, false, 3, 0, TypePiece.QUEEN);
        new Pieces("Black King", blackKing, false, 4, 0, TypePiece.KING);

        new Pieces("White Roof 1", whiteRoof1, true, 0, 7, TypePiece.ROOF);
        new Pieces("White Roof 2", whiteRoof2, true, 7, 7, TypePiece.ROOF);
        new Pieces("White Knight 1", whiteKnight1, true, 1, 7, TypePiece.KNIGHT);
        new Pieces("White Knight 2", whiteKnight2, true, 6, 7, TypePiece.KNIGHT);
        new Pieces("White Bishop 2", whiteBishop1, true, 2, 7, TypePiece.BISHOP);
        new Pieces("White Bishop 2", whiteBishop2, true, 5, 7, TypePiece.BISHOP);
        new Pieces("White Queen", whiteQueen, true, 3, 7, TypePiece.QUEEN);
        new Pieces("White King", whiteKing, true, 4, 7, TypePiece.KING);

        new Pieces("Black Pawn 1", blackPawn1, false, 0, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 2", blackPawn2, false, 1, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 3", blackPawn3, false, 2, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 4", blackPawn4, false, 3, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 5", blackPawn5, false, 4, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 6", blackPawn6, false, 5, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 7", blackPawn7, false, 6, 1, TypePiece.BLACK_PAWN);
        new Pieces("Black Pawn 8", blackPawn8, false, 7, 1, TypePiece.BLACK_PAWN);

        new Pieces("White Pawn 1", whitePawn1, true, 0, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 2", whitePawn2, true, 1, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 3", whitePawn3, true, 2, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 4", whitePawn4, true, 3, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 5", whitePawn5, true, 4, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 6", whitePawn6, true, 5, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 7", whitePawn7, true, 6, 6, TypePiece.WHITE_PAWN);
        new Pieces("White Pawn 8", whitePawn8, true, 7, 6, TypePiece.WHITE_PAWN);

        board = new Rectangle[]{rect00, rect02, rect04, rect06, rect11, rect13, rect15, rect17, rect20, rect22, rect24, rect26, rect31, rect33, rect35, rect37, rect40, rect42, rect44, rect46, rect51, rect53, rect55, rect57, rect60, rect62, rect64, rect66, rect71, rect73, rect75, rect77,
                rect01, rect03, rect05, rect07, rect10, rect12, rect14, rect16, rect21, rect23, rect25, rect27, rect30, rect32, rect34, rect36, rect41, rect43, rect45, rect47, rect50, rect52, rect54, rect56, rect61, rect63, rect65, rect67, rect70, rect72, rect74, rect76};

        unsubSquare();

        for (Pieces piece : Pieces.getPiecesList()) {
            piece.getImageView().setOnMouseDragged(e -> movePiece(e, piece));
        }

        setTime();
    }

    public String convertTime(int time) {
        int seconds = time % 60;
        int minutes = (time / 60) % 60;
        int hours = (time / 3600);
        return "" + ((hours < 10) ? "0" + hours : hours) + ":" + ((minutes < 10) ? "0" + minutes : minutes) + ":" + ((seconds < 10) ? "0" + seconds : seconds);
    }

    public void setTime() {
        if (isPlayerWhiteTurn) {
            whiteTime = new Timer();
            whiteTime.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            labelTimeWhite.setText(convertTime(++timerWhite));
                        }
                    });
                }
            }, 0, 1000);
        } else {
            blackTime = new Timer();
            blackTime.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            labelTimeBlack.setText(convertTime(++timerBlack));
                        }
                    });
                }
            }, 0, 1000);
        }
    }

    private void subSquare(int x, int y) {
        for (Rectangle square : board) {
            if (x * 70 == square.getLayoutX() && y * 70 == square.getLayoutY()) {
                square.setFill(Color.LIGHTSALMON);
            }
        }
    }

    private void unsubSquare() {
        for (int i = 0; i < board.length / 2; i++) {
            board[i].setFill(Color.WHITE);
        }
        for (int i = 32; i < board.length; i++) {
            board[i].setFill(Color.LIGHTGREY);
        }
    }

    private void movePiece(MouseEvent e, Pieces piece) {
        if ((isPlayerWhiteTurn && piece.isWhite()) || (!isPlayerWhiteTurn && !piece.isWhite())) {
            ImageView selectedPiece = piece.getImageView();
            selectedPiece.toFront();
            selectedPiece.setX(e.getX() - 25);
            selectedPiece.setY(e.getY() - 25);
            selectedPiece.setOnMouseClicked(ev -> placePiece(ev, piece));
            rectPoint.setVisible(true);
            if (((e.getSceneX() - 35) / 70) * 70 != rectPoint.getLayoutX() && ((e.getSceneY() - 35) / 70) * 70 != rectPoint.getLayoutY()) {
                rectPoint.setLayoutX(Math.round((e.getSceneX() - 35) / 70) * 70);
                rectPoint.setLayoutY(Math.round((e.getSceneY() - 35) / 70) * 70);
            }
            for (double position : piece.getPossibleMove()) {
                subSquare((int) position, (int) ((position * 10) - ((int) position * 10)));
            }
        }
    }

    private void changePlayer() {
        isPlayerWhiteTurn = !isPlayerWhiteTurn;
        if (isPlayerWhiteTurn) {
            blackTime.cancel();
            player.setText("White player");
            player.setTextFill(Color.GREY);
        } else {
            whiteTime.cancel();
            player.setText("Black player");
            player.setTextFill(Color.BLACK);
        }
        setTime();
    }

    private void placePiece(MouseEvent e, Pieces piece) {
        boolean isPlace = false;
        rectPoint.setVisible(false);
        for (Rectangle rectangle : board) {
            if (Math.round((e.getSceneX() - 35) / 70) * 70 == rectangle.getLayoutX()
                    && Math.round((e.getSceneY() - 35) / 70) * 70 == rectangle.getLayoutY()
                    && rectangle.getFill() == Color.LIGHTSALMON) {
                piece.changePosition(e.getSceneX(), e.getSceneY());
                allPieces.getChildren().remove(isPieceInSameCase(piece));
                isPlace = true;
                changePlayer();
            }
        }
        if (!isPlace) piece.changePosition((double) piece.getPositionX() * 70, (double) piece.getPositionY() * 70);
        unsubSquare();
    }

    private ImageView isPieceInSameCase(Pieces selectedPiece) {
        for (Pieces piece : Pieces.getPiecesList()) {
            if (piece.getPositionX() == selectedPiece.getPositionX() && piece.getPositionY() == selectedPiece.getPositionY() && selectedPiece != piece) {
                Pieces.removePiece(piece);
                return piece.getImageView();
            }
        }
        return null;
    }
}
