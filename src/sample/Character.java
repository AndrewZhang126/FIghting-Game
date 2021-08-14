package sample;

import java.awt.*;
import javafx.scene.image.Image;

public class Character {
    int h;
    int st;
    int sp;
    String n;
    int w;
    Image i;
    //precondition: user enters the stats for their custom character (they choose health, strength, speed)
    //postcondition: creates character based on the stats
    public Character(String name, int health, int strength, int speed, int win, Image image) {
        n = name;
        h = health;
        st = strength;
        sp = speed;
        w = win;
        i = image;
    }
    public String getName() {
        return n;
    }
    public int getHealth() {
        return h;
    }
    public int getStrength() {
        return st;
    }
    public int getSpeed() {
        return sp;
    }
    public int getWin() {
        return w;
    }
    public void setWin(int winCount) {
        w = winCount;
    }
    public Image getImage() {
        return i;
    }
}
