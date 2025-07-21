
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.awt.event.*;
import java.util.Random;
/**
 *  create the squares for my game also make the menu 
 *
 * @Santoso Winatan
 * @26/05/25
 */

public class glyptoSquares extends JFrame implements ActionListener,MouseListener{
    private int x;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    final String fileName = "hotdog.jpg";
    ImageIcon image = new ImageIcon(fileName);
    Random random = new Random();
    int myInt = random.nextInt(8);
    int xx=100;
    int yy=200;
    int[][] rowHeights = {{5,5}, {5,5} ,{5,5}, {5,5} };

    //public void paint (Graphics g){

    //}

    public void mouseExited(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        int mousex=e.getX();
        int mousey=e.getY();

        System.out.println("click at"+mousex+","+mousey);
        if (mousex> xx && mousex<3100 & mousey> 200 &mousey < 1400){
            System.out.println("dont touch me there");
        }
    }

    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void actionPerformed(ActionEvent e){
        String smd=e.getActionCommand();

        switch (smd) {// does different things depending on what they do
            case "Quit"  : System.exit(0);
                break;
            case "Escape"  : System.exit(0);
                break;

            case "Truffle"  : System.out.println("fattie"); 
                createDialog(smd);
                break;
            case "Macron"  : System.out.println("less fattie");
                createDialog(smd);
                break;     

            case "Klombo"  : System.out.println("169.99");
                break; 
            case "Onyx Cinder"  : System.out.println("249.99");
                break;

            default:
                System.out.print(smd);
                break;  
        }
    }

    public void paint  (Graphics g){ 
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int xStart=0;
        int xEnd=400;
        int yStart=0;
        int yEnd=400;
        Line2D lin = new Line2D.Float(xStart,yStart,xEnd,yEnd);
        //g2.draw(lin);
        
        //plain block
        
        Color color = new Color (207,168,78);
        g2.setColor(color);
        //g2.setColor(Color.BLACK);
        g2.fillRect(10,70,64,64);
         Color dirt = new Color (168,144,76);
        g2.setColor(dirt);
        g2.fillRect(15,75,50,40);
        g2.fillRect(34,104,25,20);
        
        //g2.setColor(Color.color);
        
        //ocean
        
        g2.fillRect(74,70,64,64);
        Color seablue = new Color (84,150,176);
        g2.setColor(seablue);
        g2.fillRect(80,74,48,48);
        g2.fillRect(128,74,5,20);
        g2.fillRect(88,122,36,5);

        //grass
        
        g2.setColor(color);
        
        g2.fillRect(138,70,64,64); 
        Color green = new Color (116,122,76);
        g2.setColor(green);
        g2.fillRect(145,75,48,48);
        //g2.fillRect(257,74,5,20);
        
        //dirt
        
        g2.setColor(color);
        g2.fillRect(202,70,64,64);
        Color brown = new Color (111,78,65);
        g2.setColor(brown);
        g2.fillRect(210,74,48,48);
        g2.fillRect(257,74,5,20);
        g2.fillRect(218,122,36,5);     
        //for(int i=1; i ==4; i++){

        //bush
            
        g2.setColor(color);
        g2.fillRect(266,70,64,64); 
        Color darkgreen = new Color (64,69,37);
        g2.setColor(darkgreen);
        g2.fillRect(274,78,48,48);
        g2.fillRect(270,82,54,38);
        
        // glyptodon
        g2.setColor(color);
        g2.fillRect(330,70,64,64); // square
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
        
        // dodo
        
        g2.setColor(color);
        g2.fillRect(394,70,64,64); // square
        Color feathercolor = new Color (141,146,215);
        g2.setColor(feathercolor);
        g2.fillRect(418,90,25,15);// body
        g2.fillRect(421,82,20,16);// body
        g2.fillRect(422,100,18,12);// body
        g2.fillRect(426,112,10,6);// body
        g2.fillRect(427,118,8,3);// body
        Color tailcolor = new Color (206,209,252);
        g2.setColor(tailcolor);
        g2.fillRect(428,76,6,8);//tail
        
        g2.setColor(color);
        g2.fillRect(458,70,64,64); // squar
        
        g2.setColor(feathercolor);
        g2.fillRect(483,90,18,12);// body
        g2.fillRect(485,84,14,6);// body
        g2.fillRect(422,100,18,12);// body
        g2.fillRect(426,112,10,6);// body
        g2.fillRect(427,118,8,3);// body
        
        g2.setColor(tailcolor);
        g2.fillRect(489,80,6,6);//tail
        
        
        g2.setColor(color);
        g2.fillRect(10,134,64,64);
        
        g2.setColor(color);
        g2.fillRect(10,134+64,64,64);
        
        g2.setColor(color);
        g2.fillRect(10,134+64+64,64,64);
        
        g2.setColor(color);
        g2.fillRect(10,134+(64*3),64,64);
        
        g2.setColor(color);
        g2.fillRect(10,134,64,64);
        /*
        
        
        g2.fillOval(0010,070,150,100);

        g2.setColor(Color.RED);
        g2.fillOval(0010,070,20,75);
        g2.fillOval(140,070,20,75);

        g2.fillOval(075,80,50,20);

        g2.drawString("THE ULTIMATUM", 0045, 180);

        g2.setColor(Color.BLUE);
        g2.fillRect(200,070,150,100);

        g2.setColor(Color.WHITE);
        g2.fillOval(200,070,150,100);

        g2.setColor(Color.BLACK);
        g2.fillOval(200,070,20,75);
        g2.fillOval(330,070,20,75);

        g2.fillOval(250,80,50,20);

        g2.fillOval(240,115,30,20);
        g2.fillOval(280,115,30,20);

        g2.drawString("THE OMNIBOT", 235, 180);
        //image.paintIcon(this,g,xx,yy);
         */
    }

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

    public glyptoSquares()
    {

        Scanner keyboard = new Scanner (System.in);
        setTitle(" name ");    //gets name
        int numberx = 500 ;   //gets dimensions
        int numbery = 900 ;
        this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window
        addMouseListener(this);
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

        //stuff we need 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// makes sure it closes
        this.pack(); // makes windows the preffered size
        this.toFront();// brings window to the front
        this.setVisible(true);// makes sure you can see it
    }
}
