package com.company;

import java.awt.*;

public class Chimney extends Panel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        chimney(g);
    }

    private void chimney(Graphics g){
        g.fillRect(400, 0, 50, 550);
    }
}
