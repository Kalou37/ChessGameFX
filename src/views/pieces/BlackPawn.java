package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BlackPawn extends Pieces{
    public BlackPawn(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        if(posY+1 < 8 && !pieceInSameCase(posX, posY+1)) valueReturn.add(posX + ((double) (posY+1) / 10));
        if(posY == 1 && !pieceInSameCase(posX, 2) && !pieceInSameCase(posX, 3)) valueReturn.add(posX + 0.3);
        if(pieceInSameCaseNotSameColor(posX-1, posY+1)) valueReturn.add(posX-1 + ((double) (posY+1) / 10));
        if(pieceInSameCaseNotSameColor(posX+1, posY+1)) valueReturn.add(posX+1 + ((double) (posY+1) / 10));
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}