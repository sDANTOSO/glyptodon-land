
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BdayCard extends JFrame {

    JButton button1, button2;
    JPanel panel;
    boolean button = false;
    BdayCard()
    {
        panel = new JPanel();
        button1 = new JButton();

        button1.addActionListener( new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    button=true;
                    repaint();
                }
            });

        panel.add(button1);

        this.add(panel);
        this.setTitle("It's Your Birthday!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        Color color = new Color (207,168,78);
        g.setColor(color);
        if(button){g.fillRect(0, 0, 600, 450);
        }
    
    

}

public static void main(String[] args){
new BdayCard();
}
}
