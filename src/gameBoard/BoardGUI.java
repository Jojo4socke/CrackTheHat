package gameBoard;
// TEST NOT WORKING 
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class BoardGUI extends JFrame
{
    int innerArrayLength = 6;

    private static ArrayList<Integer> innerArrayGenerator(int length, int startingIndex){
        ArrayList<Integer>innerArrays = new ArrayList<>();
        int arrayEnd = length + startingIndex;
        for(int i = startingIndex; i < arrayEnd; i++){
            innerArrays.add(i);
        }
        return innerArrays;
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


        //draw rectangle outline
        g.drawRect(500,400,150,150);

        //set color to Green
        g.setColor(Color.GREEN);


        //fill rectangle with GREEN color
        //g.fillRect(50,50,300,100);

    }


    public static void main(String[] args) {
        for(int f: innerArrayGenerator(6,53)){
           System.out.println(f);
        }
        BoardGUI rect=new BoardGUI();
    }



}
