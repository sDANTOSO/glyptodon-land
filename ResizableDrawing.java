import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizableDrawing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resizable Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Custom JPanel for drawing
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Example drawing (adjusts to resizing)
                g2d.setColor(Color.BLUE);
                g2d.fillRect(50, 50, getWidth() / 2, getHeight() / 2);

                g2d.setColor(Color.RED);
                g2d.drawOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
            }
        };

        frame.add(drawingPanel);
        frame.setVisible(true);

        // Optional: Add a listener to handle resize events
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                drawingPanel.repaint(); // Ensure repaint on resize
            }
        });
    }
}
