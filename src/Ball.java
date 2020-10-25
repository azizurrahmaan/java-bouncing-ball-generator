
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class Ball {

    int x;
    int y;
    Color color;
    BallVelocity velocity;
    static int objectCount = 0;

    public Ball() {

    }

    public Ball(int x, int y, Color color, BallVelocity velocity) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.velocity = velocity;
        objectCount++;
        System.out.println(objectCount);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + " : " + this.y;
    }

}
