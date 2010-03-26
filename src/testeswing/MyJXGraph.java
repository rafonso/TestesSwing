/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeswing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jdesktop.swingx.JXGraph;

/**
 *
 * @author rafael
 */
public class MyJXGraph extends JXGraph {

    private List<Double> valores = new ArrayList<Double>();

    private void drawLine(Graphics2D g2, Point2D.Double p1, Point2D.Double p2) {
        System.out.println(p1 + ", " + p2);
        g2.drawLine((int) super.xPositionToPixel(p1.getX()), (int) super.yPositionToPixel(p1.getY()), (int) super.xPositionToPixel(p2.getX()), (int) super.yPositionToPixel(p2.getY()));
    }

    @Override
    protected void paintExtra(Graphics2D g2) {
        super.paintExtra(g2);

        g2.setColor(Color.RED);
        if (this.valores.size() >= 2) {
            Iterator<Double> itValores = this.valores.iterator();
            Point2D.Double p1 = new Point2D.Double(itValores.next(), 0.0);
            Point2D.Double p2 = new Point2D.Double(p1.getX(), itValores.next());
            this.drawLine(g2, p1, p2);
            boolean horizontal = true;
            while (itValores.hasNext()) {
                p1 = p2;
                p2 = horizontal? new Point2D.Double(itValores.next(), p1.getY()): new Point2D.Double(p1.getX(), itValores.next());
                this.drawLine(g2, p1, p2);
                horizontal = !horizontal;
            }
        }
        System.out.println("===================================");
    }

    public void addPontos(double... pontos) {
        for (double d : pontos) {
            this.valores.add(d);
        }

    }
}
