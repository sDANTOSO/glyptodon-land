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
import java.util.Random;
/**
 * create a glyptodon land game
 *This version combines version 8 with the code from earlier versions that will allow for a menu and grid
 *
 * @Santoso Winatan
 * @16/07/2025
 */
public class glyptoLand10 extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JButton button2;
    JPanel panel;
    boolean button = false;

    glyptoLand10()
    {
        panel = new JPanel();
        menuBar=new JMenuBar();

        button2 = new JButton();
        Color color = new Color (161,125,43);
        button2.setFont(new Font("Arial",Font.BOLD,50));  //
        button2.setForeground(color);  // set text colour
        button2.setText("<html>GLYPTODON LAND!<br>Press aywhere to play <br> <br> wasd:Movement <br> q:Pickup <br> e:Feed <br> tab:Exit </html>");

        button2.setPreferredSize(new Dimension(530,582));
        button2.setFocusable(false);

        color = new Color (30,54,28);
        button2.setBackground(color);
        panel.add(button2);

        button2.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    button=true;

                    panel.remove(button2);
                    revalidate();
                    repaint();
                }
            });
        this.setLayout(new BorderLayout());
        this.add(menuBar, BorderLayout.NORTH);
        menuBar=new JMenuBar();// if you bind two to the same one goes with the first one since my first one quits it will enver get to the second one 
        this.setJMenuBar (menuBar);
        menu= new JMenu("File");
        menuBar.add(menu);

        this.add(panel);
        this.setTitle("Glyptodon Land");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(532,593);
        //this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window    
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if(button){       
            String[][] grid = new String[8][8];
            String[] differentsquares = {"bush","grass","water","bus","dirt", "pond","glyptodon", "dodo"} ;
            int[][] squarechance = { {0,25},{26,35},{36,45},{46,55},{56,65},{66,75},{76,88}, {89,100}};

            Random random = new Random();

            for (int x=0;x<8; x++){ 
                for (int y=0;y<8; y++){
                    Color color = new Color (207,168,78);
                    int myint = random.nextInt(101);
                    System.out.println(myint);
                    if( 25 >=myint && myint >=0 ){
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                    }else if (35>=myint && myint >=26) {
                        //ocean
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                        Color seablue = new Color (53,92,94);
                        g2.setColor(seablue);
                        g2.fillRect(16+(64*x),74+(64*y),48,48);
                        g2.fillRect(64+(64*x),74+(64*y),5,20);
                        g2.fillRect(24+(64*x),122+(64*y),36,5);
                    }else if (45>=myint && myint >=36) {
                        //grass
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70 + (64*y),64,64); 
                        Color green = new Color (116,122,76);
                        g2.setColor(green);
                        g2.fillRect(17+(64*x),75+(64*y),48,48);
                    }else if (55>=myint && myint >=46) {
                        //mud
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70+ (64*y),64,64);
                        Color brown = new Color (140,110,28);
                        g2.setColor(brown);
                        g2.fillRect(18+(64*x),74+(64*y),48,48);
                        g2.fillRect(65+(64*x),74+(64*y),5,20);
                        g2.fillRect(26+(64*x),122+(64*y),36,5);
                    }else if (65>=myint && myint >=56) {
                        //bush
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                    }else if (70>=myint && myint >=66){
                        //bush
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70 + (64*y),64,64);
                    }else if (100>=myint && myint >=70){
                        //dirt
                        g2.setColor(color);
                        g2.fillRect(10+(64*x),70+(64*y),64,64);
                        Color dirt = new Color (168,144,76);
                        g2.setColor(dirt);
                        g2.fillRect(15+(64*x),75+(64*y),50,40);
                        g2.fillRect(34+(64*x),104+(64*y),25,20);
                    }
                    int interactint = random.nextInt(64);
                    if(24>=interactint && interactint >=23){
                        // glyptodon
                        //g2.setColor(color);
                        // g2.fillRect(10 +(64*x),70+(64*y),64,64); // square
                        Color skincolor = new Color (188,145,95);
                        Color brownshell = new Color (179,102,16);
                        g2.setColor(brownshell);
                        g2.fillRect(31 +(64*x),84+(64*y),32,34); // base of shell
                        g2.fillRect(30 +(64*x),85+(64*y),34,32); // base of shell
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
                        grid [x][y]="glyptodon";
                    }else if(36>=interactint && interactint >=25){
                        //bush
                        g2.setColor(color);
                        g2.fillRect(10 +(64*x),70+(64*y),64,64); 
                        Color darkgreen = new Color (64,69,37);
                        g2.setColor(darkgreen);
                        g2.fillRect(18+(64*x),78+(64*y),48,48);
                        g2.fillRect(14+(64*x),82+(64*y),54,38);
                    }else if(41>=interactint && interactint >=37){
                        //dodo
                        Color feathercolor = new Color (182,169,194);
                        g2.setColor(feathercolor);
                        g2.fillRect(35 +(64*x),90+(64*y),18,12);// body
                        g2.fillRect(37 +(64*x),84+(64*y),14,6);// body
                        //g2.fillRect(3,100,18,12);// body
                        g2.fillRect(37 +(64*x),102+(64*y),14,6);// body
                        g2.fillRect(39 +(64*x),108+(64*y),10,2);// body
                        g2.fillRect(41 +(64*x),110+(64*y),6,4);// body
                        g2.fillRect(42 +(64*x),114+(64*y),4,2);// body
                        //g2.fillRect(44,116,8,3);// body
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
                    }
                }
            }

            // create this but fpr g;y[tpdpn
        }
    }

    public static void main(String[] args){
        new glyptoLand10();
    }
}
