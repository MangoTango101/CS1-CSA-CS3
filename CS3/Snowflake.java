import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

class SnowFlakePanel extends JPanel {
    private static final int MIN_SIZE = 5;
    private final Random random = new Random();

    public SnowFlakePanel() {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height) / 3;
        drawSnowflake(g, width / 2, height / 2, size);
    }

    private void drawStar(Graphics g, int centerX, int centerY, int size) {
        if (size < MIN_SIZE) {
            return;
        }
        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        int xEnd, yEnd;
        double angle;
        for (int i = 0; i < 6; i++) {
            angle = Math.toRadians(60 * i);
            xEnd = (int) (centerX + size * Math.cos(angle));
            yEnd = (int) (centerY - size * Math.sin(angle));
            g.drawLine(centerX, centerY, xEnd, yEnd);
            drawSnowflake(g, xEnd, yEnd, size / 3);
        }
    }

    private void drawSnowflake(Graphics g, int centerX, int centerY, int size) {
        drawStar(g, centerX, centerY, size);
    }
}

public class Snowflake {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}
