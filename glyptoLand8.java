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
 *This version combines the squares and loading screen
 *
 * @Santoso Winatan
 * @16/07/2025
 */
public class glyptoLand8 extends JFrame {

    JButton button2;
    JPanel panel;
    boolean button = false;
    glyptoLand8()
    {
        panel = new JPanel();

        button2 = new JButton();
        Color color = new Color (161,125,43);
        button2.setFont(new Font("Arial",Font.BOLD,50));  //
        button2.setForeground(color);  // set text colour
        button2.setText("<html>GLYPTODON LAND!<br>Press aywhere to play <br> <br> wasd:Movement <br> q:Pickup <br> e:Feed <br> tab:Exit </html>");

        button2.setPreferredSize(new Dimension(513,513));
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


        this.add(panel);
        this.setTitle("Glyptodon Land");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(513,513 );
        //this.getContentPane().setPreferredSize(new Dimension(numberx,numbery));// the preffered size of the window    
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        if(button){       

            Color color = new Color (207,168,78);
            g2.setColor(color);
            g2.fillRect(10,70,64,64);

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
            g2.fillRect(370,127,2,2);// r eye);

        }
    }

    public static void main(String[] args){
        new glyptoLand8();
    }
}
