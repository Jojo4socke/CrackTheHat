package gameBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Arrays;

// TODO
// - transform cartesian coordinates to polar coordinates for angles of outer array/fields (should work but will be annoying)
// - somehow get the angle out of distance(will probably not work but seems easier)
// - just assume the angle is 90° between two arrays (ex. top and left) and get skew and general measurements based on this

public class BoardGUI extends JFrame
{
    /*
    private static final int squareDimension = 50;
    private static final int innerArrayLength = 6;
    private static final int centerX = 500;
    private static final int centerY = 400;
*/

    public static void main(String[] args) {
        new BoardGUI();
    }

    public BoardGUI()
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Frame Info");
        frame.setTitle("Fang Den Hut - Battle Royal");
        frame.setLayout(new BorderLayout());
        frame.add(new paintBoard(), BorderLayout.CENTER);
        frame.pack();
        frame.repaint();
        //800x480 | 1280x720 | 1920x1080
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class paintBoard extends JPanel implements MouseListener {
        private Polygon[] fields = new Polygon[82];
        public int clicked = 0;

        public paintBoard() {

        }

        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            boolean isColorField = false;
            Dimension wSize = getSize();
            int heightGame = wSize.height;
            int widthGame = wSize.width;
            int[] x = new int[4];
            int[] y = new int[4];

            x[0] = widthGame/100;
            x[1] = widthGame/100;
            x[2] = widthGame/100*7;
            x[3] = widthGame/100*7;

            y[0] = heightGame/100*2;
            y[1] = heightGame/100*7*2;
            y[2] = heightGame/100*7*2;
            y[3] = heightGame/100*2;

            int horizontalA = y[2];
            int verticalA = x[2];

            for(int i = 0; i < fields.length; i++){
                fields[i] = new Polygon();
            }

            //UPPER LEFT
            fields[0].addPoint(x[0], y[0]);
            fields[0].addPoint(x[1], y[1]);
            fields[0].addPoint(x[2], y[2]);
            fields[0].addPoint(x[3], y[3]);

            //UPPER SIDE
            for(int i=1; i<13; i++){
                x[0] = x[3];
                x[1] = x[2];
                x[2] += widthGame/100*7/2;
                x[3] += widthGame/100*7/2;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            //UPPER RIGHT
            x[0] = x[3];
            x[1] = x[2];
            x[2] += widthGame/100*6;
            x[3] += widthGame/100*6;

            fields[13].addPoint(x[0], y[0]);
            fields[13].addPoint(x[1], y[1]);
            fields[13].addPoint(x[2], y[2]);
            fields[13].addPoint(x[3], y[3]);

            int verticalB = x[1];

            //RIGHT SIDE
            for(int i=14; i<26; i++){
                y[0] = y[1];
                y[3] = y[2];
                y[1] += heightGame/100*7;
                y[2] += heightGame/100*7;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            //BOTTOM RIGHT
            y[0] = y[1];
            y[3] = y[2];
            y[1] += heightGame/100*6*2;
            y[2] += heightGame/100*6*2;

            fields[26].addPoint(x[0], y[0]);
            fields[26].addPoint(x[1], y[1]);
            fields[26].addPoint(x[2], y[2]);
            fields[26].addPoint(x[3], y[3]);

            //BOTTOM SIDE
            for(int i=27; i<39; i++){
                x[2] = x[1];
                x[3] = x[0];
                x[0] -= widthGame/100*7/2;
                x[1] -= widthGame/100*7/2;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            //BOTTOM LEFT
            x[2] = x[1];
            x[3] = x[0];
            x[0] -= widthGame/100*6;
            x[1] -= widthGame/100*6;
            int horizontalB = y[3];

            fields[39].addPoint(x[0], y[0]);
            fields[39].addPoint(x[1], y[1]);
            fields[39].addPoint(x[2], y[2]);
            fields[39].addPoint(x[3], y[3]);

            //LEFT SIDE
            for(int i=40; i<52; i++){
                y[1] = y[0];
                y[2] = y[3];
                y[0] -= heightGame/100*7;
                y[3] -= heightGame/100*7;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            //Middle Field
            x[0] = verticalB/2+verticalA/2;
            x[1] = verticalB/2+verticalA/2 - heightGame/100*7;
            x[2] = verticalB/2+verticalA/2;
            x[3] = verticalB/2+verticalA/2 + heightGame/100*7;
            y[0] = horizontalB/2+horizontalA/2 - heightGame/100*7;
            y[1] = horizontalB/2+horizontalA/2;
            y[2] = horizontalB/2+horizontalA/2 + heightGame/100*7;
            y[3] = horizontalB/2+horizontalA/2;

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
                x[0] += heightGame/20;
                x[3] += heightGame/20;
                y[0] -= heightGame/20;
                y[3] -= heightGame/20;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[1] = x[0];
            x[2] = x[3];
            y[1] = y[0];
            y[2] = y[3];
            x[0] += heightGame/17 + widthGame/100*7/2;
            x[3] += heightGame/17;
            y[0] -= heightGame/17;
            y[3] -= heightGame/17 + heightGame/100*7;

            fields[58].addPoint(x[0], y[0]);
            fields[58].addPoint(x[1], y[1]);
            fields[58].addPoint(x[2], y[2]);
            fields[58].addPoint(x[3], y[3]);

            //BOTTOM RIGHT MIDDLE
            x[0] = verticalB/2+verticalA/2;
            x[1] = verticalB/2+verticalA/2 - heightGame/100*7;
            x[2] = verticalB/2+verticalA/2;
            x[3] = verticalB/2+verticalA/2 + heightGame/100*7;
            y[0] = horizontalB/2+horizontalA/2 - heightGame/100*7;
            y[1] = horizontalB/2+horizontalA/2;
            y[2] = horizontalB/2+horizontalA/2 + heightGame/100*7;
            y[3] = horizontalB/2+horizontalA/2;

            for(int i=59; i<64; i++){
                x[0] = x[3];
                x[1] = x[2];
                y[0] = y[3];
                y[1] = y[2];
                x[2] += heightGame/20;
                x[3] += heightGame/20;
                y[2] += heightGame/20;
                y[3] += heightGame/20;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[0] = x[3];
            x[1] = x[2];
            y[0] = y[3];
            y[1] = y[2];
            x[2] += heightGame/17 + widthGame/100*7/2;
            x[3] += heightGame/17;
            y[2] += heightGame/17;
            y[3] += heightGame/17 + heightGame/100*7;

            fields[64].addPoint(x[0], y[0]);
            fields[64].addPoint(x[1], y[1]);
            fields[64].addPoint(x[2], y[2]);
            fields[64].addPoint(x[3], y[3]);

            //BOTTOM LEFT MIDDLE
            x[0] = verticalB/2+verticalA/2;
            x[1] = verticalB/2+verticalA/2 - heightGame/100*7;
            x[2] = verticalB/2+verticalA/2;
            x[3] = verticalB/2+verticalA/2 + heightGame/100*7;
            y[0] = horizontalB/2+horizontalA/2 - heightGame/100*7;
            y[1] = horizontalB/2+horizontalA/2;
            y[2] = horizontalB/2+horizontalA/2 + heightGame/100*7;
            y[3] = horizontalB/2+horizontalA/2;

            for(int i=65; i<70; i++){
                x[0] = x[1];
                x[3] = x[2];
                y[0] = y[1];
                y[3] = y[2];
                x[1] -= heightGame/20;
                x[2] -= heightGame/20;
                y[1] += heightGame/20;
                y[2] += heightGame/20;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[0] = x[1];
            x[3] = x[2];
            y[0] = y[1];
            y[3] = y[2];
            x[2] -= heightGame/17 + widthGame/100*7/2;
            x[1] -= heightGame/17;
            y[2] += heightGame/17;
            y[1] += heightGame/17 + widthGame/100*7/2;

            fields[70].addPoint(x[0], y[0]);
            fields[70].addPoint(x[1], y[1]);
            fields[70].addPoint(x[2], y[2]);
            fields[70].addPoint(x[3], y[3]);

            //TOP LEFT MIDDLE
            x[0] = verticalB/2+verticalA/2;
            x[1] = verticalB/2+verticalA/2 - heightGame/100*7;
            x[2] = verticalB/2+verticalA/2;
            x[3] = verticalB/2+verticalA/2 + heightGame/100*7;
            y[0] = horizontalB/2+horizontalA/2 - heightGame/100*7;
            y[1] = horizontalB/2+horizontalA/2;
            y[2] = horizontalB/2+horizontalA/2 + heightGame/100*7;
            y[3] = horizontalB/2+horizontalA/2;

            for(int i=71; i<76; i++){
                x[3] = x[0];
                x[2] = x[1];
                y[3] = y[0];
                y[2] = y[1];
                x[0] -= heightGame/20;
                x[1] -= heightGame/20;
                y[0] -= heightGame/20;
                y[1] -= heightGame/20;

                fields[i].addPoint(x[0], y[0]);
                fields[i].addPoint(x[1], y[1]);
                fields[i].addPoint(x[2], y[2]);
                fields[i].addPoint(x[3], y[3]);
            }

            x[3] = x[0];
            x[2] = x[1];
            y[3] = y[0];
            y[2] = y[1];
            x[0] -= heightGame/17 + widthGame/100*7/2;
            x[1] -= heightGame/17;
            y[0] -= heightGame/17;
            y[1] -= heightGame/17 + widthGame/100*7/2;

            fields[76].addPoint(x[0], y[0]);
            fields[76].addPoint(x[1], y[1]);
            fields[76].addPoint(x[2], y[2]);
            fields[76].addPoint(x[3], y[3]);

            //PLAYER FIGURE FIELDS
            x[0] = widthGame/2+widthGame/100*3;
            x[1] = widthGame/2+widthGame/100*3;
            x[2] = widthGame/2+widthGame/100+heightGame/100*7*4;
            x[3] = widthGame/2+widthGame/100+heightGame/100*7*4;
            y[0] = heightGame/100*2;
            y[1] = heightGame/100*2+heightGame/100*7*3;
            y[2] = heightGame/100*2+heightGame/100*7*3;
            y[3] = heightGame/100*2;

            fields[77].addPoint(x[0], y[0]);
            fields[77].addPoint(x[1], y[1]);
            fields[77].addPoint(x[2], y[2]);
            fields[77].addPoint(x[3], y[3]);

            x[0] = x[3]+widthGame/100;
            x[1] = x[2]+widthGame/100;
            x[2] += heightGame/100*7*4;
            x[3] += heightGame/100*7*4;

            fields[78].addPoint(x[0], y[0]);
            fields[78].addPoint(x[1], y[1]);
            fields[78].addPoint(x[2], y[2]);
            fields[78].addPoint(x[3], y[3]);

            y[0] = y[1]+heightGame/100*2;
            y[3] = y[2]+heightGame/100*2;
            y[1] += heightGame/100*2+heightGame/100*7*3;
            y[2] += heightGame/100*2+heightGame/100*7*3;

            fields[79].addPoint(x[0], y[0]);
            fields[79].addPoint(x[1], y[1]);
            fields[79].addPoint(x[2], y[2]);
            fields[79].addPoint(x[3], y[3]);

            x[3] = x[0]-widthGame/100;
            x[2] = x[1]-widthGame/100;
            x[0] -= heightGame/100*7*4-widthGame/100;
            x[1] -= heightGame/100*7*4-widthGame/100;

            fields[80].addPoint(x[0], y[0]);
            fields[80].addPoint(x[1], y[1]);
            fields[80].addPoint(x[2], y[2]);
            fields[80].addPoint(x[3], y[3]);

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

            addMouseListener(this);
        }

        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();

            for(int i = 0; i < fields.length; i++){
                if(fields[i].contains(p)){
                    System.out.println("Field number: "+ i +" contains point");
                    clicked += 1;
                    System.out.println("Field was clicked: "+ clicked);
                }
            }
        }
    }
}




/*
    // creates "center cross"
    private static ArrayList<ArrayList<Integer>> generateInnerArrays(){
        int currentX = centerX;
        int currentY = centerY;

        // x in positive direction aka right
        ArrayList<ArrayList<Integer>> arrayRightCoordinates = new ArrayList<>();
        for(int i = 0; i < innerArrayLength; i++){
            currentX += squareDimension;
            arrayRightCoordinates.add(new ArrayList<Integer>(Arrays.asList(currentX,currentY)));
       }

        // why are you resetting the values again instead of setting them more cleverly? Because fuck it, that's why.
        // same goes for the many for loops
        currentX = centerX;
        // array x in negative direction aka left
        ArrayList<ArrayList<Integer>> arrayLeftCoordinates = new ArrayList<>();
        for(int i = 0; i < innerArrayLength; i++){
            currentX -= squareDimension;
            arrayLeftCoordinates.add(new ArrayList<Integer>(Arrays.asList(currentX,currentY)));
        }
        //array y negative aka bottom
        currentX = centerX;
        ArrayList<ArrayList<Integer>> arrayBottomCoordinates = new ArrayList<>();
        for(int i = 0; i < innerArrayLength; i++){
            currentY += squareDimension;
            arrayBottomCoordinates.add(new ArrayList<Integer>(Arrays.asList(currentX,currentY)));
        }

        //array y positive aka top
        currentY = centerY;
        ArrayList<ArrayList<Integer>> arrayTopCoordinates = new ArrayList<>();
        for(int i = 0; i < innerArrayLength; i++){
            currentY -= squareDimension;
            arrayTopCoordinates.add(new ArrayList<Integer>(Arrays.asList(currentX,currentY)));

        }

        ArrayList<ArrayList<Integer>> coordinatesArray = new ArrayList<ArrayList<Integer>>(arrayRightCoordinates);
        coordinatesArray.addAll(arrayLeftCoordinates);
        coordinatesArray.addAll(arrayBottomCoordinates);
        coordinatesArray.addAll(arrayTopCoordinates);

        return coordinatesArray;
    }
*/
/*
    public void paint(Graphics g) {
        super.paint(g);
        initiate and draw center square
        g.drawRect(500,400, squareDimension, squareDimension);
        draw directional squares
        for(int i = 0; i < generateInnerArrays().size(); i++){
            g.drawRect(generateInnerArrays().get(i).get(0),generateInnerArrays().get(i).get(1), squareDimension, squareDimension);
        }
    }
*/