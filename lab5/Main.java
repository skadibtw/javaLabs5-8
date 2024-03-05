import commands.*;

import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;

import utility.StandardConsole;
import utility.Runner;

import java.util.ArrayDeque;

/*
I HATE JAVA LANG AND JVM AND JAVASCRIPT AND ANYTHING ELSE THAT CONTAINS JAVA IN ITS NAME
THE ONLY GOOD PRODUCT WRITTEN IN JAVA IS MINECRAFT
 */
// TODO update command fix, add_if_min realisation, remove_any_by_distance realisation, count_less_than_distance realisation
// TODO print_unique_distance fix javadoc
// TODO add methods to coordinates and location,
public class Main {
	public static void main(String[] args) {
		var console = new StandardConsole();

		if (args.length == 0) {
			console.println("Введите имя загружаемого файла как аргумент командной строки");
			System.exit(1);
		}
		
		var dumpManager = new DumpManager(args[0], console);
		var collectionManager = new CollectionManager(dumpManager);
		if (!collectionManager.loadCollection()) {
			System.exit(1);
		}
		
		var commandManager = new CommandManager() {{
			register("help", new Help(console, this));
			register("history", new History(console, this));
			register("info", new Info(console, collectionManager));
			register("show", new Show(console, collectionManager));
			register("add", new Add(console, collectionManager));
			register("update", new Update(console, collectionManager));
			register("remove_by_id", new RemoveById(console, collectionManager));
			register("clear", new Clear(console, collectionManager));
			register("save", new Save(console, collectionManager));
			register("execute_script", new ExecuteScript(console));
			register("exit", new Exit(console));
			register("remove_head", new RemoveHead(console, collectionManager));

		}};
		
		new Runner(console, commandManager).interactiveMode();
	}
}

