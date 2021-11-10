package game;

import gameBoard.BoardGUI;

import javax.swing.*;

public class GameScreen extends MainMenu {

    private BoardGUI boardGUI;

    public GameScreen() {

    }

    public void changeToGameScreen(MainMenu mainMenu) {
        //TODO add GUIBoard to Panel
        this.boardGUI = new BoardGUI();
        mainMenu.dispose();
        render();
    }

    private void render() {

    }
}
