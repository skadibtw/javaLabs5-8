package models;

import utility.Validatable;

public class Location implements Validatable {
    private Float x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private float z;
    private final String name; //Строка не может быть пустой, Поле может быть null

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

    public Location(String s) {
        try {
            this.x = Float.parseFloat(s.split(":")[0]);
        } catch (NumberFormatException e) {}
        try {
            this.y = Double.parseDouble(s.split(":")[1]);
        } catch (NumberFormatException e) {}
        try {
            this.z = Float.parseFloat(s.split(":")[2].split(" ")[0]);
        } catch (NumberFormatException e) {}
        this.name = s.split("name: ")[1];
    }

    public boolean validate() {
        if (x == null) return false;
        if (y == null) return false;
        return !name.isEmpty();
    }

    @Override
    public String toString(){
        return + x + ":" + y + ":" + z  + " name: " + this.name;
    }
}

