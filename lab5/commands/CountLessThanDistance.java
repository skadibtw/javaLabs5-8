package commands;

import managers.CollectionManager;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author skadibtw
 */

public class CountLessThanDistance extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public CountLessThanDistance(Console console, CollectionManager collectionManager) {
        super("count_less_than_distance distance", "вывести количество элементов, значение поля distance которых меньше заданного");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        Double distance_to_count;
        try { distance_to_count = Double.parseDouble(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }
        int counter = 0;
        for (var e: collectionManager.getCollection()) {
            if (distance_to_count - e.getDistance() < 0) {
                counter++;
            }
        }
        return new ExecutionResponse("Было найдено " + counter + "маршрутов, дистанция которых меньше заданной");
    }
}


