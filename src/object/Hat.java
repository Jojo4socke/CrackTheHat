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
//75 max field

public class Hat extends JFrame {
    String hatColour;
    String numCapturedHats;
    int hatPosition = 0; // needs to be replaced with starting field
    int playerID;
    int maxField = 75;

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

    private Hat(String color, String hatCaptures, int eyes, int playerID){
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
        this.playerID = playerID;

    }
    @Override
    public void paint(Graphics g) {
        // map colours to Color Object to change colour of Player
        HashMap<String, Color> colourMapper = new HashMap<>();

        colourMapper.put("blue", Color.blue);
        colourMapper.put("yellow", Color.yellow);
        colourMapper.put("green", Color.green);
        colourMapper.put("pink", Color.pink);
        colourMapper.put("orange", Color.orange);
        colourMapper.put("magenta", Color.magenta);

        createPlayerHat(g, colourMapper.get(hatColour));
        createCapturedHatsString(g,numCapturedHats);
    }

    private int getHatPosition(){
        return hatPosition;
    }

    private void setHatPosition(int position){
        this.hatPosition += position;
    }

    // hat position cant exceed maxField, maxField is 75 on a 4 player board
    private void onRoll(int eyes){
        if(eyes + getHatPosition() <= maxField){
                setHatPosition(eyes);
        }else{
            this.hatPosition = 0;
        }
    }

    public static void main(String[] args) {
        // testing
        // creating multiple hats
        Hat[] obj = new Hat[5];
        obj[0] = new Hat("blue","1",0,1);
        obj[1] = new Hat("magenta","2",0,2);
        obj[2] = new Hat("orange","3",0,3);
        obj[3] = new Hat("pink","4",0,4);
        obj[4] = new Hat("green","5",0,5);
        //Hat crackHat = new Hat("magenta","6",0, 1);
        System.out.println("start");
        // simulating dice throws
        for (int i = 0; i < obj.length; i++){
            System.out.println("Position throw " + i + "of " + obj[i].hatColour);
            obj[i].onRoll(Dice.throwDice());
            System.out.println(obj[i].getHatPosition());
        }
    }
}
