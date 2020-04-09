package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Pieces {
    protected String name;
    protected int positionX;
    protected int positionY;
    protected int oldPositionX;
    protected int oldPositionY;
    protected boolean isFirstMove;
    private ImageView imageView;
    protected boolean isWhite;
    protected static ArrayList<Pieces> piecesList = new ArrayList<>();
    private static String lastMove;
    private static Pieces lastPieceMove;
    private static boolean isUndo = false;

    public Pieces(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        this.name = name;
        this.imageView = imgView;
        this.isWhite = colorWhite;
        this.positionX = posX;
        this.positionY = posY;
        this.isFirstMove = true;
        piecesList.add(this);
    }

    public static void cleanList() {
        piecesList.clear();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public static ArrayList<Pieces> getPiecesList() { return piecesList; }

    public static String getListMove() {return lastMove; }

    public static Pieces getLastPieceMove() { return lastPieceMove; }

    public int getOldPositionX() { return oldPositionX; }

    public int getOldPositionY() { return oldPositionY; }

    public static void removePiece(Pieces piece) {
        piecesList.remove(piece);
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setFirstMove() {
        isFirstMove = false;
    }

    public static void setIsUndo(boolean isUndo) { Pieces.isUndo = isUndo; }

    public void changePosition(Double x, Double y) {
        int newPositionX = (int) Math.floor(x / 70);
        int newPositionY = (int) Math.floor(y / 70);
        this.imageView.relocate(newPositionX * 70 + 10, newPositionY * 70 + 10);
        lastMove = " - " +this.name + " : (" + this.positionX + "-" + this.positionY + ") to (" + newPositionX + "-" + newPositionY + ")";
        if (this instanceof King && (newPositionX - this.positionX) == 2) rock(false);
        if (this instanceof King && (this.positionX - newPositionX) == 2) rock(true);
        this.oldPositionX = this.positionX;
        this.oldPositionY = this.positionY;
        this.positionX = newPositionX;
        this.positionY = newPositionY;
        lastPieceMove = this;
    }

    private void rock(boolean gRock) {
        Optional<Pieces> roof;
        if(isUndo) roof = piecesList.stream().filter(s -> s instanceof Roof).filter(s -> s.isWhite == this.isWhite).filter(s -> s.positionX == ((!gRock) ? 3 : 5)).findFirst();
        else roof = piecesList.stream().filter(s -> s instanceof Roof).filter(s -> s.isWhite == this.isWhite).filter(s -> s.positionX == ((gRock) ? 0 : 7)).findFirst();
        roof.ifPresent(pieces -> {
            if(isUndo) pieces.changePosition((double) ((!gRock) ? 0 : 7) * 70, (double) pieces.positionY * 70);
            else pieces.changePosition((double) ((gRock) ? 3 : 5) * 70, (double) pieces.positionY * 70);
            isUndo = false;
            lastMove += "\n - " + this.name + " : (" + this.positionX + "-" + this.positionY + ") to (" + (this.positionX+((gRock) ? -2 : 2)) + "-" + this.positionY + ") Rock !";
        });
    }

    boolean pieceInSameCase(int x, int y) {
        for (Pieces piece : piecesList) {
            if (y == piece.positionY && x == piece.positionX && piece != this) return true;
        }
        return false;
    }

    boolean pieceInSameCaseAndSameColor(int x, int y) {
        for (Pieces piece : piecesList) {
            if (y == piece.positionY && x == piece.positionX && piece != this && piece.isWhite == this.isWhite)
                return true;
        }
        return false;
    }

    boolean pieceInSameCaseNotSameColor(int x, int y) {
        for (Pieces piece : piecesList) {
            if (y == piece.positionY && x == piece.positionX && piece != this && piece.isWhite != this.isWhite)
                return true;
        }
        return false;
    }

    public abstract Double[] getPossibleMove();

    public boolean isFirstMove() {
        return isFirstMove;
    }
}
