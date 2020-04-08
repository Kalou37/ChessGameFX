package views.pieces;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class King extends Pieces{
    public King(String name, ImageView imgView, boolean colorWhite, int posX, int posY) {
        super(name, imgView, colorWhite, posX, posY);
    }

    @Override
    public Double[] getPossibleMove() {
        int posX = this.positionX;
        int posY = this.positionY;
        List<Double> valueReturn = new ArrayList<>();
        if(this.isFirstMove){
            for(Pieces piece : piecesList){
                if(this.isWhite && piece instanceof Roof && piece.isWhite && !pieceInSameCase(5,7) && !pieceInSameCase(6,7) && piece.isFirstMove && piece.positionX == 7) valueReturn.add(posX+2 + ((double) (posY) / 10));
                if(this.isWhite && piece instanceof Roof && piece.isWhite && !pieceInSameCase(3,7) && !pieceInSameCase(2,7) && !pieceInSameCase(1,7) && piece.isFirstMove && piece.positionX == 0) valueReturn.add(posX-2 + ((double) (posY) / 10));
                if(!this.isWhite && piece instanceof Roof && !piece.isWhite && !pieceInSameCase(5,0) && !pieceInSameCase(6,0) && piece.isFirstMove && piece.positionX == 7) valueReturn.add(posX+2 + ((double) (posY) / 10));
                if(!this.isWhite && piece instanceof Roof && !piece.isWhite && !pieceInSameCase(3,0) && !pieceInSameCase(2,0) && !pieceInSameCase(1,0) && piece.isFirstMove && piece.positionX == 0) valueReturn.add(posX-2 + ((double) (posY) / 10));
            }
        }
        if(posX-1 >= 0 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY-1)) valueReturn.add(posX-1 + ((double) (posY-1) / 10));
        if(posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX, posY-1)) valueReturn.add(posX + ((double) (posY-1) / 10));
        if(posX+1 < 8 && posY-1 >= 0 && !pieceInSameCaseAndSameColor(posX+1, posY-1)) valueReturn.add(posX+1 + ((double) (posY-1) / 10));
        if(posX-1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY)) valueReturn.add(posX-1 + ((double) (posY) / 10));
        if(posX+1 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY)) valueReturn.add(posX+1 + ((double) (posY) / 10));
        if(posX-1 >= 0 && posY+1 >= 0 && !pieceInSameCaseAndSameColor(posX-1, posY+1)) valueReturn.add(posX-1 + ((double) (posY+1) / 10));
        if(posY+1 < 8 && !pieceInSameCaseAndSameColor(posX, posY+1)) valueReturn.add(posX + ((double) (posY+1) / 10));
        if(posX+1 < 8 && posY+1 < 8 && !pieceInSameCaseAndSameColor(posX+1, posY+1)) valueReturn.add(posX+1 + ((double) (posY+1) / 10));
        Double[] array = new Double[valueReturn.size()];
        array = valueReturn.toArray(array);
        return array;
    }
}
