package ru.itmolabs.lab5.collection;

public class Coordinates {
    private int x; //Значение поля должно быть больше -14
    private double y;
    public Coordinates(int x, double y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "(" + this.x + "; " + this.y + ")";
    }
}
