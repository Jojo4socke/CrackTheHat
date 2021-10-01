package object;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//TODO
// -Player position on board (kinda implemented)
// - updates on captured hats
// - probably a bunch of other stuff.
// - if player can walk backwards need to add some kind of direction to update position of hat?
//75 max field

public class Hat extends JFrame {
    /**
     * @param isCaptured indicates whether this hat is captured or not
     */
    boolean isCaptured;
    /**
     * @param capturedHats list of all hats that are currently captured by the hat
     */
    private ArrayList<Hat> capturedHats;
    Color hatColour;
    int amountCapturedHats;
    int hatPosition = 0; // needs to be replaced with starting field
    Player player;
    int maxField = 75;

    public Hat(int hatCaptures, int eyes, Player player){
        // create JFrame can be removed later, probably (hopefully)
        setTitle("Hat");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // pass params
        this.hatColour = player.getPlayerColor();
        this.amountCapturedHats = hatCaptures;
        this.hatPosition = getHatPosition();
        onRoll(eyes);
        this.player = player;

    }

    private void createPlayerHat(Graphics g, Color colorPlayer) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(colorPlayer);
        g2d.fillOval(150, 150, 100, 100);
    }

    private void createCapturedHatsString(Graphics g, int capturedHats){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g2d.drawString(Integer.toString(capturedHats), 185, 210);

    }

    @Override
    public void paint(Graphics g) {
        createPlayerHat(g, hatColour);
        createCapturedHatsString(g, amountCapturedHats);
    }

    public int getHatPosition(){
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
        obj[0] = new Hat(1,0,
                new Player(1, 4, Color.blue));
        obj[1] = new Hat(2,0,
                new Player(2, 4, Color.magenta));
        obj[2] = new Hat(3,0,
                new Player(3, 4, Color.orange));
        obj[3] = new Hat(4,0,
                new Player(4, 4, Color.pink));
        obj[4] = new Hat(5,0,
                new Player(5, 4, Color.green));
        //Hat crackHat = new Hat("magenta","6",0, 1);
        System.out.println("start");
        // simulating dice throws
        for (int i = 0; i < obj.length; i++){
            System.out.println("Position throw " + i + "of " + obj[i].hatColour);
            obj[i].onRoll(Dice.throwDice());
            System.out.println(obj[i].getHatPosition());
        }
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public void addVictim(Hat victim) {
        capturedHats.add(victim);
        player.increaseAmountCapturedHats();
    }

}
