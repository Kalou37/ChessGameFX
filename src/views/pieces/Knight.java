package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Pieces{
    public Knight(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        if(posX-1 >= 0 && posY-2 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY-2)) valueReturn.add(posX-1 + ((double) (posY-2) / 10));
        if(posX+1 < 8 && posY-2 >= 0 && !pieceInSameCaseAndSameColor(posX+1, posY-2)) valueReturn.add(posX+1 + ((double) (posY-2) / 10));
        if(posX-2 >= 0 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX-2, posY-1)) valueReturn.add(posX-2 + ((double) (posY-1) / 10));
        if(posX+2 < 8 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX+2, posY-1)) valueReturn.add(posX+2 + ((double) (posY-1) / 10));
        if(posX-1 >= 0 && posY+2 < 8 && !pieceInSameCaseAndSameColor(posX-1, posY+2)) valueReturn.add(posX-1 + ((double) (posY+2) / 10));
        if(posX+1 < 8 && posY+2 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY+2)) valueReturn.add(posX+1 + ((double) (posY+2) / 10));
        if(posX-2 >= 0 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX-2, posY+1)) valueReturn.add(posX-2 + ((double) (posY+1) / 10));
        if(posX+2 < 8 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX+2, posY+1)) valueReturn.add(posX+2 + ((double) (posY+1) / 10));
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}
