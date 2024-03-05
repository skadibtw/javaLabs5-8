package commands;

import managers.CollectionManager;
import utility.Console;
import java.util.TreeSet;
import utility.ExecutionResponse;

/**
 * Команда 'print_unique_age'. Вывести уникальные значения поля age всех элементов в коллекции.
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
		var beNull = false;
		var ts = new TreeSet<Double>();
		for (var e : collectionManager.getCollection()) {
			if (e.getDistance() == null)
				beNull = true;
			else
				ts.add(e.getDistance());
		}
		var s="";
		if (beNull)
			s=" null";
		for (var e : ts)
			s+=" " + e;
		return new ExecutionResponse(s);
	}
}
