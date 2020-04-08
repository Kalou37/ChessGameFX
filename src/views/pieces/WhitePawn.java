package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class WhitePawn extends Pieces{
    public WhitePawn(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        if(posY-1 >= 0 && !pieceInSameCase(posX, posY-1)) valueReturn.add(posX + ((double) (posY-1) / 10));
        if(posY == 6 && !pieceInSameCase(posX, 5) && !pieceInSameCase(posX, 4)) valueReturn.add(posX + 0.4);
        if(pieceInSameCaseNotSameColor(posX-1, posY-1)) valueReturn.add(posX-1 + ((double) (posY-1) / 10));
        if(pieceInSameCaseNotSameColor(posX+1, posY-1)) valueReturn.add(posX+1 + ((double) (posY-1) / 10));
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}