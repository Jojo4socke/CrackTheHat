package game;

import javax.swing.*;

public class GameScreen extends JFrame {

    public GameScreen() {

    }

    public void changeToGameScreen(MainMenu mainMenu) {
        JLabel label = new JLabel();
        label.setText("Game is starting");
        mainMenu.panel.add(label);
        //TODO add GUIBoard to Panel
        mainMenu.setTitle("Game");
        mainMenu.tick();
    }
}
