package commands;

import managers.CollectionManager;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author skadibtw
 */
public class Clear extends Command {
	private final Console console;
	private final CollectionManager collectionManager;

	public Clear(Console console, CollectionManager collectionManager) {
		super("clear", "очистить коллекцию");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty())
			return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		
		while (collectionManager.getCollection().size() > 0) {
			var route = collectionManager.getCollection().getLast();
			collectionManager.remove(route.getId());
		}
		
		collectionManager.update();
		return new ExecutionResponse("Коллекция очищена!");
	}
}
