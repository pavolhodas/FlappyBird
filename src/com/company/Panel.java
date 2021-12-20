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

    private int birdHigh = 0, birdMoveY = 0, birdPossitionX = 100;
    Random ran = new Random();
    int height = 550;
    int width = 450;
    int[] wallArr = {width, width + width/2};
    int[] gap = {ran.nextInt(270) + 30, ran.nextInt(220) + 30};
    int score = 0;
    boolean gameOver = false;
    boolean stopTheGame = false;
    boolean printScore = false;

    Panel(){
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
        if(wallArr[1] == 70 || wallArr[0] == 70){
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
            if (wallArr[i] == 130 && birdMoveY > gap[i] + 75 || wallArr[i] == 130 && birdMoveY < gap[i] ||
                    wallArr[i] <= 130 && wallArr[i] >= 75 && gap[i] >= birdMoveY ||
                    wallArr[i] <= 130 && wallArr[i] >= 75 && gap[i] + 100 <= birdMoveY + 30 || birdMoveY >= 400 ) {

                gameOver = true;
            }
            if(wallArr[i] + 50 < 0) {
                wallArr[i] = width;
                gap[i] = ran.nextInt(270) + 30;
            }
        }
        if(stopTheGame) {
            printScore = false;
            wallArr[0] = width;
            wallArr[1] =  width + width/2;
            birdPossitionX = 100;
            birdHigh = 0;
            birdMoveY = 0;
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
            g.fillRect(wallArr[i], 0, 50, height);

            g.setColor(Color.CYAN);
            g.fillRect(wallArr[i], gap[i], 50, 100);
        }
    }

    private void paintBird(Graphics g){
        g.setColor(Color.RED);

        Image birdImage = bird.getBirdImage();
        g.drawImage(birdImage, birdPossitionX, birdMoveY, this);
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
            wallArr[0] -= 5;
            wallArr[1] -= 5;
            birdHigh += 1;
            birdMoveY += birdHigh;
            if(birdMoveY <= 0){
                birdHigh = 3;
            }
            repaint();
        } else if(birdMoveY < 400){

                if(birdHigh < 0) {
                    birdHigh = 0;
                }else{
                birdHigh += 1;
                birdMoveY += birdHigh;

                if(birdMoveY > 400){
                    birdMoveY = 400;
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
        }else if(e.getKeyChar() == KeyEvent.VK_SPACE && gameOver() && birdMoveY >= 400){
            stopTheGame = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
