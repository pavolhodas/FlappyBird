package com.company;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    Game(){
        add(new Panel());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
