package ru.itmolabs.lab5.collection;

public class Location {
    private Float x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private float z;
    private String name; //Строка не может быть пустой, Поле может быть null
    public Location(Float x, Double y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = null;
    }
    public Location(Float x, Double y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return "x: " + this.x + "\ny: " + this.y + "\nz: " + this.z + "\nname: " + this.name;
    }
}

