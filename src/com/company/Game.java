package com.company;

import javax.swing.*;

public class Game extends JFrame{

    Game(){

        add(new Chimney());
        //add(new Bird());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
