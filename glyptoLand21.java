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
public class glyptoLand21 extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JButton button;
    JButton button2;
    JPanel panel;
    boolean buttonb = false;
    boolean button2b = false;
    String[][] currentgrid = new String[8][8];
    String[][] interactgrid = new String[8][8];
    
    int pld = 0;
    int pls = 0;
    int food = 0;
    
    public void actionPerformed(ActionEvent e ){
        
        String smd=e.getActionCommand();
        final int squareS = 1;
        final int squareE = 7;
        switch (smd) {// does different things depending on what they do
            case "Quit"  : System.exit(0);
                break;
            case "New Grid"  :currentgrid = Array(currentgrid);
                interactgrid= Array2(interactgrid);;

                revalidate(); // Revalidate the layout
                repaint();  
                break;

            case "Up"  : ;
                if (pls>=squareS){
                    pls--; 
                    revalidate(); // Revalidate the layout
                    repaint();
                }
                break;
            case "Left"  : System.out.println("less fattie");
                if (pld>=squareS){
                    pld--; 
                    revalidate(); // Revalidate the layout
                    repaint();
                }
                break;     

            case "Down"  : 
                if (pls<squareE){
                    pls++; 
                    revalidate(); // Revalidate the layout
                    repaint();
                }
                break; 
            case "Right"  :     
                if (pld<squareE){
                    pld++; 
                    revalidate(); // Revalidate the layout
                    repaint();
                }
                break;
            case "Pickup food"  : 
                if (interactgrid[pld][pls].equals("bush")){
                    food++;
                    revalidate(); // Revalidate the layout
                    repaint();
                }System.out.println(food);
                break;
            case "Feed food"  : 
                if (interactgrid[pld][pls].equals("glyptodon") ||interactgrid[pld][pls].equals("dodo") ){
                    food--;
                    revalidate(); // Revalidate the layout
                    repaint();
                }System.out.println(food);
                break;
            
        }
    }

    glyptoLand21(){
        Scanner keyboard = new Scanner (System.in);

        panel = new JPanel();
        menuBar=new JMenuBar();
        panel.setDoubleBuffered(true);
        button = new JButton();
        Color textColor = new Color (161,125,43);
        button.setFont(new Font("Arial",Font.BOLD,50));  //
        button.setForeground(textColor);  // set text colour
        button.setText("<html>GLYPTODON LAND!<br>Press anywhere for the tutorial! <br> wasd:Movement <br> q:Change Grid <br> e:Pickup Food <br> f:Feed Food <br>esc:Exit </html>");

        button.setPreferredSize(new Dimension(530,582));
        button.setFocusable(false);

        Color color = new Color (30,54,28);
        button.setBackground(color);
        panel.add(button);
        
         button2 = new JButton();
        
        button2.setPreferredSize(new Dimension(360,60));
        button2.setFocusable(false);
        
        
        button2.setFont(new Font("Arial",Font.BOLD,32));  //
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
                    repaint();
                }
            });
            
             button2.addActionListener( new ActionListener() 
            {
            public void actionPerformed(ActionEvent e)
                {
                    panel.remove(button2);
                    revalidate();
                    repaint();
                    
                    button2b=true;
                }
            });
        this.setLayout(new BorderLayout());
        this.add(menuBar, BorderLayout.NORTH);
        menuBar=new JMenuBar();// if you bind two to the same one goes with the first one since my first one quits it will enver get to the second one 
        this.setJMenuBar (menuBar);
        menu= new JMenu("File");
        menuBar.add(menu);

        
        menuItem=new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        menu.add(menuItem);
        
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
        
        
        this.add(panel);
        this.setTitle("Glyptodon Land");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(532,593);
        //this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window    
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        currentgrid = Array(currentgrid);
        interactgrid= Array2(interactgrid);
        
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;    
        String[][] grid = new String[8][8];
        String[] differentsquares = {"bush","grass","water","bus","dirt", "pond","glyptodon", "dodo"} ;
        int[][] squarechance = { {0,25},{26,35},{36,45},{46,55},{56,65},{66,75},{76,88}, {89,100}};
         Color color = new Color (207,168,78);
                Color seablue = new Color (53,92,94);
                Color green = new Color (116,122,76);
                Color brown = new Color (140,110,28);
                Color dirt = new Color (168,144,76);
                Color character = new Color (145,106,43);
                Color characterface = new Color (245,214,127);
                Color darkgreen = new Color (64,69,37);
         if (buttonb==true){
                    //glyptodon
                    g2.setColor(color);
                    g2.fillRect(50 +(66*1),70+(64*1),64,64); 
                    
                    Color skincolor = new Color (188,145,95);
                    Color brownshell = new Color (179,102,16);
                    g2.setColor(brownshell);
                    g2.fillRect(65 +(66*1),84+(64*1),34,34); // base of shell
                    g2.fillRect(79 +(66*1),72+(64*1),6,15);// tail
                    g2.setColor(skincolor);
                    g2.fillRect(99 +(66*1),86+(64*1),4,8);// rbfoot
                    g2.fillRect(99 +(66*1),106+(64*1),4,8);//rf foot
                    g2.fillRect(61 +(66*1),86+(64*1),4,8);//lb foot
                    g2.fillRect(61 +(66*1),106+(64*1),4,8);//rf foot
                    g2.fillRect(75 +(66*1),118+(64*1),14,12);//base ofhead
                    g2.setColor(brownshell);
                    g2.fillRect(78 +(66*1),119+(64*1),8,8);// head shell
                    g2.fillRect(80 +(66*1),127+(64*1),4,2);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(77 +(66*1),127+(64*1),2,2);//l e0e
                    g2.fillRect(85 +(66*1),127+(64*1),2,2);// r eye);
                    g2.setFont(new Font("Arial",Font.BOLD,14));
                    g2.drawString("Glyptodon", 114, 215);
                    //dodo
                    g2.setColor(color);
                    g2.fillRect(35 +(66*3),70+(64*1),64,64); 
                    
                    Color feathercolor = new Color (182,169,194);
                    g2.setColor(feathercolor);
                    g2.fillRect(58 +(66*3),90+(64*1),18,12);// bod1
                    g2.fillRect(60 +(66*3),84+(64*1),14,6);// bod1
                    g2.fillRect(60 +(66*3),102+(64*1),14,6);// body
                    g2.fillRect(62 +(66*3),108+(64*1),10,2);// body
                    g2.fillRect(64 +(66*3),110+(64*1),6,4);// body
                    g2.fillRect(65 +(66*3),114+(64*1),4,2);// body
                    Color beakcolor = new Color (218,228,245);
                    g2.setColor(beakcolor);
                    g2.fillRect(66 +(66*3),116+(64*1),2,3);
                    Color beakendcolor = new Color (130,97,7);
                    g2.setColor(beakendcolor);
                    g2.fillRect(65 +(66*3),119+(64*1),4,4);
                    g2.fillRect(66 +(66*3),123+(64*1),2,1);
                    g2.setColor(feathercolor);
                    g2.fillRect(65 +(66*3),114+(64*1),4,2);// body

                    Color tailcolor = new Color (206,209,252);
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
                    g2.fillRect(38+(64*5),78+(64*1),48,48);
                    g2.fillRect(34+(64*5),82+(64*1),54,38);
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
            if (button2b==true){
            for (int x=0;x<8; x++){ 
                for (int y=0;y<8; y++){
               
                    if (currentgrid[x][y].equals("dirt") ){
                    g2.setColor(color);
                    g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                    }else if (currentgrid[x][y].equals("dirtier")){
                    g2.setColor(color);
                    g2.fillRect(10+(64*x),70+(64*y),64,64);
                    g2.setColor(dirt);
                    g2.fillRect(15+(64*x),75+(64*y),50,40);
                    g2.fillRect(34+(64*x),104+(64*y),25,20);                        
                    }else if (currentgrid[x][y].equals("ocean")){
                    g2.setColor(color);
                    g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                    g2.setColor(seablue);
                    g2.fillRect(16+(64*x),74+(64*y),48,48);
                    g2.fillRect(64+(64*x),74+(64*y),5,20);
                    g2.fillRect(24+(64*x),122+(64*y),36,5);
                    }else if (currentgrid[x][y].equals( "grass")){
                    g2.setColor(color);
                    g2.fillRect(10 +(64*x),70 + (64*y),64,64); 
                    g2.setColor(green);
                    g2.fillRect(17+(64*x),75+(64*y),48,48);
                    }else if (currentgrid[x][y].equals( "mud")){
                    g2.setColor(color);
                    g2.fillRect(10 +(64*x),70+ (64*y),64,64);
                    g2.setColor(brown);
                    g2.fillRect(18+(64*x),74+(64*y),48,48);
                    g2.fillRect(65+(64*x),74+(64*y),5,20);
                    g2.fillRect(26+(64*x),122+(64*y),36,5);
                    } 

                    if (interactgrid[x][y].equals("glyptodon")){
                    // glyptodon
                    Color skincolor = new Color (188,145,95);
                    Color brownshell = new Color (179,102,16);
                    g2.setColor(brownshell);
                    g2.fillRect(30 +(64*x),84+(64*y),34,34); // base of shell
                    g2.fillRect(44 +(64*x),72+(64*y),6,15);// tail
                    g2.setColor(skincolor);
                    g2.fillRect(64 +(64*x),86+(64*y),4,8);// rbfoot
                    g2.fillRect(64 +(64*x),106+(64*y),4,8);//rf foot
                    g2.fillRect(26 +(64*x),86+(64*y),4,8);//lb foot
                    g2.fillRect(26 +(64*x),106+(64*y),4,8);//rf foot
                    g2.fillRect(40 +(64*x),118+(64*y),14,12);//base ofhead
                    g2.setColor(brownshell);
                    g2.fillRect(43 +(64*x),119+(64*y),8,8);// head shell
                    g2.fillRect(45 +(64*x),127+(64*y),4,2);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(42 +(64*x),127+(64*y),2,2);//l eye
                    g2.fillRect(50 +(64*x),127+(64*y),2,2);// r eye);
                    }else if (interactgrid[x][y].equals("dodo")){
                    //dodo
                    Color feathercolor = new Color (182,169,194);
                    g2.setColor(feathercolor);
                    g2.fillRect(35 +(64*x),90+(64*y),18,12);// body
                    g2.fillRect(37 +(64*x),84+(64*y),14,6);// body
                    g2.fillRect(37 +(64*x),102+(64*y),14,6);// body
                    g2.fillRect(39 +(64*x),108+(64*y),10,2);// body
                    g2.fillRect(41 +(64*x),110+(64*y),6,4);// body
                    g2.fillRect(42 +(64*x),114+(64*y),4,2);// body
                    Color beakcolor = new Color (218,228,245);
                    g2.setColor(beakcolor);
                    g2.fillRect(43 +(64*x),116+(64*y),2,3);
                    Color beakendcolor = new Color (130,97,7);
                    g2.setColor(beakendcolor);
                    g2.fillRect(42 +(64*x),119+(64*y),4,4);
                    g2.fillRect(43 +(64*x),123+(64*y),2,1);
                    g2.setColor(feathercolor);
                    g2.fillRect(42 +(64*x),114+(64*y),4,2);// body

                    Color tailcolor = new Color (206,209,252);
                    g2.setColor(tailcolor);
                    g2.fillRect(41 +(64*x),82+(64*y),6,4);//tail
                    g2.fillRect(42 +(64*x),81+(64*y),4,6);//tail
                    g2.setColor(Color.BLACK);

                    g2.fillRect(41 +(64*x),112+(64*y),2,2);//l eye
                    g2.fillRect(45 +(64*x),112+(64*y),2,2);// r eye
                    }else if (interactgrid[x][y].equals("bush")){
                    //bush
                    g2.setColor(color);
                    g2.fillRect(10 +(64*x),70+(64*y),64,64); 
                    
                    g2.setColor(darkgreen);
                    g2.fillRect(18+(64*x),78+(64*y),48,48);
                    g2.fillRect(14+(64*x),82+(64*y),54,38);
                    }
                    System.out.println(currentgrid[x][y]);

                    if (x==pld && y==pls){
                   
                    g2.setColor(character);
                    g2.fillRect(10 +(64*x),79+(64*y),22,6); // shoulders
                    g2.fillRect(12 +(64*x),86+(64*y),6,6); //footl
                    g2.fillRect(24 +(64*x),86+(64*y),6,6);//footr
                    
                    g2.setColor(characterface);
                    g2.fillRect(13 +(64*x),72+(64*y),16,16);//head
                    g2.fillRect(12 +(64*x),74+(64*y),18,4);//ears
                    
                    g2.setColor(character);
                    g2.fillRect(15 +(64*x),72+(64*y),12,11);//hat
                    g2.fillRect(17 +(64*x),83+(64*y),8,3);// hat
                    
                        if(food >0){
                        g2.setColor(darkgreen);
                        g2.fillRect(10 +(64*x),82+(64*y),3,10); // food 
                        g2.setColor(Color.BLACK);
                        g2.setFont(new Font("Arial",Font.BOLD,13));
                        g2.drawString("Food counter: "+ food, 16, 68);
                        }
                    
                    g2.setColor(Color.BLACK);
                    g2.fillRect(15 +(64*x),87+(64*y),4,2);// eyel
                    g2.fillRect(23 +(64*x),87+(64*y),4,2);//eyer
                    
                        }
                
                
                }
            }
        }
    }
   
    
    public static String[][] Array2(String[][] interactgrid) {
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

    public static String[][] Array(String[][] currentgrid) {
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
        new glyptoLand21();
    }
}
