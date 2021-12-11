package com.company.petovFlappy;

import javax.swing.JFrame;
public class Game extends JFrame
{
    public Game(){
        add(new Panel());
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args){
        Game game = new Game();
    }
}
