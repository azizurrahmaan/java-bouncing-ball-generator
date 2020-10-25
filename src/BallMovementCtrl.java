
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class BallMovementCtrl implements Runnable {

    BallView ballView;

    int minX;
    int minY;
    int maxX;
    int maxY;
    Dimension screen;
    int screenWidth;
    int screenHeight;

    public BallMovementCtrl(BallView ball) {
        this.ballView = ball;
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screen.getWidth();
        screenHeight = (int) screen.getHeight();
        minY = 0;
        minX = 0;
        maxX = screenWidth - 20;
        maxY = screenHeight - 70;
    }

    @Override
    public void run() {
        while (true) {


            for (Ball ball : ballView.ballList) {
                moveBall(ball);
            }

            ballView.repaint();
            ballView.revalidate();

            try {
                Thread.sleep(1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void moveBall(Ball ballPos) {
        if (ballPos.velocity.isDown()) {
            if (ballPos.getY() >= maxY) {
                ballPos.velocity.setySpeed(ballPos.velocity.getySpeed() * -1);
                ballPos.velocity.setUp(true);
                ballPos.velocity.setDown(false);
            }
        }
        if (ballPos.velocity.isUp()) {
            if (ballPos.getY() <= minY) {
                ballPos.velocity.setySpeed(ballPos.velocity.getySpeed() * -1);
                ballPos.velocity.setUp(false);
                ballPos.velocity.setDown(true);
            }
        }
        if (ballPos.velocity.isRight()) {
            if (ballPos.getX() <= minX) {
                ballPos.velocity.setxSpeed(ballPos.velocity.getxSpeed() * -1);
                ballPos.velocity.setRight(false);
                ballPos.velocity.setLeft(true);
            }
        }
        if (ballPos.velocity.isLeft()) {
            if (ballPos.getX() >= maxX) {
                ballPos.velocity.setxSpeed(ballPos.velocity.getxSpeed() * -1);
                ballPos.velocity.setRight(true);
                ballPos.velocity.setLeft(false);
            }
        }

        maxX = ballView.getSize().width - 20;
        maxY = ballView.getSize().height - 20;

        ballPos.setX(ballPos.getX() + ballPos.velocity.getxSpeed());
        ballPos.setY(ballPos.getY() + ballPos.velocity.getySpeed());
    }
}
