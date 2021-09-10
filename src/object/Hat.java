package object;

import object.Dice;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
//TODO
// -Player position on board (kinda implemented)
// - updates on captured hats
// - probably a bunch of other stuff.
// - if player can walk backwards need to add some kind of direction to update position of hat?

public class Hat extends JFrame {
    String hatColour;
    String numCapturedHats;
    int hatPosition = 0; // needs to be replaced with starting field

    private void createPlayerHat(Graphics g, Color colorPlayer) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorPlayer);
        g2d.fillOval(150, 150, 100, 100);
    }

    private  void createCapturedHatsString(Graphics g, String capturedHats){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g2d.drawString(capturedHats, 185, 210);

    }

    public Hat(String color, String hatCaptures, int eyes ){
        // create JFrame can be removed later, probably
        setTitle("Hat");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // pass params
        this.hatColour = color;
        this.numCapturedHats = hatCaptures;
        this.hatPosition = getHatPosition();
        onRoll(eyes);
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
        createCapturedHatsString(g,numCapturedHats);
    }

    public int getHatPosition(){
        return hatPosition;
    }

    public void setHatPosition(int position){
        this.hatPosition += position;
    }

    public void onRoll(int eyes){
        setHatPosition(eyes);
    }

    public static void main(String[] args) {
        // eyes set to zero as there was no dice roll yet;
        Hat crackHat = new Hat("blue","6",0);
        System.out.println("start");
        System.out.println(crackHat.getHatPosition());
        // simulating dice throws
        for (int i = 0; i < 2; i++){
            System.out.println("Position throw" + i);
            crackHat.onRoll(Dice.throwDice());
            System.out.println(crackHat.getHatPosition());
        }
    }
}
