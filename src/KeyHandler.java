
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class KeyHandler implements KeyListener {

    BallView bv;

    public KeyHandler(BallView bv) {
        this.bv = bv;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32: {

                int maxX = bv.getSize().width - 20;
                int maxY = bv.getSize().height - 20;
                if (Ball.objectCount < 58) {
                    bv.ballList.add(new Ball((int) (Math.random() * maxX + 0), (int) (Math.random() * maxY + 0), getRandomColor(), new BallVelocity((int) (Math.random() * 10 + -5), (int) (Math.random() * 10 + -5))));
                }
                break;
            }
            case 27: {
                System.exit(0);
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    Color getRandomColor() {
        return new Color((int) (Math.random() * 255 + 0), (int) (Math.random() * 255 + 0), (int) (Math.random() * 255 + 0));
    }
}
