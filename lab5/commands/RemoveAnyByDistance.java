package commands;

import managers.CollectionManager;
import utility.Console;
import utility.ExecutionResponse;
/**
 * Команда 'remove_any_by_distance'. Удаляет первый элемень коллекции, дистанция которого совпадает с указанной.
 * @author skadibtw
 */
public class RemoveAnyByDistance extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveAnyByDistance(Console console, CollectionManager collectionManager) {
        super("remove_any_by_distance distance", "удалить из коллекции один элемент, значение поля distance которого эквивалентно заданному");
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
        Double distance_to_delete;
        try { distance_to_delete = Double.parseDouble(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }
        String name_of_route = null;
        for (var e: collectionManager.getCollection()) {
            if (distance_to_delete.equals(e.getDistance())) {
                name_of_route = e.getName();
                collectionManager.remove(e.getId());
                break;
            }
        }
        collectionManager.update();
        if (name_of_route == null) {
            return new ExecutionResponse(false, "Не найдено ни одного маршрута с такой дистанцией!");
        }
        return new ExecutionResponse("Маршрут успешно удалён!");
    }
}
