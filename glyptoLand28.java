
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.awt.event.*;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
/**
 * create a glyptodon land game
 *This version combines version 8 with the code from earlier versions that will allow for a menu and grid
 *
 * @Santoso Winatan
 * @16/07/2025
 */
public class glyptoLand28 extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JButton button;
    JButton button2;
    public final DrawingPanel panel = new DrawingPanel();
    boolean buttonb = false;
    boolean button2b = false;
    String[][] currentgrid = new String[8][8];
    String[][] interactgrid = new String[8][8];
    int plx = 0;
    int ply = 0;
    int food = 0;

    public void actionPerformed(ActionEvent e ){
        String input=e.getActionCommand();
        final int squareS = 1;
        final int squareE = 7;
        switch (input) {
            case "Quit"  : System.exit(0);
                break;
            case "New Grid"  :currentgrid = Array(currentgrid);
                interactgrid= Array2(interactgrid);;
                revalidate(); // Revalidate the layout
                panel.repaint();  // this redraws the grid by creating a new set of random values
                break;

            case "Up"  : 
                if (ply>=squareS){
                    ply--; 
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to move up a square wthin the grid
                break;
            case "Left"  :
                if (plx>=squareS){
                    plx--; 
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to move left a square wthin the grid
                break;     

            case "Down"  : 
                if (ply<squareE){
                    ply++; 
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to move down a square wthin the grid
                break; 
            case "Right"  :     
                if (plx<squareE){
                    plx++; 
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to move right a square wthin the grid
                break;
            case "Pickup food"  : 
                if (interactgrid[plx][ply].equals("bush")){
                    food++;
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to pickup a piece of food from a bush
                break;
            case "Feed food"  : 
                if (interactgrid[plx][ply].equals("glyptodon") ||interactgrid[plx][ply].equals("dodo") ){
                    food--;
                    revalidate(); // Revalidate the layout
                    panel.repaint();
                }// this allows the user to feed a piece of food to a animal
                break;
        }
    }

    glyptoLand28(){
        Scanner keyboard = new Scanner (System.in);
        menuBar=new JMenuBar();

        panel.setDoubleBuffered(true);
        button = new JButton();
        Color textColor = new Color (161,125,43);
        button.setFont(new Font("Arial",Font.BOLD,50)); 
        button.setForeground(textColor);  // set text colour
        button.setText("<html>GLYPTODON LAND!<br>Press anywhere for the tutorial!</html>");

        button.setPreferredSize(new Dimension(530,582));
        button.setFocusable(false);

        Color color = new Color (30,54,28);
        button.setBackground(color);
        panel.add(button);

        button2 = new JButton();
        button2.setPreferredSize(new Dimension(360,60));
        button2.setFocusable(false);

        button2.setFont(new Font("Arial",Font.BOLD,32));  
        button2.setForeground(textColor);  // set text colour
        panel.setBackground(textColor);
        button2.setText("<html>Click me to play!</html>");
        button2.setBackground(color);

        button.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    buttonb=true;
                    panel.remove(button);
                    panel.add(button2);
                    revalidate();
                    panel.repaint();
                }
            });// checks if the first button is pressed then creates tutorial

        button2.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    panel.remove(button2);
                    currentgrid = Array(currentgrid);
                    interactgrid= Array2(interactgrid);// generates grid
                    revalidate();
                    panel.repaint();
                    buttonb=false;
                    button2b=true;
                }
            });// checks if the tutorial button has been pressed

        add(panel);
        this.setLayout(new BorderLayout());
        this.add(menuBar, BorderLayout.NORTH);
        menuBar=new JMenuBar();
        this.setJMenuBar (menuBar);
        menu= new JMenu("File");
        menuBar.add(menu);
        
        menuItem=new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        menu.add(menuItem);
        
        //my file menu

        menu= new JMenu("Functions");
        menuBar.add(menu);
        menuItem=new JMenuItem("New Grid");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('q'));
        menu.add(menuItem);

        menuItem=new JMenuItem("Pickup food");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('e'));
        menu.add(menuItem);

        menuItem=new JMenuItem("Feed food");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('f'));
        menu.add(menuItem);

        //my functions menu
        
        menu= new JMenu("Movement");
        menuBar.add(menu);
        menuItem=new JMenuItem("Up");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('w'));
        menu.add(menuItem);

        menuItem=new JMenuItem("Left");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('a'));
        menu.add(menuItem);

        menuItem=new JMenuItem("Down");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
        menu.add(menuItem);

        menuItem=new JMenuItem("Right");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke('d'));
        menu.add(menuItem);
        
        //my movement menu

        this.add(panel);
        this.setTitle("Glyptodon Land");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(528,626); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // this is all necesarry to create my window
    }
    public class DrawingPanel extends JPanel{
        public DrawingPanel(){}

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;    
            
            Color color = new Color (207,168,78);
            Color seablue = new Color (53,92,94);
            Color green = new Color (116,122,76);
            Color brown = new Color (140,110,28);
            Color dirt = new Color (168,144,76);
            Color character = new Color (145,106,43);
            Color characterface = new Color (245,214,127);
            Color darkgreen = new Color (64,69,37);
            Color skincolor = new Color (188,145,95);
            Color brownshell = new Color (179,102,16);
            Color feathercolor = new Color (182,169,194);
            Color beakcolor = new Color (218,228,245);
            Color beakendcolor = new Color (130,97,7); 
            Color tailcolor = new Color (206,209,252);
            // these are here so they can be accesed by all drawings
            if (buttonb==true){// this draws the tutorial
                //glyptodon
                g2.setColor(color);
                g2.fillRect(131,70+(64*1),64,64); //base square

                g2.setColor(brownshell);
                g2.fillRect(145,84+(64*1),34,34); // base of shell
                g2.fillRect(165,72+(64*1),6,15);// tail
                
                g2.setColor(skincolor);
                g2.fillRect(165,86+(64*1),4,8);// rbfoot
                g2.fillRect(165,106+(64*1),4,8);//rf foot
                g2.fillRect(127,86+(64*1),4,8);//lb foot
                g2.fillRect(127,106+(64*1),4,8);//rf foot
                g2.fillRect(141,118+(64*1),14,12);//base ofhead
                
                g2.setColor(brownshell);
                g2.fillRect(144,119+(64*1),8,8);// head shell
                g2.fillRect(146,127+(64*1),4,2);
                
                g2.setColor(Color.BLACK);
                g2.fillRect(143,127+(64*1),2,2);//l eye
                g2.fillRect(155,127+(64*1),2,2);// r eye);
                g2.setFont(new Font("Arial",Font.BOLD,14));
                g2.drawString("Glyptodon", 114, 215);
                
                //dodo
                g2.setColor(color);
                g2.fillRect(35 +(66*3),70+(64*1),64,64); //base square

                g2.setColor(feathercolor);
                g2.fillRect(58 +(66*3),90+(64*1),18,12);// bod1
                g2.fillRect(60 +(66*3),84+(64*1),14,6);// bod1
                g2.fillRect(60 +(66*3),102+(64*1),14,6);// body
                g2.fillRect(62 +(66*3),108+(64*1),10,2);// body
                g2.fillRect(64 +(66*3),110+(64*1),6,4);// body
                g2.fillRect(65 +(66*3),114+(64*1),4,2);// body
                
                g2.setColor(beakcolor);
                g2.fillRect(66 +(66*3),116+(64*1),2,3);// beak
                
                g2.setColor(beakendcolor);
                g2.fillRect(65 +(66*3),119+(64*1),4,4);//end of beak
                g2.fillRect(66 +(66*3),123+(64*1),2,1);
                g2.setColor(feathercolor);
                g2.fillRect(65 +(66*3),114+(64*1),4,2);// body

                g2.setColor(tailcolor);
                g2.fillRect(64 +(66*3),82+(64*1),6,4);//tail
                g2.fillRect(65 +(66*3),81+(64*1),4,6);//tail
                g2.setColor(Color.BLACK);

                g2.fillRect(64 +(66*3),112+(64*1),2,2);//l eye
                g2.fillRect(68 +(66*3),112+(64*1),2,2);// r e2e
                g2.drawString("Dodo", 246, 215);

                //bush
                g2.setColor(color);
                g2.fillRect(29 +(64*5),70+(64*1),64,64); 

                g2.setColor(darkgreen);
                g2.fillRect(38+(64*5),78+(64*1),48,48);//bush
                g2.fillRect(34+(64*5),82+(64*1),54,38);
                g2.setColor(character);
                g2.fillRect(40+(64*5),88+(64*1),2,13);//sticks
                g2.fillRect(40+(64*5),97+(64*1),21,2);
                g2.fillRect(76+(64*5),97+(64*1),9,4);
                g2.fillRect(66+(64*5),93+(64*1),3,6);
                g2.fillRect(51+(64*5),104+(64*1),21,2);
                g2.fillRect(66+(64*5),104+(64*1),2,12);
                g2.fillRect(56+(64*5),87+(64*1),2,23);
                g2.fillRect(74+(64*5),92+(64*1),2,16);
                g2.fillRect(64+(64*5),98+(64*1),2,8);
                g2.setColor(Color.BLACK);
                g2.drawString("Bush", 362, 215);

                g2.setFont(new Font("Arial",HEIGHT,14));
                g2.drawString("When your character", 355, 245);
                g2.drawString("is on this square", 355, 260);
                g2.drawString("you can press e to", 355, 275);
                g2.drawString("pickup food from the bush", 355, 290);

                g2.drawString("When your character", 195, 245);
                g2.drawString("is on this square", 195, 260);
                g2.drawString("you can press f to", 195, 275);
                g2.drawString("feed food to the Dodo!", 195, 290);

                g2.drawString("When your character", 35, 245);
                g2.drawString("is on this square", 35, 260);
                g2.drawString("you can press f to", 35, 275);
                g2.drawString("feed the Glyptodon!", 35, 290);

                g2.setFont(new Font("Arial",Font.BOLD,36));
                g2.drawString("wasd:Movement", 120, 390);
                g2.drawString("e:Pickup Food   f:Feed Food", 23, 450);
                g2.drawString("esc:Exit    q:Change Grid", 54, 510);
            }
            
            if (button2b==true){// this draws the grid
                for (int x=0;x<8; x++){ 
                    for (int y=0;y<8; y++){
                        if (currentgrid[x][y].equals("dirt") ){
                            g2.setColor(color);
                            g2.fillRect(0 +(64*x),50 + (64*y),64,64);
                        }else if (currentgrid[x][y].equals("dirtier")){
                            g2.setColor(color);
                            g2.fillRect(0+(64*x),50+(64*y),64,64);
                            g2.setColor(dirt);
                            g2.fillRect(5+(64*x),55+(64*y),50,40);
                            g2.fillRect(24+(64*x),84+(64*y),25,20);                        
                        }else if (currentgrid[x][y].equals("ocean")){
                            g2.setColor(color);
                            g2.fillRect(0 +(64*x),50 + (64*y),64,64);
                            g2.setColor(seablue);
                            g2.fillRect(6+(64*x),54+(64*y),48,48);
                            g2.fillRect(54+(64*x),54+(64*y),5,20);
                            g2.fillRect(14+(64*x),102+(64*y),36,5);
                        }else if (currentgrid[x][y].equals( "grass")){
                            g2.setColor(color);
                            g2.fillRect(0 +(64*x),50 + (64*y),64,64); 
                            g2.setColor(green);
                            g2.fillRect(7+(64*x),55+(64*y),48,48);
                        }else if (currentgrid[x][y].equals( "mud")){
                            g2.setColor(color);
                            g2.fillRect(0 +(64*x),50+ (64*y),64,64);
                            g2.setColor(brown);
                            g2.fillRect(8+(64*x),54+(64*y),48,48);
                            g2.fillRect(55+(64*x),54+(64*y),5,20);
                            g2.fillRect(16+(64*x),102+(64*y),36,5);
                        } 

                        if (interactgrid[x][y].equals("glyptodon")){// this draws the things the user can interact with
                            // glyptodon
                            
                            g2.setColor(brownshell);
                            g2.fillRect(20 +(64*x),64+(64*y),34,34); // base of shell
                            g2.fillRect(34 +(64*x),52+(64*y),6,15);// tail
                            g2.setColor(skincolor);
                            g2.fillRect(54 +(64*x),66+(64*y),4,8);// rbfoot
                            g2.fillRect(54 +(64*x),86+(64*y),4,8);//rf foot
                            g2.fillRect(16 +(64*x),66+(64*y),4,8);//lb foot
                            g2.fillRect(16 +(64*x),86+(64*y),4,8);//rf foot
                            g2.fillRect(30 +(64*x),98+(64*y),14,12);//base ofhead
                            g2.setColor(brownshell);
                            g2.fillRect(33 +(64*x),99+(64*y),8,8);// head shell
                            g2.fillRect(35 +(64*x),107+(64*y),4,2);
                            g2.setColor(Color.BLACK);
                            g2.fillRect(32 +(64*x),107+(64*y),2,2);//l eye
                            g2.fillRect(40 +(64*x),107+(64*y),2,2);// r eye);
                        }else if (interactgrid[x][y].equals("dodo")){
                            //dodo
                            g2.setColor(feathercolor);
                            g2.fillRect(25 +(64*x),70+(64*y),18,12);// body
                            g2.fillRect(27 +(64*x),64+(64*y),14,6);// body
                            g2.fillRect(27 +(64*x),82+(64*y),14,6);// body
                            g2.fillRect(29 +(64*x),88+(64*y),10,2);// body
                            g2.fillRect(31 +(64*x),90+(64*y),6,4);// body
                            g2.fillRect(32 +(64*x),94+(64*y),4,2);// body
                            g2.setColor(beakcolor);
                            g2.fillRect(33 +(64*x),96+(64*y),2,3);

                            g2.setColor(beakendcolor);
                            g2.fillRect(32 +(64*x),99+(64*y),4,4);
                            g2.fillRect(33 +(64*x),13+(64*y),2,1);
                            g2.setColor(feathercolor);
                            g2.fillRect(32 +(64*x),94+(64*y),4,2);// body

                            g2.setColor(tailcolor);
                            g2.fillRect(31 +(64*x),62+(64*y),6,4);//tail
                            g2.fillRect(32 +(64*x),61+(64*y),4,6);//tail
                            g2.setColor(Color.BLACK);

                            g2.fillRect(31 +(64*x),92+(64*y),2,2);//l eye
                            g2.fillRect(35 +(64*x),92+(64*y),2,2);// r eye
                        }else if (interactgrid[x][y].equals("bush")){
                            //bush
                            g2.setColor(color);
                            g2.fillRect(0 +(64*x),50+(64*y),64,64); 

                            g2.setColor(darkgreen);
                            g2.fillRect(8+(64*x),58+(64*y),48,48);
                            g2.fillRect(4+(64*x),62+(64*y),54,38);
                            g2.setColor(character);
                            g2.fillRect(10+(64*x),68+(64*y),2,13);
                            g2.fillRect(10+(64*x),77+(64*y),21,2);
                            g2.fillRect(36+(64*x),77+(64*y),9,4);
                            g2.fillRect(36+(64*x),73+(64*y),3,6);
                            g2.fillRect(21+(64*x),84+(64*y),21,2);
                            g2.fillRect(36+(64*x),84+(64*y),2,12);
                            g2.fillRect(26+(64*x),67+(64*y),2,23);
                            g2.fillRect(44+(64*x),72+(64*y),2,16);
                            g2.fillRect(34+(64*x),78+(64*y),2,8);
                        }

                        if (x==plx && y==ply){ // this draws the users character
                            // character
                            g2.setColor(character);
                            g2.fillRect(0 +(64*x),59+(64*y),22,6); // shoulders
                            g2.fillRect(2 +(64*x),66+(64*y),6,6); //footl
                            g2.fillRect(14 +(64*x),66+(64*y),6,6);//footr

                            g2.setColor(characterface);
                            g2.fillRect(3 +(64*x),52+(64*y),16,16);//head
                            g2.fillRect(2 +(64*x),54+(64*y),18,4);//ears

                            g2.setColor(character);
                            g2.fillRect(5 +(64*x),52+(64*y),12,11);//hat
                            g2.fillRect(7 +(64*x),63+(64*y),8,3);// hat

                            g2.setColor(Color.BLACK);
                            g2.fillRect(5 +(64*x),67+(64*y),4,2);// eyel
                            g2.fillRect(13 +(64*x),67+(64*y),4,2);//eyer
                            if(food >0){// this updates the food counter and adds some food to the characters hand
                                g2.setColor(darkgreen);
                                g2.fillRect(0 +(64*x),62+(64*y),3,10); // food 
                                g2.setColor(Color.BLACK);
                                g2.setFont(new Font("Arial",Font.BOLD,22));
                                g2.drawString("Food Counter: "+ food, 16, 30);
                            }                            
                        }
                    }
                }
            }
        }
    }   

    public static String[][] Array2(String[][] interactgrid) { // this creates the random ints that decides what squares the user will interact with will be drawn and where
        Random random = new Random();
        for (int x=0;x<8; x++){ 
            for (int y=0;y<8; y++){
                int interactint = random.nextInt(64);
                if(24>=interactint && interactint >=20){
                    // glyptodon
                    interactgrid[x][y]= ("glyptodon");
                }else if(36>=interactint && interactint >=25){
                    //bush
                    interactgrid[x][y]= ("bush");
                }else if(41>=interactint && interactint >=38){
                    //dodo
                    interactgrid[x][y]= ("dodo");
                }else{
                    interactgrid[x][y]= ("null");
                }
            }
        }        
        return (interactgrid);
    }

    public static String[][] Array(String[][] currentgrid) {// this draws the base grid
        Random random = new Random();
        for (int x=0;x<8; x++){ 
            for (int y=0;y<8; y++){
                int myint = random.nextInt(101);
                System.out.println(myint);
                if( 25 >=myint && myint >=0 ){
                    currentgrid[x][y]= ("dirt");
                }else if (35>=myint && myint >=26) {
                    //ocean
                    currentgrid[x][y]= ("ocean");
                }else if (45>=myint && myint >=36) {
                    //grass
                    currentgrid[x][y]= ("grass");
                }else if (55>=myint && myint >=46) {
                    //mud
                    currentgrid[x][y]= ("mud");
                }else if (65>=myint && myint >=56) {
                    //bush
                    currentgrid[x][y]= ("dirt");
                }else if (70>=myint && myint >=66){
                    //bush
                    currentgrid[x][y]= ("dirt");
                }else if (100>=myint && myint >=70){
                    //dirt
                    currentgrid[x][y]= ("dirtier");
                }
            }
        }
        return (currentgrid);
    }

    public static void main(String[] args){
        new glyptoLand28();
    }
}
