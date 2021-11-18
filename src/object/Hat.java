package object;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//TODO
// -Player position on board (kinda implemented)
// - updates on captured hats
// - probably a bunch of other stuff.
// - if player can walk backwards need to add some kind of direction to update position of hat?
//75 max field

public class Hat extends JFrame {
    /**
     * @param player owner of the hat
     */
    Player player;
    /**
     * @param hatNumber player's unique hat number
     */
    int hatNumber;
    /**
     * @param isCaptured indicates whether the hat is captured (true) or free (false)
     */
    boolean isCaptured;
    /**
     * @param capturedHats list of all hats that are currently captured by the hat
     */
    private List<Hat> capturedHats = new ArrayList<>();
    int hatPosition = 0;

    // Constructors
    /**
     * Constrcutor to create a hat.
     * @param hatNumber player's unique hat number
     * @param player owner of the hat
     */
    public Hat(int hatNumber, Player player){
        this.hatNumber = hatNumber;
        this.player = player;
        this.hatPosition = getHatPosition();
        // create JFrame can be removed later, probably (hopefully)
        setTitle("Hat");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Methods
    /**
     * Create a visual hat on the board.
     * @param g basic renderer for drawing
     */
    private void createPlayerHat(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(player.getPlayerColor());
        //g2d.fillOval(150, 150, 100, 100);
        paintTriangle(g2d);
    }

    public void paintTriangle(Graphics g) {
        int [] x = {50,100,0};
        int [] y = {0,100,100};
        g.translate(150, 150);
        //g.drawPolygon(x, y, 3);
        g.fillPolygon(x, y, 3);
    }

    /**
     * Create the captured hats below the player's hat.
     * @param g basic renderer for drawing
     */
    private void createCapturedHatsString(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g2d.drawString(Integer.toString(capturedHats.size()), 35, 85);

    }

    /**
     * Draw the player's hat with it's captured victims below.
     * @param g basic renderer for drawing
     */
    @Override
    public void paint(Graphics g) {
        createPlayerHat(g);
        createCapturedHatsString(g);
    }

    /**
     * Test Runner.
     * @param args
     */
    /*
    public static void main(String[] args) {
        // testing
        // creating multiple hats
        Hat[] obj = new Hat[5];
        obj[0] = new Hat(1,
                new Player(1, 4, Color.blue));
        obj[1] = new Hat(2,
                new Player(2, 4, Color.magenta));
        obj[2] = new Hat(3,
                new Player(3, 4, Color.orange));
        obj[3] = new Hat(4,
                new Player(4, 4, Color.pink));
        obj[4] = new Hat(5,
                new Player(5, 4, Color.green));
        System.out.println(obj[0].getHatPosition());
        //Hat crackHat = new Hat("magenta","6",0, 1);
    }*/

    /**
     * Getter for the player.
     * @return owner of the hat
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for the hats number.
     */
    public int getHatNumber() {
        return hatNumber;
    }

    /**
     * Getter for the hats status.
     */
    public boolean getStatus() {
        return isCaptured;
    }

    /**
     * Getter for the list of captured hats.
     */
    public List<Hat> getCapturedHats() {
        return capturedHats;
    }

    /**
     * Set the hats status to captured (true) or free (false).
     * @param captured is the hat captured?
     */
    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    /**
     * Add the victim to the list of captured hats and increase the amount of captured hats for the player.
     * @param victim the hat that has been captured
     */
    public void addVictim(Hat victim) {
        capturedHats.add(victim);
        player.increaseAmountCapturedHats();
    }

    /**
     * Store all captured hats and clear the list.
     */
    public void storeVictims() {
        player.increaseAmountStoredHats(capturedHats.size());
        capturedHats.clear();
    }
    // getter hatPosition defaults to zero as I don't know yet where hats are stored
    // if they are not on the field
    public int getHatPosition() {
        return hatPosition;
    }
    // used to set position of hat
    private void setHatPosition(int position){
        this.hatPosition = position;
    }

}
