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

    // Constructors
    /**
     * Constrcutor to create a hat.
     * @param hatNumber player's unique hat number
     * @param player owner of the hat
     */
    public Hat(int hatNumber, Player player){
        this.hatNumber = hatNumber;
        this.player = player;
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
        g2d.fillOval(150, 150, 100, 100);
    }

    /**
     * Create the captured hats below the player's hat.
     * @param g basic renderer for drawing
     */
    private void createCapturedHatsString(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g2d.drawString(Integer.toString(capturedHats.size()), 185, 210);

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
        return new ArrayList<>(capturedHats);
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

}
