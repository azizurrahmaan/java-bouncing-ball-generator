
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class BallView extends JPanel {

    ArrayList<Ball> ballList;

    public BallView() {
        this.ballList = new ArrayList<>();
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : ballList) {
            g.setColor(ball.color);
            g.fillOval(ball.x, ball.y, 20, 20);
        }

    }

}
