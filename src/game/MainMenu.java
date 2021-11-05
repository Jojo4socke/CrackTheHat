package game;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainMenu extends JFrame{

    JPanel panel;
<<<<<<< HEAD
    JButton startButton
=======
>>>>>>> 0d99718db51a1f4cb1b9f744c4998c55b51a4b90

    public MainMenu() {
        setTitle("CrackTheHat");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
<<<<<<< HEAD

=======
        Listener listener = new Listener(this);
        panel.add(listener.startButton);
        panel.add(listener.exitButton);
        add(panel);
>>>>>>> 0d99718db51a1f4cb1b9f744c4998c55b51a4b90
    }

    private void render() {
        setVisible(true);
        panel.repaint();
    }

    public void tick() {
        render();
    }

<<<<<<< HEAD
    public void () {

    }
=======
>>>>>>> 0d99718db51a1f4cb1b9f744c4998c55b51a4b90
}
