package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Pieces {
    public Bishop(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (pieceInSameCaseAndSameColor(posX - i, posY - i)) break;
            if (posX - i >= 0 && posY - i >= 0) valueReturn.add((double) posX - i + ((double) (posY - i) / 10));
            if (pieceInSameCase(posX - i, posY - i)) break;
        }
        for (int i = 1; i < 8; i++) {
            if (pieceInSameCaseAndSameColor(posX + i, posY + i)) break;
            if (posX + i < 8 && posY + i < 8) valueReturn.add((double) posX + i + ((double) (posY + i) / 10));
            if (pieceInSameCase(posX + i, posY + i)) break;
        }
        for (int i = 1; i < 8; i++) {
            if (pieceInSameCaseAndSameColor(posX - i, posY + i)) break;
            if (posX - i >= 0 && posY + i < 8) valueReturn.add((double) posX - i + ((double) (posY + i) / 10));
            if (pieceInSameCase(posX - i, posY + i)) break;
        }
        for (int i = 1; i < 8; i++) {
            if (pieceInSameCaseAndSameColor(posX + i, posY - i)) break;
            if (posX + i < 8 && posY - i >= 0) valueReturn.add((double) posX + i + ((double) (posY - i) / 10));
            if (pieceInSameCase(posX + i, posY - i)) break;
        }
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}
