package game;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainMenu extends JFrame{

    JPanel panel;
    JButton startButton;


    public MainMenu() {
        setTitle("CrackTheHat");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        Listener listener = new Listener(this);
        panel.add(listener.startButton);
        panel.add(listener.exitButton);
        add(panel);
    }

    void render() {
        setVisible(true);
        panel.repaint();
    }

    public void tick() {
        render();
    }
}
