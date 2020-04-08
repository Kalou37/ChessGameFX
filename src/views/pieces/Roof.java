package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Roof extends Pieces{
    public Roof(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(pieceInSameCaseAndSameColor(posX+i, posY)) break;
            if(posX + i < 8) valueReturn.add((double) posX + i + ((double) posY / 10));
            if(pieceInSameCase(posX+i, posY)) break;
        }
        for (int i = 1; i < 8; i++) {
            if(pieceInSameCaseAndSameColor(posX-i, posY)) break;
            if(posX - i >= 0) valueReturn.add((double) posX - i + ((double) posY / 10));
            if(pieceInSameCase(posX-i, posY)) break;
        }
        for (int i = 1; i < 8; i++) {
            if(pieceInSameCaseAndSameColor(posX, posY+i)) break;
            if (posY + i < 8) valueReturn.add(posX + ((double) (posY + i) / 10));
            if(pieceInSameCase(posX, posY+i)) break;
        }
        for (int i = 1; i < 8; i++) {
            if(pieceInSameCaseAndSameColor(posX, posY-i)) break;
            if (posY - i >= 0) valueReturn.add(posX + ((double) (posY - i) / 10));
            if(pieceInSameCase(posX, posY-i)) break;
        }
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}
