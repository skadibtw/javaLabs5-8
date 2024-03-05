package models;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import utility.Validatable;

public class Route implements Comparable<Route>, Validatable {

    private final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Location from; //Поле не может быть null
    private final Location to; //Поле не может быть null
    private final double distance; //Значение поля должно быть больше 1
    public Route(Long id, String name, Coordinates coordinates, Location from, Location to, double distance) {
         this.id = id;
         this.name = name;
         this.coordinates = coordinates;
         this.creationDate = ZonedDateTime.now();
         this.from = from;
         this.to = to;
         this.distance = distance;
    }
    public Route(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Location from, Location to, double distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public ZonedDateTime getCreationDate() {
        return creationDate;
    }


    public Location getFrom() {
        return from;
    }


    public Location getTo() {
        return to;
    }


    public Double getDistance() {
        return distance;
    }


    public boolean validate(){
    if (id == null || id <= 0) return false;
    if (name.isEmpty() || name == null) return false;
    if (!coordinates.validate()) return false;
    if (creationDate == null) return false;
    if (!from.validate()) return false;
    if (!to.validate()) return false;
    return !(distance - 1 < 0);
    }
    @Override
    public String toString(){
        return "id: " + this.id + "\nname: " + this.name + "\ncoordinates: " +
                this.coordinates + "\ncreationDate: " + this.creationDate + "\nfrom: " + this.from +
                "\nto: " + this.to + "\ndistance: " + this.distance + "\n";
    }
    public static Route fromArray(String[] a) {
        Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        String name; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates; //Поле не может быть null
        ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        Location from; //Поле не может быть null
        Location to; //Поле не может быть null
        double distance; //Значение поля должно быть больше 1
        try {
            try { id = Long.parseLong(a[0]); } catch (NumberFormatException e) { id = null; }
            name = a[1];
            coordinates = new Coordinates(a[2]);
            creationDate = ZonedDateTime.parse(a[3]);
            from = new Location(a[4]);
            to = new Location(a[5]);
            distance = Double.parseDouble(a[6]);
            return new Route(id, name, coordinates, creationDate, from, to, distance);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        return null;
    }

    public static String[] toArray(Route e) {
        var list = new ArrayList<String>();
        list.add(e.getId().toString());
        list.add(e.getName());
        list.add(e.getCoordinates().toString());
        list.add(e.getCreationDate().toString());
        list.add(e.getFrom().toString());
        list.add(e.getTo().toString());
        list.add(e.getDistance().toString());
        return list.toArray(new String[0]);
    }

    @Override
    public int compareTo(Route route) {
        return this.id.compareTo(route.getId());
    }

}


