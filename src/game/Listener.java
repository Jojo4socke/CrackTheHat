package game;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    JButton startButton;
    JButton exitButton;
    MainMenu mainMenu;

    public Listener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        startButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.startButton) {
            GameScreen gameScreen = new GameScreen();
            gameScreen.changeToGameScreen(mainMenu);
        } else if (ae.getSource() == this.exitButton) {
            mainMenu.dispose();
        }
    }
}
