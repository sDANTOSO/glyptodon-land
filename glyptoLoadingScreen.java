
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import java.awt.geom.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Random;
/**
 * Create a loading screen for my game 
 *
 * @Santoso Winatan
 * @26/05/25
 */
public class glyptoLoadingScreen extends JFrame implements ActionListener{
    JButton myButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;

    void createDialog(String smd){
        JDialog box = new JDialog(this);
        box.setBounds(400,400,200,200);
        TextArea area=new TextArea("more "+ smd); // text in the box
        box.add(area); // box

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension (400,400));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        box.toFront(); // box
        box.setVisible(true);
        box.setTitle("hello");        
        area.setEditable(false);
    }

    /**
     * Constructor for objects of class glyptoLoadingScreen
     */
    public glyptoLoadingScreen()
    {
        setTitle(" Glyptodon Land ");    //gets name
        int numberx = 500 ;   //gets dimensions
        int numbery = 900 ;
        this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window

        myButton = new JButton();
        Color color = new Color (161,125,43);
        myButton.setFont(new Font("Arial",Font.BOLD,50));  //
        myButton.setForeground(color);  // set text colour
        myButton.setText("<html>GLYPTODON LAND!<br>Press aywhere to play <br> <br> wasd:Movement <br> q:Pickup <br> e:Feed <br> tab:Exit </html>");

        myButton.setBounds(500,500,200,50);
        myButton.setFocusable(false);
         
        color = new Color (30,54,28);
        myButton.setBackground(color);
        this.add(myButton);

        //stuff we need 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// makes sure it closes
        this.pack(); // makes windows the preffered size
        this.toFront();// brings window to the front
        this.setVisible(true);// makes sure you can see it
    }

    public void paint  (Graphics g){ 
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Color color = new Color (161,125,43);
        g2.setColor(color);
        g2.drawString("THE ULTIMATUM", 0045, 180);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==myButton){

        }
    }
}
