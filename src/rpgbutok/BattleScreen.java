package rpgbutok;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

public class BattleScreen {

    private int type;
    private String text;

    public BattleScreen(int x, String quote) {
        text = quote;
        type = x;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, 800, 800);
        if (type == 0) {
            g2D.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND));

            for (int i = 0; i < 5; i++) {
                Path2D path = new Path2D.Double();
                path.moveTo(Math.random() * 800, Math.random() * 800);
                for (int j = 0; j < 3; j++) {
                    path.curveTo(Math.random() * 800, Math.random() * 800, Math.random() * 800, Math.random() * 800, Math.random() * 800, Math.random() * 800);
                }
                // path.closePath();
                g2D.setColor(new Color((int) (Math.random() * 0xFFFFFF)));
                g2D.draw(path);
            }
            g2D.setColor(Color.white);
            g2D.drawRect(200, 300, 200, 50);
            
            FontMetrics metrics = g2D.getFontMetrics();
            String[] temp = text.split("\n");
            int y = 325;
            for (String s : temp) {
                g2D.drawString(s, 300 - metrics.stringWidth(s) / 2, y);
                y += metrics.getHeight() + 5;
            }
            
            // g2D.drawString(text, 300 - width / 2, 325);
        }
    }
}
