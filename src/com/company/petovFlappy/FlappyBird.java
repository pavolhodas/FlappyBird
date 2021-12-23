package com.company.petovFlappy;

import com.company.BirdColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyBird extends JPanel implements ActionListener
{
    private int y = 100;
    private int valX = 0;
    private int squareY = 8;
    private int val1 = 1;

    public FlappyBird()
    {
        new Timer(40, this).start();
    }

    public void square(Graphics g){
        g.fillRect(100, y + valX, 25, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        squareY += val1;
        valX += squareY;
        repaint();
    }
}
