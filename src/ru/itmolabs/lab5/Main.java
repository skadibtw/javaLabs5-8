package ru.itmolabs.lab5;

import ru.itmolabs.lab5.managers.CSVManager;
import ru.itmolabs.lab5.collection.*;
import ru.itmolabs.lab5.managers.CollectionManager;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.List;


public class Main {
    static ArrayDeque<Route> routes = new ArrayDeque<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        CollectionManager collectionManager = new CollectionManager(routes);
        routes.add(new Route("abobus", new Coordinates(1,2f), new Location(1f, 2d, 3f), new Location(1f, 2d, 3f), 123));
        routes.add(new Route("abobus2", new Coordinates(1,2f), new Location(1f, 2d, 3f), new Location(1f, 2d, 3f), 123));
//        public Route(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Location from, Location to, double distance)
            for (var e: routes) System.out.println(e);



//        CSVManager csvManager = new CSVManager();
//        csvManager.readCSV("C:/Users/user/IdeaProjects/lab5/src/ru/itmolabs/lab5/test.csv");

    }
}