package game;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends JFrame implements MouseListener {

    public MainMenu() {
        setTitle("CrackTheHat");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showMainMenu() {
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
