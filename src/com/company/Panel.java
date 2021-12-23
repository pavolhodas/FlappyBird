package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Panel extends JPanel implements ActionListener, KeyListener {

    private int birdHigh = 0, getY = 0, birdPossitionX = 100;
    Random ran = new Random();
    int height = 550;
    int width = 450;
    int[] getTopX = {width, width + width/2};
    int[] dieraVKomineY = {ran.nextInt(270) + 30, ran.nextInt(220) + 30};
    int score = 0;
    boolean gameOver = false;
    boolean stopTheGame = false;
    boolean printScore = false;
    int typeOfBirdColor = 1;

    Panel(){
        bird.setBirdColorr(BirdColor.BLUE);
        setSize(525, 550);
        setFocusable(true);
        setBackground(Color.CYAN);
        addKeyListener(this);
        new Timer(40, this).start();

    }

    Bird bird = new Bird();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 430, 550, 200);
            writeChimney(g);
            paintBird(g);
        writeScore(g);
        if(gameOver()){
            writeGameOver(g);
        }
    }
    public void setScore(){
        if(getTopX[1] == 70 || getTopX[0] == 70){
           score++;
        }
        if(gameOver() && !printScore){
            try {
                FileWriter scoreWriter = new FileWriter("scoreOfPlayer.txt", true);
                scoreWriter.write(String.valueOf(score));
                scoreWriter.write("\r\n");
                scoreWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(score);
            printScore = true;
        }
    }
    public boolean gameOver() {

        for (int i = 0; i < 2; i++){
            if (getTopX[i] == 130 && getY > dieraVKomineY[i] + 75 || getTopX[i] == 130 && getY < dieraVKomineY[i] ||
                    getTopX[i] <= 130 && getTopX[i] >= 75 && dieraVKomineY[i] >= getY ||
                    getTopX[i] <= 130 && getTopX[i] >= 75 && dieraVKomineY[i] + 100 <= getY + 30 || getY >= 400 ) {

                gameOver = true;
            }
            if(getTopX[i] + 50 < 0) {
                getTopX[i] = width;
                dieraVKomineY[i] = ran.nextInt(270) + 30;
            }
        }
        if(stopTheGame) {
            printScore = false;
            getTopX[0] = width;
            getTopX[1] =  width + width/2;
            birdPossitionX = 100;
            birdHigh = 0;
            getY = 0;
            gameOver = false;
            stopTheGame = false;
            score = 0;
            return false;
        }
            if(gameOver) {
            return true;
            }
        return false;
    }

    public void writeChimney(Graphics g){
        for(int i = 0; i < 2; i++) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(getTopX[i], 0, 50, height);

            g.setColor(Color.CYAN);
            g.fillRect(getTopX[i], dieraVKomineY[i], 50, 100);
        }
    }

    private void paintBird(Graphics g){
        g.setColor(Color.RED);

        Image birdImage = bird.getBirdImage();
        g.drawImage(birdImage, birdPossitionX, getY, this);
    }

    private void writeGameOver(Graphics g){
        Font font = new Font("Verdana", Font.BOLD, 20);
        if(gameOver()) {
            g.setFont(font);
            g.drawString("Game Over", 230, 200);
        }
    }

    private void writeScore(Graphics g){
        Font scoreFont = new Font("Veranda", Font.BOLD, 25);
        g.setFont(scoreFont);
        g.drawString(String.valueOf(score), 230, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setScore();


        if(!gameOver()) {
            getTopX[0] -= 5;
            getTopX[1] -= 5;
            birdHigh += 1;
            getY += birdHigh;
            if(getY <= 0){
                birdHigh = 3;
            }
            repaint();
        } else if(getY < 400){

                if(birdHigh < 0) {
                    birdHigh = 0;
                }else{
                birdHigh += 1;
                getY += birdHigh;

                if(getY > 400){
                    getY = 400;
                }
                repaint();
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_SPACE && !gameOver()){
            birdHigh = -10;
        }else if(e.getKeyChar() == KeyEvent.VK_SPACE && gameOver() && getY >= 400){
            stopTheGame = true;
        }

        if(gameOver() && e.getKeyChar() == KeyEvent.VK_1){
            setFlappyColor(1);
            System.out.println("111111");
        }else if(gameOver() && e.getKeyChar() == KeyEvent.VK_2){
            setFlappyColor(2);
            System.out.println("22222");
        }else if(gameOver() && e.getKeyChar() == KeyEvent.VK_3){
            setFlappyColor(3);
            System.out.println("3333");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setFlappyColor(int n){

        if(n == 1) {
            bird.setBirdColorr(BirdColor.RED);
            System.out.println(bird.getBirdColorr());
        }else if(n == 2) {
            bird.setBirdColorr(BirdColor.BLUE);
            System.out.println(bird.getBirdColorr());
        }else if(n == 3){
            bird.setBirdColorr(BirdColor.YELLOW);
            System.out.println(bird.getBirdColorr());
        }
    }

//    public int getFlappyColor(){
//        return typeOfBirdColor;
//    }
}
