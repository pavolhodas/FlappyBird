package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements ActionListener, KeyListener {

    private int birdHigh = 0, birdMoveY = 0, birdPossitionX = 100;
    Random ran = new Random();

    int height = 550;
    int width = 450;
    int[] vallArr = {width, width + width/2};
    int gap = ran.nextInt(270) +30;
    boolean gameOver = false;

    Panel(){
        setSize(525, 550);
        setFocusable(true);
        setBackground(Color.CYAN);
        addKeyListener(this);
        new Timer(40, this).start();
    }

    Bird bird = new Bird();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!gameOver()) {
            writeChimney(g);
            paintBird(g);
        }else{
        }
    }

    public boolean gameOver(){

        if( width == 125 && birdMoveY > gap + 75 ||  width == 125 && birdMoveY < gap ||
                width <= 125 && width >= 75 && gap >= birdMoveY || width <= 125 && width >= 75 && gap + 100 <= birdMoveY + 30  ){

            gameOver = true;
        }
        if(gameOver) {
            return true;
        }
        return false;
    }

    public void writeChimney(Graphics g){
        g.fillRect(width, 0, 50, height);

        g.setColor(Color.CYAN);
        g.fillRect(width, gap, 50, 100);
    }

    private void paintBird(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(100, gap, 500, 1);
        g.fillRect(125, gap, 1, 500);
        g.fillRect(75, gap, 1, 500);

        Image birdImage = bird.getBirdImage();
        g.drawImage(birdImage, birdPossitionX, birdMoveY, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        width -= 5;
        birdHigh += 1;
        birdMoveY += birdHigh;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_SPACE){
            birdHigh = -11;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//
//        Bird bird;
//        Chimney chimney;
//        birdImage = bird.getBirdImage();
//        g.drawImage(birdImage, 100, 25, this);
//
//        chimney.writeChimney(g);
//    }
}
