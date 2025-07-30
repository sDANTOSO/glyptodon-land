    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;

    public class CharacterMovement extends JFrame implements KeyListener {

        private int charX = 50;
        private int charY = 50;
        private final int MOVE_SPEED = 5;

        public CharacterMovement() {
            setTitle("Character Movement");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addKeyListener(this); // Add KeyListener to the frame
            setFocusable(true); // Ensure the frame can receive key events
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g); // Call superclass method to clear background
            g.setColor(Color.BLUE);
            g.fillRect(charX, charY, 20, 20); // Draw a simple rectangle as character
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                charX -= MOVE_SPEED;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                charX += MOVE_SPEED;
            } else if (keyCode == KeyEvent.VK_UP) {
                charY -= MOVE_SPEED;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                charY += MOVE_SPEED;
            }
            repaint(); // Request a repaint to show the updated position
        }

        @Override
        public void keyTyped(KeyEvent e) {} // Not used for movement
        @Override
        public void keyReleased(KeyEvent e) {} // Not used for continuous movement in this example

        public static void main(String[] args) {
            SwingUtilities.invokeLater(CharacterMovement::new);
        }
    }
