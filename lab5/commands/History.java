package commands;

import managers.CommandManager;
import utility.Console;
import utility.ExecutionResponse;
import java.util.List;


import java.util.Collections;

/**
 * Команда 'history'. Выводит историю последних 7 команд.
 * @author skadibtw
 */
public class History extends Command {
	private final Console console;
	private final CommandManager commandManager;

	public History(Console console, CommandManager commandManager) {
		super("history", "вывести последние 7 команд (без их аргументов)");
		this.console = console;
		this.commandManager = commandManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		StringBuilder stringBuilder = new StringBuilder();
		List<String> reversed_commands = commandManager.getCommandHistory();
		Collections.reverse(reversed_commands);
        int counter = 0;
		for (var e : reversed_commands) {
			if (counter == 7) {
				break;
			}
			stringBuilder.append(e).append("\n");
			counter++;
		}

		return new ExecutionResponse(stringBuilder.toString());
	}
}
