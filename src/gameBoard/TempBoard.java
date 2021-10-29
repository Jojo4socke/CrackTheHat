package gameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class TempBoard extends JFrame{
    public static void main(String[] args){
        new TempBoard();
    }

    /**
     * CREATES THE BASIC APPLICATION WINDOW FROM "FANG DEN HUT"
     * AND SETS SOME BASIC OPTIONS LIKE THE DefaultCloseOperation
     */
    public TempBoard(){
        super("Fang Den Hut - Battle Royal");
        setLayout(new BorderLayout());
        add(new Gamefield(), BorderLayout.CENTER);
        pack();
        repaint();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * CREATES THE GAME FIELD AND GAME FIELD COMPONENTS
     * NAMELY THE BOARD ITSELF, THE STARTING FIELDS AND DICE VISUALISATION
     *
     * fields CONTAINS THE MANY DIFFERENT FIELDS FROM THE BOARD
     */
    class Gamefield extends JPanel implements MouseListener{
        private Polygon[] fields = new Polygon[81];

        /**
         * THE GUI RECEIVES A MouseListener TO ALLOW INTERACTION WITH THE GUI
         *
         * APPLICATION ALSO HAS A SET PREFERRED SIZE WHICH ADDS heightGame TO IT
         * TO CREATE A RE-SIZABLE WINDOW
         *
         * heightGame IS THE SIZE OF THE SCREEN WHERE THE APPLICATION IS DISPLAYED
         *            THIS ALLOWS THE APPLICATION TO CUSTOMIZE THE GUI SIZE DEPENDING
         *            ON THE SCREEN ON WHICH THE APPLICATION IS RUNNING
         */
        public Gamefield() {
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int heightGame = (int)size.getHeight() - 100;
            int[] x = new int[4];
            int[] y = new int[4];
            x[0] = heightGame/25;
            x[1] = heightGame/25;
            x[2] = heightGame/7;
            x[3] = heightGame/7;

            y[0] = heightGame/25;
            y[1] = heightGame/7;
            y[2] = heightGame/7;
            y[3] = heightGame/25;

            for(int i = 0; i < fields.length; i++){
                fields[i] = new Polygon();
            }

            //UPPER LEFT
            fields[0].addPoint(x[0], y[0]);
            fields[0].addPoint(x[1], y[1]);
            fields[0].addPoint(x[2], y[2]);
            fields[0].addPoint(x[3], y[3]);

            //UPPER SIDE
            x[0] = heightGame/7;
            x[1] = heightGame/7;
            x[2] = heightGame/7+50;
            x[3] = heightGame/7+50;

            for(int i=1; i<13; i++){
                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);

                x[0] += 50;
                x[1] += 50;
                x[2] += 50;
                x[3] += 50;
            }

            //UPPER RIGHT
            x[2] += (heightGame/7 - heightGame/25 - 50);
            x[3] += (heightGame/7 - heightGame/25 - 50);

            fields[13].addPoint(x[0], y[0]);
            fields[13].addPoint(x[1], y[1]);
            fields[13].addPoint(x[2], y[2]);
            fields[13].addPoint(x[3], y[3]);

            //RIGHT SIDE
            y[0] = heightGame/7;
            y[1] = heightGame/7+50;
            y[2] = heightGame/7+50;
            y[3] = heightGame/7;

            for(int i=14; i<26; i++){
                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);

                y[0] += 50;
                y[1] += 50;
                y[2] += 50;
                y[3] += 50;
            }

            //BOTTOM RIGHT
            y[1] += (heightGame/7 - heightGame/25 - 50);
            y[2] += (heightGame/7 - heightGame/25 - 50);

            fields[26].addPoint(x[0], y[0]);
            fields[26].addPoint(x[1], y[1]);
            fields[26].addPoint(x[2], y[2]);
            fields[26].addPoint(x[3], y[3]);

            //BOTTOM SIDE
            x[0] -= 50;
            x[1] -= 50;
            x[2] -= (heightGame/7 - heightGame/25);
            x[3] -= (heightGame/7 - heightGame/25);

            for(int i=27; i<39; i++){
                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);

                x[0] -= 50;
                x[1] -= 50;
                x[2] -= 50;
                x[3] -= 50;
            }

            //BOTTOM LEFT
            x[0] = heightGame/25;
            x[1] = heightGame/25;

            fields[39].addPoint(x[0], y[0]);
            fields[39].addPoint(x[1], y[1]);
            fields[39].addPoint(x[2], y[2]);
            fields[39].addPoint(x[3], y[3]);

            //LEFT SIDE
            y[0] -= 50;
            y[1] -= (heightGame/7 - heightGame/25);
            y[2] -= (heightGame/7 - heightGame/25);
            y[3] -= 50;

            for(int i=40; i<52; i++){
                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);

                y[0] -= 50;
                y[1] -= 50;
                y[2] -= 50;
                y[3] -= 50;
            }

            //Middle Field
            x[0] = heightGame/7 + 6 * 50;
            x[1] = heightGame/7 + 6 * 50-50;
            x[2] = heightGame/7 + 6 * 50;
            x[3] = heightGame/7 + 6 * 50+50;
            y[0] = heightGame/7 + 6 * 50-50;
            y[1] = heightGame/7 + 6 * 50;
            y[2] = heightGame/7 + 6 * 50+50;
            y[3] = heightGame/7 + 6 * 50;

            fields[52].addPoint(x[0], y[0]);
            fields[52].addPoint(x[1], y[1]);
            fields[52].addPoint(x[2], y[2]);
            fields[52].addPoint(x[3], y[3]);

            //TOP RIGHT MIDDLE
            for(int i=53; i<58; i++){
                x[1] = x[0];
                x[2] = x[3];
                y[1] = y[0];
                y[2] = y[3];
                x[0] += 40;
                x[3] += 40;
                y[0] -= 40;
                y[3] -= 40;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[1] = x[0];
            x[2] = x[3];
            y[1] = y[0];
            y[2] = y[3];
            x[0] += 100;
            x[3] += 50;
            y[0] -= 50;
            y[3] -= 100;

            fields[58].addPoint(x[0], y[0]);
            fields[58].addPoint(x[1], y[1]);
            fields[58].addPoint(x[2], y[2]);
            fields[58].addPoint(x[3], y[3]);

            //BOTTOM RIGHT MIDDLE
            x[0] = heightGame/7 + 6 * 50;
            x[1] = heightGame/7 + 6 * 50-50;
            x[2] = heightGame/7 + 6 * 50;
            x[3] = heightGame/7 + 6 * 50+50;
            y[0] = heightGame/7 + 6 * 50-50;
            y[1] = heightGame/7 + 6 * 50;
            y[2] = heightGame/7 + 6 * 50+50;
            y[3] = heightGame/7 + 6 * 50;

            for(int i=59; i<64; i++){
                x[0] = x[3];
                x[1] = x[2];
                y[0] = y[3];
                y[1] = y[2];
                x[2] += 40;
                x[3] += 40;
                y[2] += 40;
                y[3] += 40;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[0] = x[3];
            x[1] = x[2];
            y[0] = y[3];
            y[1] = y[2];
            x[2] += 100;
            x[3] += 50;
            y[2] += 50;
            y[3] += 100;

            fields[64].addPoint(x[0], y[0]);
            fields[64].addPoint(x[1], y[1]);
            fields[64].addPoint(x[2], y[2]);
            fields[64].addPoint(x[3], y[3]);

            //BOTTOM LEFT MIDDLE
            x[0] = heightGame/7 + 6 * 50;
            x[1] = heightGame/7 + 6 * 50-50;
            x[2] = heightGame/7 + 6 * 50;
            x[3] = heightGame/7 + 6 * 50+50;
            y[0] = heightGame/7 + 6 * 50-50;
            y[1] = heightGame/7 + 6 * 50;
            y[2] = heightGame/7 + 6 * 50+50;
            y[3] = heightGame/7 + 6 * 50;

            for(int i=65; i<70; i++){
                x[0] = x[1];
                x[3] = x[2];
                y[0] = y[1];
                y[3] = y[2];
                x[1] -= 40;
                x[2] -= 40;
                y[1] += 40;
                y[2] += 40;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[0] = x[1];
            x[3] = x[2];
            y[0] = y[1];
            y[3] = y[2];
            x[2] -= 100;
            x[1] -= 50;
            y[2] += 50;
            y[1] += 100;

            fields[70].addPoint(x[0], y[0]);
            fields[70].addPoint(x[1], y[1]);
            fields[70].addPoint(x[2], y[2]);
            fields[70].addPoint(x[3], y[3]);

            //TOP LEFT MIDDLE
            x[0] = heightGame/7 + 6 * 50;
            x[1] = heightGame/7 + 6 * 50-50;
            x[2] = heightGame/7 + 6 * 50;
            x[3] = heightGame/7 + 6 * 50+50;
            y[0] = heightGame/7 + 6 * 50-50;
            y[1] = heightGame/7 + 6 * 50;
            y[2] = heightGame/7 + 6 * 50+50;
            y[3] = heightGame/7 + 6 * 50;

            for(int i=71; i<76; i++){
                x[3] = x[0];
                x[2] = x[1];
                y[3] = y[0];
                y[2] = y[1];
                x[0] -= 40;
                x[1] -= 40;
                y[0] -= 40;
                y[1] -= 40;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[3] = x[0];
            x[2] = x[1];
            y[3] = y[0];
            y[2] = y[1];
            x[0] -= 100;
            x[1] -= 50;
            y[0] -= 50;
            y[1] -= 100;

            fields[76].addPoint(x[0], y[0]);
            fields[76].addPoint(x[1], y[1]);
            fields[76].addPoint(x[2], y[2]);
            fields[76].addPoint(x[3], y[3]);

            //PLAYER FIGURE FIELDS
            x[0] = 900;
            x[1] = 900;
            x[2] = 1050;
            x[3] = 1050;
            y[0] = 50;
            y[1] = 200;
            y[2] = 200;
            y[3] = 50;

            fields[77].addPoint(x[0], y[0]);
            fields[77].addPoint(x[1], y[1]);
            fields[77].addPoint(x[2], y[2]);
            fields[77].addPoint(x[3], y[3]);

            x[0] = x[3] + 50;
            x[1] = x[2] + 50;
            x[2] += 200;
            x[3] += 200;
            y[0] = 50;
            y[1] = 200;
            y[2] = 200;
            y[3] = 50;

            fields[78].addPoint(x[0], y[0]);
            fields[78].addPoint(x[1], y[1]);
            fields[78].addPoint(x[2], y[2]);
            fields[78].addPoint(x[3], y[3]);

            y[0] = y[1] + 50;
            y[3] = y[2] + 50;
            y[1] += 200;
            y[2] += 200;

            fields[79].addPoint(x[0], y[0]);
            fields[79].addPoint(x[1], y[1]);
            fields[79].addPoint(x[2], y[2]);
            fields[79].addPoint(x[3], y[3]);

            x[2] = x[1] - 50;
            x[3] = x[0] - 50;
            x[0] -= 200;
            x[1] -= 200;

            fields[80].addPoint(x[0], y[0]);
            fields[80].addPoint(x[1], y[1]);
            fields[80].addPoint(x[2], y[2]);
            fields[80].addPoint(x[3], y[3]);

            System.out.println(fields[0].getBounds());

            addMouseListener(this);
            setPreferredSize(new Dimension(heightGame+325, heightGame-100));
        }

        /**
         * paintComponent IS DRAWING THE PLAY FIELD OBJECTS WITH THE VALUES FROM Gamefield
         *                THE START POSITION FROM THE HATS ARE MADE IN THIS METHOD
         *
         * g2d IS A Graphics2D CUSTOM VARIABLE TO DRAW OBJECTS
         * isColorField CHECKS IF A FIELD SHOULD BE COLORED IN A COLOR OR NOT
         */
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            boolean isColorField = false;

            for(int i = 0; i < fields.length; i++){
                if(i == 0 || i == 77){
                    g2d.setColor(Color.GREEN);
                    isColorField = true;
                }
                else if(i == 13 || i == 78){
                    g2d.setColor(Color.RED);
                    isColorField = true;
                }
                else if(i == 26 || i == 79){
                    g2d.setColor(Color.BLUE);
                    isColorField = true;
                }
                else if(i == 39 || i == 80){
                    g2d.setColor(Color.YELLOW);
                    isColorField = true;
                }
                else if(i == 3 || i == 10 || i == 16 || i == 23 || i == 29 || i == 36 || i == 42 || i == 49 || i == 56 || i == 62 || i == 68 || i == 74){
                    g2d.setColor(Color.LIGHT_GRAY);
                    isColorField = true;
                }
                else{
                    g2d.setColor(Color.BLACK);
                }

                g2d.draw(fields[i]);
                if(isColorField){
                    g2d.fillPolygon(fields[i]);
                    isColorField = false;
                }

            }
            for(int i = 0; i < fields.length; i++){
                g2d.setColor(Color.BLACK);
                g2d.draw(fields[i]);
            }
            //GREEN START FIELD POSITION
            g2d.drawOval(915,65,50,50);
            g2d.drawOval(985,65,50,50);
            g2d.drawOval(915,135,50,50);
            g2d.drawOval(985,135,50,50);

            //RED START FIELD POSITION
            g2d.drawOval(1115,65,50,50);
            g2d.drawOval(1185,65,50,50);
            g2d.drawOval(1115,135,50,50);
            g2d.drawOval(1185,135,50,50);

            //YELLOW START FIELD POSITION
            g2d.drawOval(915,265,50,50);
            g2d.drawOval(985,265,50,50);
            g2d.drawOval(915,335,50,50);
            g2d.drawOval(985,335,50,50);

            //BLUE START FIELD POSITION
            g2d.drawOval(1115,265,50,50);
            g2d.drawOval(1185,265,50,50);
            g2d.drawOval(1115,335,50,50);
            g2d.drawOval(1185,335,50,50);

            /*NOTE: MAKE START FIELD SEPERATE FIELDS?
                    MAKE "CAPTURE COUNTER" BENEATH EACH START FIELD?
                    ADD AREA FOR DICE THROW?
                    ADD AREA FOR POTENTIAL MULTIPLAYER CHAT?
                    ADD NAME TO APPLICATION WINDOW
                    CREATE A VERSION NUMBER
                    LOGGING
             */
        }

        /**
         * @param e
         * CHECKS IF A MOUSE BUTTON WAS PRESSED
         */
        public void mousePressed(MouseEvent e){}
        /**
         * @param e
         * CHECK IF A MOUSE BUTTON WAS RELEASED
         */
        public void mouseReleased(MouseEvent e){}
        /**
         * @param e
         * CHECKS IF MOUSE CURSOR ENTERED A SPECIFIC ZONE
         */
        public void mouseEntered(MouseEvent e){}
        /**
         * @param e
         * CHECKS IF A MOUSE CURSOR EXITED A SPECIFIC AREA
         */
        public void mouseExited(MouseEvent e){}
        /**
         * @param e
         * CHECKS IF THE MOUSE BUTTON WAS CLICKED
         * IF THE MOUSE BUTTON WAS CLICKED, A CHECK IS RUN TO SEE IF
         * THE MOUSE CURSOR WAS OVER AN OBJECT OF THE ARRAY fields WHILE BEEING CLICKED
         * WHEN THIS IS THE CASE, ANOTHER OPERATION CAN BE TRIGGERED, EX. A PLAYER
         * MOVES HIS OWN HAT TO ANOTHER FIELD
         */
        public void mouseClicked(MouseEvent e){
            Point p = e.getPoint();

            for(int i = 0; i < fields.length; i++){
                if(fields[i].contains(p)) System.out.println("Field number:"+ i +" contains point");
            }
        }
    }
}