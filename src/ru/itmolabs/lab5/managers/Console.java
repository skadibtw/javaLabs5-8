package ru.itmolabs.lab5.managers;

public class Console {
    CollectionManager collectionManager;
    public Console(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public void printError(Exception e){
        System.err.println(e);
    }

}
