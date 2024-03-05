package models;

import utility.Validatable;

public class Coordinates implements Validatable {
    private int x; //Значение поля должно быть больше -14
    private double y;
    public Coordinates(int x, double y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(String s) {
        try { this.x = Integer.parseInt(s.split(":")[0]); } catch (NumberFormatException ignored) { }
        try { this.y = Double.parseDouble(s.split(":")[1]); } catch (NumberFormatException ignored) { }
    }

    public boolean validate() {
        return x > -14;
    }

    @Override
    public String toString() {
        return this.x + ":" + this.y;
    }
}
