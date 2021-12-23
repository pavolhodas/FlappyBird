package com.company;

public enum BirdColor {
    YELLOW("graphics/flappy.png"), RED("graphics/img.png"), BLUE("graphics/img_1.png");

    String path;
    BirdColor(String path){
        this.path = path;
    }
}
