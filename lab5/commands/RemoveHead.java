package commands;

import managers.CollectionManager;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда 'remove_last'. Удаляет элемент из коллекции.
 * @author skadibtw
 */
public class RemoveHead extends Command {
	private final Console console;
	private final CollectionManager collectionManager;

	public RemoveHead(Console console, CollectionManager collectionManager) {
		super("remove_last", "удалить последний элемент из коллекции");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		var d = collectionManager.getCollection().getFirst();
		collectionManager.remove(d.getId());
		collectionManager.update();
		return new ExecutionResponse("Маршрут успешно удалён!");
	}
}
