package gameBoard;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

// TODO
// - transform cartesian coordinates to polar coordinates for angles of outer array/fields (should work but will be annoying)
// - somehow get the angle out of distance(will probably not work but seems easier)
// - just assume the angle is 90° between two arrays (ex. top and left) and get skew and general measurements based on this

public class BoardGUI extends JFrame
{
    private static final int squareDimension = 50;
    private static final int innerArrayLength = 6;
    private static final int centerX = 500;
    private static final int centerY = 400;

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

    public BoardGUI()
    {
        //to  Set JFrame title
        super("Draw A Rectangle In JFrame");

        //Set default close operation for JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set JFrame size
        setSize(1024,900);

        //Make JFrame visible
        setVisible(true);

    }

    public void paint(Graphics g)
    {
        super.paint(g);
        // initiate and draw center square
        g.drawRect(500,400, squareDimension, squareDimension);
        //draw directional squares
        for(int i = 0; i < generateInnerArrays().size(); i++){
            g.drawRect(generateInnerArrays().get(i).get(0),generateInnerArrays().get(i).get(1), squareDimension, squareDimension);
        }

    }


    public static void main(String[] args) {
        BoardGUI rect = new BoardGUI();
    }



}
