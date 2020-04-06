package views;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Pieces {
    private String name;
    private ImageView imageView;
    private boolean isWhite;
    private int positionX;
    private int positionY;
    private TypePiece typePiece;
    private static ArrayList<Pieces> piecesList = new ArrayList<>();

    public Pieces(String name, ImageView imgView, boolean colorWhite, int posX, int posY, TypePiece typePiece) {
        this.name = name;
        this.imageView = imgView;
        this.isWhite = colorWhite;
        this.positionX = posX;
        this.positionY = posY;
        this.typePiece = typePiece;
        piecesList.add(this);
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

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public static ArrayList<Pieces> getPiecesList() { return piecesList; }

    public static void removePiece(Pieces piece){ piecesList.remove(piece); }

    public boolean isWhite() { return isWhite; }

    public void changePosition(Double x, Double y) {
        this.positionX = (int) Math.floor(x / 70);
        this.positionY = (int) Math.floor(y / 70);
        this.imageView.relocate(Math.floor(x / 70) * 70 + 10, Math.floor(y / 70) * 70 + 10);
    }

    private boolean pieceInSameCase(int x, int y){
        for(Pieces piece : piecesList){
            if(y == piece.positionY && x == piece.positionX && piece != this) return true;
        }
        return false;
    }

    private boolean pieceInSameCaseAndSameColor(int x, int y){
        for(Pieces piece : piecesList){
            if(y == piece.positionY && x == piece.positionX && piece != this && piece.isWhite == this.isWhite) return true;
        }
        return false;
    }

    private boolean pieceInSameCaseNotSameColor(int x, int y){
        for(Pieces piece : piecesList){
            if(y == piece.positionY && x == piece.positionX && piece != this && piece.isWhite != this.isWhite) return true;
        }
        return false;
    }

    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> retour = new ArrayList<>();
        switch (this.getTypePiece()) {
            case ROOF:
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX+i, posY)) break;
                    if(posX + i < 8) retour.add((double) posX + i + ((double) posY / 10));
                    if(pieceInSameCase(posX+i, posY)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY)) break;
                    if(posX - i >= 0) retour.add((double) posX - i + ((double) posY / 10));
                    if(pieceInSameCase(posX-i, posY)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX, posY+i)) break;
                    if (posY + i < 8) retour.add(posX + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX, posY-i)) break;
                    if (posY - i >= 0) retour.add(posX + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX, posY-i)) break;
                }
                break;
            case KNIGHT:
                if(posX-1 >= 0 && posY-2 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY-2)) retour.add(posX-1 + ((double) (posY-2) / 10));
                if(posX+1 < 8 && posY-2 >= 0 && !pieceInSameCaseAndSameColor(posX+1, posY-2)) retour.add(posX+1 + ((double) (posY-2) / 10));
                if(posX-2 >= 0 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX-2, posY-1)) retour.add(posX-2 + ((double) (posY-1) / 10));
                if(posX+2 < 8 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX+2, posY-1)) retour.add(posX+2 + ((double) (posY-1) / 10));
                if(posX-1 >= 0 && posY+2 < 8 && !pieceInSameCaseAndSameColor(posX-1, posY+2)) retour.add(posX-1 + ((double) (posY+2) / 10));
                if(posX+1 < 8 && posY+2 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY+2)) retour.add(posX+1 + ((double) (posY+2) / 10));
                if(posX-2 >= 0 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX-2, posY+1)) retour.add(posX-2 + ((double) (posY+1) / 10));
                if(posX+2 < 8 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX+2, posY+1)) retour.add(posX+2 + ((double) (posY+1) / 10));
                break;
            case BISHOP:
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY-i)) break;
                    if(posX - i >= 0 && posY - i >= 0) retour.add((double) posX - i + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX-i, posY-i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX+i, posY+i)) break;
                    if(posX + i < 8 && posY + i < 8) retour.add((double) posX + i + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX+i, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY+i)) break;
                    if(posX - i >= 0 && posY + i < 8) retour.add((double) posX - i + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX-i, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY-i)) break;
                    if(posX + i < 8 && posY - i >= 0) retour.add((double) posX + i + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX-i, posY-i)) break;
                }
                break;
            case QUEEN:
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX+i, posY)) break;
                    retour.add((double) posX + i + ((double) posY / 10));
                    if(pieceInSameCase(posX+i, posY)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY)) break;
                    retour.add((double) posX - i + ((double) posY / 10));
                    if(pieceInSameCase(posX-i, posY)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX, posY+i)) break;
                    if (posY + i < 8) retour.add(posX + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX, posY-i)) break;
                    if (posY - i >= 0) retour.add(posX + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX, posY-i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY-i)) break;
                    if(posX - i >= 0 && posY - i >= 0) retour.add((double) posX - i + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX-i, posY-i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX+i, posY+i)) break;
                    if(posX + i < 8 && posY + i < 8) retour.add((double) posX + i + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX+i, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY+i)) break;
                    if(posX - i >= 0 && posY + i < 8) retour.add((double) posX - i + ((double) (posY + i) / 10));
                    if(pieceInSameCase(posX-i, posY+i)) break;
                }
                for (int i = 1; i < 8; i++) {
                    if(pieceInSameCaseAndSameColor(posX-i, posY-i)) break;
                    if(posX + i < 8 && posY - i >= 0) retour.add((double) posX + i + ((double) (posY - i) / 10));
                    if(pieceInSameCase(posX-i, posY-i)) break;
                }
                break;
            case KING:
                if(this.typePiece.isFirstMove()) System.out.println("First move, Rock possible !");
                if(posX-1 >= 0 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY-1)) retour.add(posX-1 + ((double) (posY-1) / 10));
                if(posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX, posY-1)) retour.add(posX + ((double) (posY-1) / 10));
                if(posX+1 < 8 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX+1, posY-1)) retour.add(posX+1 + ((double) (posY-1) / 10));
                if(posX-1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY)) retour.add(posX-1 + ((double) (posY) / 10));
                if(posX+1 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY)) retour.add(posX+1 + ((double) (posY) / 10));
                if(posX-1 >= 0 && posY+1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY+1)) retour.add(posX-1 + ((double) (posY+1) / 10));
                if(posY+1 < 8 && !pieceInSameCaseAndSameColor(posX, posY+1)) retour.add(posX + ((double) (posY+1) / 10));
                if(posX+1 < 8 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY+1)) retour.add(posX+1 + ((double) (posY+1) / 10));
                break;
            case BLACK_PAWN:
                if(posY+1 < 8 && !pieceInSameCase(posX, posY+1)) retour.add(posX + ((double) (posY+1) / 10));
                if(posY == 1 && !pieceInSameCase(posX, 2) && !pieceInSameCase(posX, 3)) retour.add(posX + 0.3);
                if(pieceInSameCaseNotSameColor(posX-1, posY+1)) retour.add(posX-1 + ((double) (posY+1) / 10));
                if(pieceInSameCaseNotSameColor(posX+1, posY+1)) retour.add(posX+1 + ((double) (posY+1) / 10));
                break;
            case WHITE_PAWN:
                if(posY-1 >= 0 && !pieceInSameCase(posX, posY-1)) retour.add(posX + ((double) (posY-1) / 10));
                if(posY == 6 && !pieceInSameCase(posX, 5) && !pieceInSameCase(posX, 4)) retour.add(posX + 0.4);
                if(pieceInSameCaseNotSameColor(posX-1, posY-1)) retour.add(posX-1 + ((double) (posY-1) / 10));
                if(pieceInSameCaseNotSameColor(posX+1, posY-1)) retour.add(posX+1 + ((double) (posY-1) / 10));
                break;
            default:
                retour.add(1.1);
                break;
        }
        Double[] array = new Double[retour.size()];
        array = retour.toArray(array);
        return array;
    }
}
