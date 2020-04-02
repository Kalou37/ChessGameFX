package views;

import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public abstract class ListPieces {
    private static Map<ImageView, Pieces> map = new HashMap<>();

    public static void addPieces(ImageView piece){
        for(Pieces enumPiece: Pieces.values()){
            if(piece.getId().equals(enumPiece.getName())){
                map.put(piece, enumPiece);
            }
        }
    }

    public static ImageView isPiece(ImageView piece, int x, int y){
        map.get(piece).setPositionX(x);
        map.get(piece).setPositionY(y);
        for(Map.Entry<ImageView, Pieces> entry : map.entrySet()) {
            ImageView key = entry.getKey();
            Pieces value = entry.getValue();
            if (x == value.getPositionX() && y == value.getPositionY() && key != piece) {
                map.remove(key);
                return key;
            }
        }
        return null;
    }
}

enum Pieces {
    W_ROOF_1("whiteRoof1", 0, 7),
    W_ROOF_2("whiteRoof2", 7, 7),
    W_KNIGHT_1("whiteKnight1", 1, 7),
    W_KNIGHT_2("whiteKnight2", 6, 7),
    W_BISHOP_1("whiteBishop1", 2, 7),
    W_BISHOP_2("whiteBishop2", 5, 7),
    W_QUEEN("whiteQueen", 3, 7),
    W_KING("whiteKing", 4, 7),
    B_ROOF_1("blackRoof1", 0, 0),
    B_ROOF_2("blackRoof2", 7, 0),
    B_KNIGHT_1("blackKnight1", 1, 0),
    B_KNIGHT_2("blackKnight2", 6, 0),
    B_BISHOP_1("blackBishop1", 2, 0),
    B_BISHOP_2("blackBishop2", 5, 0),
    B_QUEEN("blackQueen", 3, 0),
    B_KING("blackKing", 4, 0),
    W_PAWN_1("whitePawn1", 0, 6),
    W_PAWN_2("whitePawn2", 1, 6),
    W_PAWN_3("whitePawn3", 2, 6),
    W_PAWN_4("whitePawn4", 3, 6),
    W_PAWN_5("whitePawn5", 4, 6),
    W_PAWN_6("whitePawn6", 5, 6),
    W_PAWN_7("whitePawn7", 6, 6),
    W_PAWN_8("whitePawn8", 7, 6),
    B_PAWN_1("blackPawn1", 0, 1),
    B_PAWN_2("blackPawn2", 1, 1),
    B_PAWN_3("blackPawn3", 2, 1),
    B_PAWN_4("blackPawn4", 3, 1),
    B_PAWN_5("blackPawn5", 4, 1),
    B_PAWN_6("blackPawn6", 5, 1),
    B_PAWN_7("blackPawn7", 6, 1),
    B_PAWN_8("blackPawn8", 7, 1);

    private String name;
    private int positionX;
    private int positionY;

    Pieces(String name, int posX, int posY){
        this.name = name;
        this.positionX = posX;
        this.positionY = posY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getName() {
        return name;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
