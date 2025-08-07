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
 *This version is meant to improve comments and remove repeated code
 *
 * @Santoso Winatan
 * @7/08/2025
 */
public class glyptoLand30 extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JButton buttonS;
    JButton buttonT;
    public final DrawingPanel panel = new DrawingPanel();
    boolean buttonsp = false;
    boolean buttontp = false;
    String[][] currentgrid = new String[8][8];
    String[][] interactgrid = new String[8][8];
    String[] menuName ={ "File"};
    String[] menuButton ={ "Exit"};
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

    glyptoLand30(){
        Scanner keyboard = new Scanner (System.in);
        menuBar=new JMenuBar();
        panel.setDoubleBuffered(true);

        buttonS = new JButton();
        Color textColor = new Color (161,125,43);
        buttonS.setFont(new Font("Arial",Font.BOLD,50)); 
        buttonS.setForeground(textColor);  // set text colour
        buttonS.setText("<html>GLYPTODON LAND!<br>Press anywhere for the tutorial!</html>");
        buttonS.setPreferredSize(new Dimension(530,582));
        buttonS.setFocusable(false);
        Color color = new Color (30,54,28);
        buttonS.setBackground(color);
        panel.add(buttonS);

        buttonT = new JButton();

        buttonT.setFont(new Font("Arial",Font.BOLD,32));  
        buttonT.setForeground(textColor);  // set text colour
        panel.setBackground(textColor);
        buttonT.setText("<html>Click me to play!</html>");
        buttonT.setBackground(color);
        buttonT.setPreferredSize(new Dimension(360,60));
        buttonT.setFocusable(false);

        buttonS.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    buttonsp=true;
                    panel.remove(buttonS);
                    panel.add(buttonT);
                    revalidate();
                    panel.repaint();
                }
            });// checks if the first button is pressed then creates tutorial

        buttonT.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    panel.remove(buttonT);
                    currentgrid = Array(currentgrid);
                    interactgrid= Array2(interactgrid);// generates grid
                    revalidate();
                    panel.repaint();
                    buttonsp=false;
                    buttontp=true;
                }
            });// checks if the tutorial button has been pressed

        add(panel);
        this.setLayout(new BorderLayout());
        this.add(menuBar, BorderLayout.NORTH);
        menuBar=new JMenuBar();
        this.setJMenuBar (menuBar);
        menu= new JMenu("File");
        menuBar.add(menu);
        
        menuItem=new JMenuItem("Exit");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        menu.add(menuItem);

        
      
        //my file menu

        menu= new JMenu("Functions");
        menuBar.add(menu);
        menuItem=new JMenuItem("New Grid");//wowza
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
            // these are here so they can be accesed by all drawings

            int x=0;
            int y=0;
            int xAdd= 0;
            int yAdd= 0;

            if (buttonsp==true){// this draws the tutorial

                //paintGlyptodon(g, color, buttonsp,buttontp,x,y );

                //paintDodo(g, color, buttonsp,buttontp,x,y );
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

            if (buttontp==true ){// this draws the grid
                for (x=0;x<8; x++){ 
                    for (y=0;y<8; y++){
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

                        if (interactgrid[x][y].equals("bush")){
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

                        // how to call something to run without using a method
                    }
                }
            }

            for (x=0;x<8; x++){ 
                for (y=0;y<8; y++){
                    if (buttonsp==true){
                        xAdd= 111;
                        yAdd= 84;
                        g2.setColor(color);
                        g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                        g2.setColor(Color.BLACK);
                        g2.setFont(new Font("Arial",Font.BOLD,14));
                        g2.drawString("Glyptodon", 114, 215);}

                    else if (interactgrid[x][y].equals("glyptodon")){// this draws the things the user can interact with
                        // glyptodon
                        xAdd = 64*x;
                        yAdd = 64*y;

                    }
                    //glyptodon
                    Color skincolor = new Color (188,145,95);
                    Color brownshell = new Color (179,102,16);

                    g2.setColor(brownshell);
                    g2.fillRect(20 +(xAdd),64+(yAdd),34,34); // base of shell
                    g2.fillRect(34 +(xAdd),52+(yAdd),6,15);// tail
                    g2.setColor(skincolor);
                    g2.fillRect(54 +(xAdd),66+(yAdd),4,8);// rbfoot
                    g2.fillRect(54 +(xAdd),86+(yAdd),4,8);//rf foot
                    g2.fillRect(16 +(xAdd),66+(yAdd),4,8);//lb foot
                    g2.fillRect(16 +(xAdd),86+(yAdd),4,8);//rf foot
                    g2.fillRect(30 +(xAdd),98+(yAdd),14,12);//base ofhead
                    g2.setColor(brownshell);
                    g2.fillRect(33 +(xAdd),99+(yAdd),8,8);// head shell
                    g2.fillRect(35 +(xAdd),107+(yAdd),4,2);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(32 +(xAdd),107+(yAdd),2,2);//l eye
                    g2.fillRect(40 +(xAdd),107+(yAdd),2,2);// r eye);
                }
            }

            for (x=0;x<8; x++){ 
                for (y=0;y<8; y++){
                    if (buttonsp==true){
                        xAdd= 231;
                        yAdd= 84;
                        g2.setColor(color);
                        //g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                        g2.fillRect(35 +(66*3),70+(64*1),64,64); 
                        g2.setFont(new Font("Arial",Font.BOLD,14));

                        g2.setColor(Color.BLACK);
                        g2.drawString("Dodo", 246, 215);
                    }
                    else if (interactgrid[x][y].equals("dodo")){
                        xAdd = 64*x;
                        yAdd = 64*y;
                    }

                    //dodo

                    //256 114
                    Color feathercolor = new Color (182,169,194);
                    g2.setColor(feathercolor);
                    g2.fillRect(25 +(xAdd),70+(yAdd),18,12);// body
                    g2.fillRect(27 +(xAdd),64+(yAdd),14,6);// body
                    g2.fillRect(27 +(xAdd),82+(yAdd),14,6);// body
                    g2.fillRect(29 +(xAdd),88+(yAdd),10,2);// body
                    g2.fillRect(31 +(xAdd),90+(yAdd),6,4);// body
                    g2.fillRect(32 +(xAdd),94+(yAdd),4,2);// body
                    Color beakcolor = new Color (218,228,245);
                    g2.setColor(beakcolor);
                    g2.fillRect(33 +(xAdd),96+(yAdd),2,3);
                    Color beakendcolor = new Color (130,97,7);
                    g2.setColor(beakendcolor);
                    g2.fillRect(32 +(xAdd),99+(yAdd),4,4);
                    g2.fillRect(33 +(xAdd),13+(yAdd),2,1);
                    g2.setColor(feathercolor);
                    g2.fillRect(32 +(xAdd),94+(yAdd),4,2);// body

                    Color tailcolor = new Color (206,209,252);
                    g2.setColor(tailcolor);
                    g2.fillRect(31 +(xAdd),62+(yAdd),6,4);//tail
                    g2.fillRect(32 +(xAdd),61+(yAdd),4,6);//tail
                    g2.setColor(Color.BLACK);

                    g2.fillRect(31 +(xAdd),92+(yAdd),2,2);//l eye
                    g2.fillRect(35 +(xAdd),92+(yAdd),2,2);// r eye
                }

            }
            
            for (x=0;x<8; x++){ 
                for (y=0;y<8; y++){
                    if (buttonsp==true){
                        xAdd= 111;
                        yAdd= 84;
                        g2.setColor(color);
                        g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                        g2.setColor(Color.BLACK);
                        g2.setFont(new Font("Arial",Font.BOLD,14));
                        g2.drawString("Glyptodon", 114, 215);}

                    else if (interactgrid[x][y].equals("glyptodon")){// this draws the things the user can interact with
                        // glyptodon
                        xAdd = 64*x;
                        yAdd = 64*y;

                    }
                    //glyptodon
                    Color skincolor = new Color (188,145,95);
                    Color brownshell = new Color (179,102,16);

                    g2.setColor(brownshell);
                    g2.fillRect(20 +(xAdd),64+(yAdd),34,34); // base of shell
                    g2.fillRect(34 +(xAdd),52+(yAdd),6,15);// tail
                    g2.setColor(skincolor);
                    g2.fillRect(54 +(xAdd),66+(yAdd),4,8);// rbfoot
                    g2.fillRect(54 +(xAdd),86+(yAdd),4,8);//rf foot
                    g2.fillRect(16 +(xAdd),66+(yAdd),4,8);//lb foot
                    g2.fillRect(16 +(xAdd),86+(yAdd),4,8);//rf foot
                    g2.fillRect(30 +(xAdd),98+(yAdd),14,12);//base ofhead
                    g2.setColor(brownshell);
                    g2.fillRect(33 +(xAdd),99+(yAdd),8,8);// head shell
                    g2.fillRect(35 +(xAdd),107+(yAdd),4,2);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(32 +(xAdd),107+(yAdd),2,2);//l eye
                    g2.fillRect(40 +(xAdd),107+(yAdd),2,2);// r eye);
                }
            }
            for (x=0;x<8; x++){ 
                for (y=0;y<8; y++){
                    if (buttonsp==true){
                        xAdd= 111;
                        yAdd= 84;
                        g2.setColor(color);
                        g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                        g2.setColor(Color.BLACK);
                        g2.setFont(new Font("Arial",Font.BOLD,14));
                        g2.drawString("Glyptodon", 114, 215);}

                    else if (interactgrid[x][y].equals("glyptodon")){// this draws the things the user can interact with
                        
                        xAdd = 64*x;
                        yAdd = 64*y;

                    }
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
            }
           
        }

        public void paintGlyptodon(Graphics g,Color color, boolean buttonsp, boolean buttontp, int x, int y){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int xAdd= 0;
            int yAdd= 0;
            int counter =0;
            if (buttonsp==true && counter ==0){
                xAdd= 111;
                yAdd= 84;
                g2.setColor(color);
                g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Arial",Font.BOLD,14));
                g2.drawString("Glyptodon", 114, 215);
                counter ++;
            }else if (buttontp==true){
                xAdd = 64*x;
                yAdd = 64*y;
            }

            //glyptodon
            Color skincolor = new Color (188,145,95);
            Color brownshell = new Color (179,102,16);

            g2.setColor(brownshell);
            g2.fillRect(20 +(xAdd),64+(yAdd),34,34); // base of shell
            g2.fillRect(34 +(xAdd),52+(yAdd),6,15);// tail
            g2.setColor(skincolor);
            g2.fillRect(54 +(xAdd),66+(yAdd),4,8);// rbfoot
            g2.fillRect(54 +(xAdd),86+(yAdd),4,8);//rf foot
            g2.fillRect(16 +(xAdd),66+(yAdd),4,8);//lb foot
            g2.fillRect(16 +(xAdd),86+(yAdd),4,8);//rf foot
            g2.fillRect(30 +(xAdd),98+(yAdd),14,12);//base ofhead
            g2.setColor(brownshell);
            g2.fillRect(33 +(xAdd),99+(yAdd),8,8);// head shell
            g2.fillRect(35 +(xAdd),107+(yAdd),4,2);
            g2.setColor(Color.BLACK);
            g2.fillRect(32 +(xAdd),107+(yAdd),2,2);//l eye
            g2.fillRect(40 +(xAdd),107+(yAdd),2,2);// r eye);

            revalidate(); // Revalidate the layout
            panel.repaint();  // this redraws the grid by creating a new set of random values
        }

        public void paintDodo(Graphics g,Color color, boolean buttonsp, boolean buttontp, int x, int y){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int xAdd= 0;
            int yAdd = 0;
            if (buttonsp==true){
                xAdd= 50;
                yAdd = 8;
                g2.setColor(color);
                g2.fillRect(35 +(66*3),70+(64*1),64,64); 
                g2.setColor(Color.BLACK);
                g2.drawString("Dodo", 246, 215);

            }else if (buttonsp==true){
                xAdd = 64*y;
                yAdd = 64*x;
            }
            //dodo

            Color feathercolor = new Color (182,169,194);
            g2.setColor(feathercolor);
            g2.fillRect(256,154,18,12);// bod1
            g2.fillRect(258,148,14,6);// bod1
            g2.fillRect(258,166,14,6);// body
            g2.fillRect(260,172,10,2);// body
            g2.fillRect(262,174,6,4);// body
            g2.fillRect(65 +(66*3),178,4,2);// body
            Color beakcolor = new Color (218,228,245);
            g2.setColor(beakcolor);
            g2.fillRect(263,180,2,3);
            Color beakendcolor = new Color (130,97,7);
            g2.setColor(beakendcolor);
            g2.fillRect(263,183,4,4);
            g2.fillRect(264,187,2,1);
            g2.setColor(feathercolor);
            g2.fillRect(263,178,4,2);// body

            Color tailcolor = new Color (206,209,252);
            g2.setColor(tailcolor);
            g2.fillRect(262,146,6,4);//tail
            g2.fillRect(263,145,4,6);//tail
            g2.setColor(Color.BLACK);

            g2.fillRect(262,176,2,2);//l eye
            g2.fillRect(266,176,2,2);// r e2e

        }

        public void paintBush(Graphics g,Color color, boolean buttonsp, boolean buttontp, int x, int y){
            
            
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
        new glyptoLand30();
    }
}
