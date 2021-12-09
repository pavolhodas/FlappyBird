package com.company;

import java.awt.*;

public class Bird extends Panel {


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        writeBird(g);
    }

    public void writeBird(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 25, 25);
    }

}
