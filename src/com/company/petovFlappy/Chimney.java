package com.company.petovFlappy;

import java.util.Random;
import java.awt.Graphics;


public class Chimney
{
    Random rand = new Random();
    int randPoloha = rand.nextInt(450);
    int x = 535;
    public Chimney(Graphics g)
    {
        this.chimneyHore(g);
        this.chimneyDole(g);
    }

    public void chimneyHore(Graphics g){
        g.fillRect(x, 0, 50, randPoloha);
    }

    public void chimneyDole(Graphics g){
        g.fillRect(x, randPoloha + 80, 50, 550);
    }
}
