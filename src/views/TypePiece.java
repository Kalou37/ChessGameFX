package views;

public enum TypePiece{
    ROOF(false),
    KNIGHT(false),
    BISHOP(false),
    QUEEN(false),
    KING(false),
    BLACK_PAWN(false),
    WHITE_PAWN(false);

    private boolean firstMove;

    TypePiece(boolean firstMove){
        this.firstMove = firstMove;
    }

    public boolean isFirstMove(){
        return this.firstMove;
    }
}
