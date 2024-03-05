package commands;

import managers.CollectionManager;
import utility.Console;

import java.util.Set;
import java.util.TreeSet;
import utility.ExecutionResponse;

/**
 * Команда 'print_unique_distance'. Вывести уникальные значения поля distance всех элементов в коллекции.
 * @author skadibtw
 */

public class PrintUniqueDistance extends Command {
	private final Console console;
	private final CollectionManager collectionManager;

	public PrintUniqueDistance(Console console, CollectionManager collectionManager) {
		super("print_unique_distance", "вывести уникальные значения поля distance всех элементов в коллекции");
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
		Set<Double> unique_distance = new TreeSet<>();
		for (var e : collectionManager.getCollection()) {
			if (e.getDistance() != null) {
				unique_distance.add(e.getDistance());
			}
		}
		var s = "";
		if (unique_distance.isEmpty())
			s = "Не указано ни одно значение distance";
		for (var e : unique_distance)
			s += " " + e;
		return new ExecutionResponse(s);
	}
}
