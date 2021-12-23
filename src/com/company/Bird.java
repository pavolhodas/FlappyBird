package com.company;


import java.awt.*;


public class Bird {

    private BirdColor birdColorr;
    private Image myPicture;
    private Image newPicture;

    public BirdColor getBirdColorr() {
        return birdColorr;
    }

    public void setBirdColorr(BirdColor birdColorr) {
        this.birdColorr = birdColorr;
        changedBrid();
    }

    private void changedBrid(){
        newPicture = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(birdColorr.path));
        if(myPicture != newPicture){
            myPicture = newPicture;
        }
        myPicture = myPicture.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    }

    public Bird()  {
        if(birdColorr == null){
            birdColorr = BirdColor.BLUE;
        }

            myPicture = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(birdColorr.path));
            myPicture = myPicture.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    }

    public Image getBirdImage(){

        return myPicture;
    }

}
