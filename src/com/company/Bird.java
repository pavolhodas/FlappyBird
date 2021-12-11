package com.company;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Bird {

    public Image myPicture;

    public Bird()  {

            myPicture = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("graphics/flappy.png"));
            myPicture = myPicture.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    }


    public Image getBirdImage(){

        return myPicture;
    }

}
