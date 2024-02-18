package ru.itmolabs.lab5.collection;

import java.time.ZonedDateTime;

public class Route {
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле не может быть null
    private double distance; //Значение поля должно быть больше 1
    public Route(String name, Coordinates coordinates, Location from, Location to, double distance) {
         this.id = generateID();
         this.name = name;
         this.coordinates = coordinates;
         this.creationDate = java.time.ZonedDateTime.now();
         this.from = from;
         this.to = to;
         this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private long generateID(){
        return 0;
    }
    @Override
    public String toString(){
        return "id: " + this.id + "\nname: " + this.name + "\ncoordinates: " +
                this.coordinates + "\ncreationDate: " + this.creationDate + "\nfrom: " + this.from +
                "\nto: " + this.to + "\ndistance: " + this.distance + "\n";
    }
}

