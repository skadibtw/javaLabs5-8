package models;


import utility.Console;
import java.util.NoSuchElementException;


/**
 * Класс, предназначенный для чтения объекта из терминала или скрипта.
 * @author skadibtw
 */
public class Ask {
	public static class AskBreak extends Exception {}
	
	public static Route askRoute(Console console, long id) throws AskBreak {
		/*
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле не может быть null
    private double distance; //Значение поля должно быть больше 1
		*/
		try {
			console.print("name: ");
			String name;
			while (true) {
				name = console.readln().trim();
				if (name.equals("exit")) throw new AskBreak();
				if (!name.isEmpty()) break;
				console.print("name: ");
			}
			var coordinates = askCoordinates(console);
			var location_to = askLocation(console);
			var location_from = askLocation(console);
			double distance;
			console.print("distance: ");
			while (true) {
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try {
						distance = Double.parseDouble(line);
						if (distance - 1 > 0) break;
					} catch (NumberFormatException ignored) {}
				}
				console.print("distance: ");
			}
			return new Route(id, name, coordinates, location_to, location_from, distance);
		} catch (NoSuchElementException | IllegalStateException e) {
			console.printError("Ошибка чтения");
			return null;
		}
    }
	public static Coordinates askCoordinates(Console console) throws AskBreak {
		try {

//			private int x; //Значение поля должно быть больше -14
//			private double y;
			int x;
			while (true) {
				console.print("X coordinate: ");
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try { x = Integer.parseInt(line); if (x>-14) break; } catch (NumberFormatException ignored) { }
				}
				console.print("X coordinate: ");
			}

			double y;
			while (true) {
				console.print("Y coordinate: ");
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try {
						y = Double.parseDouble(line);
						break;
					} catch (NumberFormatException e) {}
				}

			}
			
			return new Coordinates(x, y);
		} catch (NoSuchElementException | IllegalStateException e) {
			console.printError("Ошибка чтения");
			return null;
		}
	}




	public static Location askLocation(Console console) throws AskBreak {
		try {
//			private Float x; //Поле не может быть null
//			private Double y; //Поле не может быть null
//			private float z;
//			private String name; //Строка не может быть пустой, Поле может быть null

			float x;
			while (true) {
				console.print("X coordinate: ");
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try { x = Float.parseFloat(line); break; } catch (NumberFormatException e) { }
				}
			}
			double y;
			while (true) {
				console.print("Y coordinate: ");
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try { y = Double.parseDouble(line); break; } catch (NumberFormatException e) { }
				}
			}

			float z;
			while (true) {
				console.print("Z coordinate: ");
				var line = console.readln().trim();
				if (line.equals("exit")) throw new AskBreak();
				if (!line.isEmpty()) {
					try { z = Float.parseFloat(line); break; } catch (NumberFormatException e) { }
				}
			}
			String name;
			console.print("name: ");
			var line = console.readln().trim();
			if (line.equals("exit")) throw new AskBreak();
			if (!line.isEmpty()) {
				name = line;
			}
			else {
				name = null;
			}

			
			return new Location(x, y, z, name);
		} catch (NoSuchElementException | IllegalStateException e) {
			console.printError("Ошибка чтения");
			return null;
		}
	}
}
