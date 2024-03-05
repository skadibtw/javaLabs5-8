package managers;

import au.com.bytecode.opencsv.*;

import java.io.*;
import java.lang.NullPointerException;
import java.util.*;

import models.Route;
import utility.Console;

/**
 * Использует файл для сохранения и загрузки коллекции.
 * @author skadibtw
 */
public class DumpManager {
	private final String fileName;
	private final Console console;

	public DumpManager(String fileName, Console console) {
		this.fileName = fileName;
		this.console = console;
	}

	/**
	 * Преобразует коллекцию в CSV-строку.
	 * @param коллекция
	 * @return CSV-строка
	 */
	private String collection2CSV(Collection<Route> collection) {
		try {
			StringWriter sw = new StringWriter();
			CSVWriter csvWriter = new CSVWriter(sw, ';');
			for (var e : collection) {
				csvWriter.writeNext(Route.toArray(e));
			}
			String csv = sw.toString();
			return csv;
		} catch (Exception e) {
			console.printError("Ошибка сериализации");
			return null;
		}
	}

	/**
	 * Записывает коллекцию в файл.
	 * @param collection коллекция
	 */
	public void writeCollection(Collection<Route> collection) {
		OutputStreamWriter writer = null, writer2 = null, writer3 = null;
		try {
			var csv = collection2CSV(collection);
			if (csv == null) return;
			writer = new OutputStreamWriter(new FileOutputStream(fileName));
			try {
				writer.write(csv);
				writer.flush();
				console.println("Коллекция успешна сохранена в файл!");
			} catch (IOException e) {
				console.printError("Неожиданная ошибка сохранения");
			}
		} catch (FileNotFoundException | NullPointerException e) {
			console.printError("Файл не найден");
		} finally {
			try {
				writer.close();
			} catch(IOException e) {
				console.printError("Ошибка закрытия файла");
			}
		}
	}

	/**
	 * Преобразует CSV-строку в коллекцию.
	 * @param CSV-строка
	 * @return коллекция
	 */
	private ArrayDeque<Route> CSV2collection(String s) {
		try {
			StringReader sr = new StringReader(s);
			CSVReader csvReader = new CSVReader(sr, ';');
			ArrayDeque<Route> routes = new ArrayDeque<>();
			String[] record = null;
			while ((record = csvReader.readNext()) != null) {
				System.out.println(Arrays.toString(record));
				Route d = Route.fromArray(record);
				if (d.validate())
					routes.add(d);
				else
					console.printError("Файл с коллекцией содержит не действительные данные");
			}
			csvReader.close();
			return routes;
		} catch (Exception e) {
			console.printError(e.getMessage());
			return null;
		}
	}

	/**
	 * Считывает коллекцию из файла.
	 * @return Считанная коллекция
	 */
	public void readCollection(Collection<Route> collection) {
		if (fileName != null && !fileName.isEmpty()) {
			try {
				var s = new StringBuilder();
				FileInputStream fileInputStream = new FileInputStream(fileName);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
				Scanner fileReader = new Scanner(inputStreamReader); // Создаем Scanner из InputStreamReader

					while (fileReader.hasNextLine()) {
						s.append(fileReader.nextLine());
						s.append("\n");
					}
					collection.clear();
					for (var e : CSV2collection(s.toString()))
						collection.add(e);
					if (collection != null) {
						console.println("Коллекция успешна загружена!");
						return;
					} else
						console.printError("В загрузочном файле не обнаружена необходимая коллекция!");

			} catch (FileNotFoundException exception) {
				console.printError("Загрузочный файл не найден!");
			} catch (IllegalStateException exception) {
				console.printError("Непредвиденная ошибка!");
				System.exit(0);
			}
			catch (NullPointerException exception) {
				console.printError("Ошибка конвертации файла в коллекцию!");
			}
		} else {
			console.printError("Аргумент командной строки с загрузочным файлом не найден!");
		}
		collection = new ArrayDeque<Route>();
	}
}
