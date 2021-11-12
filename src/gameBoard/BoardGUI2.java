package gameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import gameBoard.field.Field;

// TODO
// - transform cartesian coordinates to polar coordinates for angles of outer array/fields (should work but will be annoying)
// - somehow get the angle out of distance(will probably not work but seems easier)
// - just assume the angle is 90° between two arrays (ex. top and left) and get skew and general measurements based on this

public class BoardGUI2 extends JFrame
{
    /*
    private static final int squareDimension = 50;
    private static final int innerArrayLength = 6;
    private static final int centerX = 500;
    private static final int centerY = 400;
*/

    public static void main(String[] args) {
        new BoardGUI2();
    }

    public BoardGUI2() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Frame Info");
        frame.setTitle("Fang Den Hut - Battle Royal");
        frame.setLayout(new BorderLayout());
        frame.add(new paintBoard(new Board()), BorderLayout.CENTER);
        frame.pack();
        frame.repaint();
        //800x480 | 1280x720 | 1920x1080
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class paintBoard extends JPanel implements MouseListener {
        private Dimension windowSize;
        private int heightGame;
        private int widthGame;
        private List<Field> fields;
        private final int points = 4;
        private int[] x = new int[points];
        private int[] y = new int[points];
        private int horizontalA;
        private int horizontalB;
        private int verticalA;
        private int verticalB;
        public int clicked = 0;

        public paintBoard(Board board) {
            this.windowSize = getSize();
            this.heightGame = windowSize.height;
            this.widthGame = windowSize.width;
            fields = board.getAllFields();
            setVisible(true);
        }

        public void paintComponent(Graphics g) {
            for(Field field : fields){
                // UPPER LEFT
                if(field.getFieldNumber() == 0) {
                    // Calculate the starting points
                    for(int pointNumber = 0; pointNumber < points; pointNumber++) {
                        x[pointNumber] = widthGame / 100;
                        y[pointNumber] = heightGame / 100 * 2;
                        if(pointNumber > 1) {
                            x[pointNumber] *= 7;
                            y[pointNumber] *= 7;
                        }
                    }
                    horizontalA = y[2];
                    verticalA = x[2];
                }
                // UPPER SIDE
                else if(field.getFieldNumber() >= 1 && field.getFieldNumber() <= 12) {
                    x[0] = x[3];
                    x[1] = x[2];
                    x[2] += widthGame / 100 * 7 / 2;
                    x[3] += widthGame / 100 * 7 / 2;
                }
                // UPPER RIGHT
                else if(field.getFieldNumber() == 13) {
                    x[0] = x[3];
                    x[1] = x[2];
                    x[2] += widthGame / 100 * 6;
                    x[3] += widthGame / 100 * 6;
                    verticalB = x[1];
                }
                // RIGHT SIDE
                else if(field.getFieldNumber() >= 14 && field.getFieldNumber() <= 25) {
                    y[0] = y[1];
                    y[3] = y[2];
                    y[1] += heightGame / 100 * 7;
                    y[2] += heightGame / 100 * 7;
                }
                // BOTTOM RIGHT
                else if(field.getFieldNumber() == 26) {
                    y[0] = y[1];
                    y[3] = y[2];
                    y[1] += heightGame / 100 * 6 * 2;
                    y[2] += heightGame / 100 * 6 * 2;
                }
                // BOTTOM SIDE
                else if(field.getFieldNumber() >= 27 && field.getFieldNumber() <= 38) {
                    x[2] = x[1];
                    x[3] = x[0];
                    x[0] -= widthGame / 100 * 7 / 2;
                    x[1] -= widthGame / 100 * 7 / 2;
                }
                // BOTTOM LEFT
                else if(field.getFieldNumber() == 39) {
                    x[2] = x[1];
                    x[3] = x[0];
                    x[0] -= widthGame / 100 * 6;
                    x[1] -= widthGame / 100 * 6;
                    horizontalB = y[3];
                }
                // LEFT SIDE
                else if(field.getFieldNumber() >= 40 && field.getFieldNumber() <= 51) {
                    y[1] = y[0];
                    y[2] = y[3];
                    y[0] -= heightGame / 100 * 7;
                    y[3] -= heightGame / 100 * 7;
                }
                // Middle Field
                if(field.getFieldNumber() == 52 || field.getFieldNumber() == 59
                        || field.getFieldNumber() == 65 || field.getFieldNumber() == 71) {
                    resetMiddlePoints();
                }
                // TOP RIGHT MIDDLE
                if(field.getFieldNumber() >= 53 && field.getFieldNumber() <= 57) {
                    x[1] = x[0];
                    x[2] = x[3];
                    y[1] = y[0];
                    y[2] = y[3];
                    x[0] += heightGame / 20;
                    x[3] += heightGame / 20;
                    y[0] -= heightGame / 20;
                    y[3] -= heightGame / 20;
                }
                else if(field.getFieldNumber() == 58) {
                    x[1] = x[0];
                    x[2] = x[3];
                    y[1] = y[0];
                    y[2] = y[3];
                    x[0] += heightGame / 17 + widthGame / 100 * 7 / 2;
                    x[3] += heightGame / 17;
                    y[0] -= heightGame / 17;
                    y[3] -= heightGame / 17 + heightGame / 100 * 7;
                }
                // BOTTOM RIGHT MIDDLE
                else if(field.getFieldNumber() >= 59 && field.getFieldNumber() <= 63) {
                    x[0] = x[3];
                    x[1] = x[2];
                    y[0] = y[3];
                    y[1] = y[2];
                    x[2] += heightGame / 20;
                    x[3] += heightGame / 20;
                    y[2] += heightGame / 20;
                    y[3] += heightGame / 20;
                }
                else if(field.getFieldNumber() == 64) {
                    x[0] = x[3];
                    x[1] = x[2];
                    y[0] = y[3];
                    y[1] = y[2];
                    x[2] += heightGame / 17 + widthGame / 100 * 7 / 2;
                    x[3] += heightGame / 17;
                    y[2] += heightGame / 17;
                    y[3] += heightGame / 17 + heightGame / 100 * 7;
                }
                // BOTTOM LEFT MIDDLE
                else if(field.getFieldNumber() >= 65 && field.getFieldNumber() <= 69) {
                    x[0] = x[1];
                    x[3] = x[2];
                    y[0] = y[1];
                    y[3] = y[2];
                    x[1] -= heightGame / 20;
                    x[2] -= heightGame / 20;
                    y[1] += heightGame / 20;
                    y[2] += heightGame / 20;
                }
                else if(field.getFieldNumber() == 70) {
                    x[0] = x[1];
                    x[3] = x[2];
                    y[0] = y[1];
                    y[3] = y[2];
                    x[2] -= heightGame / 17 + widthGame / 100 * 7 / 2;
                    x[1] -= heightGame / 17;
                    y[2] += heightGame / 17;
                    y[1] += heightGame / 17 + widthGame / 100 * 7 / 2;
                }
                // TOP LEFT MIDDLE
                else if(field.getFieldNumber() >= 71 && field.getFieldNumber() <= 75) {
                    x[3] = x[0];
                    x[2] = x[1];
                    y[3] = y[0];
                    y[2] = y[1];
                    x[0] -= heightGame / 20;
                    x[1] -= heightGame / 20;
                    y[0] -= heightGame / 20;
                    y[1] -= heightGame / 20;
                }
                else if(field.getFieldNumber() == 76) {
                    x[3] = x[0];
                    x[2] = x[1];
                    y[3] = y[0];
                    y[2] = y[1];
                    x[0] -= heightGame / 17 + widthGame / 100 * 7 / 2;
                    x[1] -= heightGame / 17;
                    y[0] -= heightGame / 17;
                    y[1] -= heightGame / 17 + widthGame / 100 * 7 / 2;
                }
                // PLAYER FIELDS
                else if(field.getFieldNumber() == 77) {
                    x[0] = widthGame / 2 + widthGame / 100 * 3;
                    x[1] = widthGame / 2 + widthGame / 100 * 3;
                    x[2] = widthGame / 2 + widthGame / 100 + heightGame / 100 * 7 * 4;
                    x[3] = widthGame / 2 + widthGame / 100 + heightGame / 100 * 7 * 4;
                    y[0] = heightGame / 100 * 2;
                    y[1] = heightGame / 100 * 2 + heightGame / 100 * 7 * 3;
                    y[2] = heightGame / 100 * 2 + heightGame / 100 * 7 * 3;
                    y[3] = heightGame / 100 * 2;
                }
                else if(field.getFieldNumber() == 78) {
                    x[0] = x[3] + widthGame / 100;
                    x[1] = x[2] + widthGame / 100;
                    x[2] += heightGame / 100 * 7 * 4;
                    x[3] += heightGame / 100 * 7 * 4;
                }
                else if(field.getFieldNumber() == 79) {
                    y[0] = y[1] + heightGame / 100 * 2;
                    y[3] = y[2] + heightGame / 100 * 2;
                    y[1] += heightGame / 100 * 2 + heightGame / 100 * 7 * 3;
                    y[2] += heightGame / 100 * 2 + heightGame / 100 * 7 * 3;
                }
                else if(field.getFieldNumber() == 80) {
                    x[3] = x[0] - widthGame / 100;
                    x[2] = x[1] - widthGame / 100;
                    x[0] -= heightGame / 100 * 7 * 4 - widthGame / 100;
                    x[1] -= heightGame / 100 * 7 * 4 - widthGame / 100;
                }
                field.setCoordinates(x, y);
                field.paint(g);
            }
            addMouseListener(this);
        }

        private void resetMiddlePoints() {
            x[0] = verticalB / 2 + verticalA / 2;
            x[1] = verticalB / 2 + verticalA / 2 - heightGame / 100 * 7;
            x[2] = verticalB / 2 + verticalA / 2;
            x[3] = verticalB / 2 + verticalA / 2 + heightGame / 100 * 7;
            y[0] = horizontalB / 2 + horizontalA / 2 - heightGame / 100 * 7;
            y[1] = horizontalB / 2 + horizontalA / 2;
            y[2] = horizontalB / 2 + horizontalA / 2 + heightGame / 100 * 7;
            y[3] = horizontalB / 2 + horizontalA / 2;
        }

        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();

            for(Field field : fields) {
                if(field.getCoordinates().contains(p)){
                    System.out.println("Field number: "+ field +" contains point");
                    clicked += 1;
                    System.out.println("Field was clicked: "+ clicked);
                    break;
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