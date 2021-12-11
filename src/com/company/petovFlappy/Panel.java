package com.company.petovFlappy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Panel extends JPanel implements KeyListener
{
    int x = 535;
    int y = 100;
    int squareY = 8;
    int val1 = 1;
    int valX = 0;
    int movementOfChimney = 3;
    boolean klavesaStlacena = false;
    FlappyBird bird = new FlappyBird();
    //Komin komin = new Komin();
    public Panel()
    {
        setSize(525, 550);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.CYAN);

        //new Timer(4000, paintComponent).start();
    }

    public void nakresliKomin(){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bird.square(g);
        Chimney chimney = new Chimney(g);
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        //x -= movementOfChimney;
        squareY += val1;
        valX += squareY;
        repaint();
    }*/

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(klavesaStlacena == false){
            if(e.getKeyChar() == KeyEvent.VK_SPACE){
                klavesaStlacena = true;
                squareY = -11;
            }
        }
        System.out.println("Klaves");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        klavesaStlacena = false;
    }
}