package commands;

import managers.CollectionManager;
import models.Ask;
import models.Route;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 * @author skadibtw
 */
public class Add extends Command {
	private final Console console;
	private final CollectionManager collectionManager;

	public Add(Console console, CollectionManager collectionManager) {
		super("add {element}", "добавить новый элемент в коллекцию");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		try {
			if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		
			console.println("* Создание нового маршрута:");
			Route d = Ask.askRoute(console, collectionManager.getFreeId());
			
			if (d != null && d.validate()) {
				collectionManager.add(d);
				return new ExecutionResponse("Маршрут успешно добавлен!");
			} else return new ExecutionResponse(false,"Поля маршрута невалидны! Маршрут не будет создан!");
		} catch (Ask.AskBreak e) {
			return new ExecutionResponse(false,"Отмена...");
		}
	}
}
