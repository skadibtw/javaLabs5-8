package ru.itmolabs.lab5.managers;

import ru.itmolabs.lab5.collection.Route;

import java.util.ArrayDeque;

//Класс, управляющий коллекцией

public class CollectionManager {
    private ArrayDeque<Route> array;

    public CollectionManager(ArrayDeque<Route> array) {
        this.array = array;
    }

    public long generateId() {
        long i = 1;
        for (var e : this.array) {
            if (e.getId() != i) {
                break;
            }
            i++;
        }
        return i;
    }
    public void add(Route route){
        array.add(route);
    }
}


