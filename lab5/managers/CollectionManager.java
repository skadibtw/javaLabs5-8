package managers;

import models.Route;

import java.util.LinkedList;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Оперирует коллекцией.
 * @author skadibtw
 */
public class CollectionManager {
	private long currentId = 1;
	private final Map<Long, Route> routes = new HashMap<>();
	private final ArrayDeque<Route> collection = new ArrayDeque<>();
	private LocalDateTime lastInitTime;
	private LocalDateTime lastSaveTime;
	private final DumpManager dumpManager;

	public CollectionManager(DumpManager dumpManager) {
		this.lastInitTime = null;
		this.lastSaveTime = null;
		this.dumpManager = dumpManager;
	}

	/**
	 * @return коллекция.
	 */
	public ArrayDeque<Route> getCollection() {
		return collection;
	}

	/**
	 * @return Последнее время инициализации.
	 */
	public LocalDateTime getLastInitTime() {
		return lastInitTime;
	}

	/**
	 * @return Последнее время сохранения.
	 */
	public LocalDateTime getLastSaveTime() {
		return lastSaveTime;
	}

	/**
	 * Сохраняет коллекцию в файл
	 */
	public void saveCollection() {
		dumpManager.writeCollection(collection);
		lastSaveTime = LocalDateTime.now();
	}

	/**
	 * Получить дракона по ID
	 */
	public Route byId(Long id) { return routes.get(id); }

	/**
	 * Содержит ли колекции дракона
	 */
	public boolean isСontain(Route e) { return e == null || byId(e.getId()) != null; }

	/**
	 * Получить свободный ID
	 */
	public long getFreeId() {
		while (byId(currentId) != null)
			if (++currentId < 0)
				currentId = 1;
		return currentId;
	}


	/**
	 * Добавляет маршрут
	 */
	public boolean add(Route d) {
		if (isСontain(d)) return false;
		routes.put(d.getId(), d);
		collection.add(d);
		update();
		return true;
	}

    /**
     * Удаляет маршрут по ID
     */
    public boolean remove(long id) {
        var a = byId(id);
        if (a == null) return false;
        routes.remove(a.getId());
        collection.remove(a);
        update();
        return true;
    }

	/**
	 * Фиксирует изменения коллекции
	 */
	public void update() {
		List<Route> routeList = new ArrayList<>(collection)  ;
		Collections.sort(routeList);
		collection.clear();
        collection.addAll(routeList);
	}
	
	/**
	 * Загружает коллекцию из файла.
	 * @return true в случае успеха.
	 */
	public boolean loadCollection() {
		routes.clear();
		dumpManager.readCollection(collection);
		lastInitTime = LocalDateTime.now();
		for (var e : collection)
			if (byId(e.getId()) != null) {
				collection.clear();
				return false;
			} else {
				if (e.getId()>currentId) currentId = e.getId();
				routes.put(e.getId(), e);
			}
		update();
		return true;
	}

	@Override
	public String toString() {
		if (collection.isEmpty()) return "Коллекция пуста!";

		StringBuilder info = new StringBuilder();
		for (Route route : collection) {
			info.append(route+"\n\n");
		}
		return info.toString().trim();
	}
}
