package gameBoard.figures;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
//TODO
// -Player position on board
// - updates on captured hats
// - probably a bunch of other stuff.

public class Hat extends JFrame {
    String hatColour;
    String numCapturedHats;

    private void createPlayerHat(Graphics g, Color colorPlayer) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorPlayer);
        g2d.fillOval(150, 150, 100, 100);
    }

    private  void createCapuredHatsString(Graphics g, String capuredHats){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g2d.drawString(capuredHats, 185, 210);

    }

    public Hat(String color, String hatCaptures){
        // create JFrame can be removed later, probably
        setTitle("Hat");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // pass params
        this.hatColour = color;
        this.numCapturedHats = hatCaptures;
    }
    @Override
    public void paint(Graphics g) {
        // map colours to Color Object to change colour of Player
        HashMap<String, Color> colourMapper = new HashMap<>();
        colourMapper.put("blue", Color.blue);
        colourMapper.put("yellow", Color.yellow);
        colourMapper.put("green", Color.green);
        colourMapper.put("pink", Color.pink);

        createPlayerHat(g, colourMapper.get(hatColour));
        createCapuredHatsString(g,numCapturedHats);
    }

    public static void main(String[] args) {
        new Hat("blue","6");
    }
}


