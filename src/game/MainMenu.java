package game;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class MainMenu extends JFrame{

    public MainMenu() {
        setTitle("CrackTheHat");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showMainMenu() {
        setVisible(true);
    }
}
