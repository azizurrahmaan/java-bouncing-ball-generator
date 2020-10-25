
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azizu
 */
public class GameArena {
    JFrame fr;
    BallView bv;
    BallMovementCtrl ballCtrl;
    KeyHandler hnd;
    
    public GameArena() {
        initGUI();
    }
    
    private void initGUI(){
        fr = new JFrame("Bouncing Ball");
        
        bv = new BallView();
        bv.setVisible(true);
        
        hnd = new KeyHandler(bv);
        
        
        fr.add(bv);
        fr.addKeyListener(hnd);
        
        fr.setSize(300,200);
        fr.setLocation(200,300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
        ballCtrl = new BallMovementCtrl(bv);
        Thread t1 = new Thread(ballCtrl);
        t1.start();
        
    }
    
}
