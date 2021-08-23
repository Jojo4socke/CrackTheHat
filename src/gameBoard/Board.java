package gameBoard;

import gameBoard.field.Field;

import java.util.List;

public class Board {
    private List<Field> allFields;

    public Board() {
        allFields = generateBoard();
    }

    private static List<Field> generateBoard() {
        //TODO: implement actual board generation
        return null;
    }
}
