import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import java.awt.Dimension;
import java.util.Random;
/**
 * create a glyptodon land game 
 *
 * @Santoso Winatan
 * @26/05/2025
 */
public class glyptoLand6 extends JFrame implements ActionListener{
    Canvas myGraphic;
    JButton myButton;
    int clicks=0;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JPanel panel = new JPanel();

    public final gamepanel board = new gamepanel();
    
    void createDialog(String smd){
        JDialog box = new JDialog(this);
        box.setBounds(400,400,200,200);
        TextArea area=new TextArea("more "+ smd); // text in the box
        box.add(area); // box

        panel.setPreferredSize(new Dimension (400,400));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        box.toFront(); // box
        box.setVisible(true);
        box.setTitle("hello");        
        area.setEditable(false);
    }

    public static void main (String [] args){
        String[][] grid = new String[6][7];
        String[] differentsquares = {"bush","grass","grass2","grass3","dirt", "pond","glyptodon", "dodo"} ;
        int[][] squarechance = { {0,25},{26,35},{36,45},{46,55},{56,65},{66,75},{76,88}, {89,100}};
        Random random = new Random();
        int myInt = random.nextInt(101);
        for (int x=0;x<6; x++){ 
            for (int y=0;y<7; y++){
                grid[x][y] = ("[ ]");

            }

        }//this fills out the values for where to place the squares

        //how big will the squares be 
    }

    public glyptoLand6()
    {
        setTitle(" Glyptodon Land ");    //gets name
        int numberx = 500 ;   //gets dimensions
        int numbery = 900 ;
        this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window

        myButton = new JButton();
        Color color = new Color (161,125,43);
        myButton.setFont(new Font("Arial",Font.BOLD,50));  //
        myButton.setForeground(color);  // set text colour
        myButton.setText("<html>GLYPTODON LAND!<br>Press aywhere to play </br> <br> wasd:Movement </br> q:Pickup <br> e:Feed </br> tab:Exit </html>");

        //Rectangle bounds = panel.getBounds();
        //int width = bounds.width;
        //int height = bounds.height;
        // int x = bounds.x;
        //int y = bounds.y;

        //myButton.setBounds(width,height,x,y);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        color = new Color (30,54,28);
        myButton.setBackground(color);
        this.add(myButton);

        // this.getContentPane().setPreferredSize(new Dimension(500,500));
        //this.getContentPane().setLayout(null);

        Scanner keyboard = new Scanner (System.in);
        setTitle(" name ");    //gets name

        //file menu
        menuBar=new JMenuBar();// if you bind two to the same one goes with the first one since my first one quits it will enver get to the second one 
        this.setJMenuBar (menuBar);
        menu= new JMenu("File");
        menuBar.add(menu);
        menuItem=new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('O'));
        menu.add(menuItem);


        menuItem=new JMenuItem("Escape");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("DOWN"));
        menu.add(menuItem);

        menuItem=new JMenuItem("Up");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("w"));
        menu.add(menuItem);


        menuItem=new JMenuItem("Down");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("a"));
        menu.add(menuItem);

        //stuff we need 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// makes sure it closes
        this.pack(); // makes windows the preffered size
        this.toFront();// brings window to the front
        this.setVisible(true);// makes sure you can see it
    }

    public void actionPerformed(ActionEvent e)
    {
        boolean ready = false;
        if (e.getSource()==myButton){
            Container parent = myButton.getParent();
            parent.remove(myButton);
            parent.revalidate(); // Revalidate the layout
            parent.repaint(); // Repaint the panel
            panel.revalidate();
            panel.repaint();

        }

        String smd=e.getActionCommand();

        switch (smd) {// does different things depending on what they do
            case "Quit"  : System.exit(0);
                break;
            case "Escape"  : System.exit(0);
                break;

            case "w"  : System.out.println("fattie"); 
                createDialog(smd);
                break;
            case "a"  : System.out.println("less fattie");
                createDialog(smd);
                break;     

            case "s"  : System.out.println("169.99");
                break; 
            case "d"  : System.out.println("249.99");
                break;
            case "q"  : System.out.println("249.99");
                break;
            case "e"  : System.out.println("249.99");
                break;

            default:
                System.out.print(smd);
                break;  
        }
    }
    public class gamepanel extends JPanel{
        public gamepanel(){}
        
        
        public void paintComponent (Graphics g){ 
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            Color color = new Color (207,168,78);
            g2.setColor(color);
            //g2.setColor(Color.BLACK);
            g2.fillRect(10,70,64,64);
            //g2.setColor(Color.color);

            //ocean
            
            g2.fillRect(75,70,64,64);
            Color seablue = new Color (84,150,176);
            g2.setColor(seablue);
            g2.fillRect(80,74,48,48);
            g2.fillRect(128,74,5,20);
            g2.fillRect(88,122,36,5);
            
            //grass

            g2.setColor(color);

            g2.fillRect(140,70,64,64); 
            Color green = new Color (116,122,76);
            g2.setColor(green);
            g2.fillRect(145,75,48,48);
            g2.fillRect(257,74,5,20);

            //dirt

            g2.setColor(color);
            g2.fillRect(205,70,64,64);
            Color brown = new Color (111,78,65);
            g2.setColor(brown);
            g2.fillRect(210,74,48,48);
            g2.fillRect(257,74,5,20);
            g2.fillRect(218,122,36,5);     
            //for(int i=1; i ==4; i++){

            //bush

            g2.setColor(color);
            g2.fillRect(270,70,64,64); 
            Color darkgreen = new Color (64,69,37);
            g2.setColor(darkgreen);
            g2.fillRect(279,78,48,48);
            g2.fillRect(276,82,54,38);

            // glyptodon
            g2.setColor(color);
            g2.fillRect(335,70,64,64); // square
            Color skincolor = new Color (188,145,95);
            Color brownshell = new Color (179,102,16);
            g2.setColor(brownshell);
            g2.fillRect(350,84,34,34); // base of shell
            g2.fillRect(364,72,6,15);// tail
            g2.setColor(skincolor);
            g2.fillRect(384,86,4,8);// rbfoot
            g2.fillRect(384,106,4,8);//rf foot
            g2.fillRect(346,86,4,8);//lb foot
            g2.fillRect(346,106,4,8);//rf foot
            g2.fillRect(360,118,14,12);//base ofhead
            g2.setColor(brownshell);
            g2.fillRect(363,119,8,8);// head shell
            g2.fillRect(365,127,4,2);
            g2.setColor(Color.BLACK);
            g2.fillRect(362,127,2,2);//l eye
            g2.fillRect(370,127,2,2);// r eye

            
        }
    }
}
