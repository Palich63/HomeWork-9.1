package ru.netology.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileOpenManager {

    private Map<String, String> maps = new HashMap<>();

    //Создание новой записи в Map
    public void saveMap(String key, String value) {
        maps.put(key, value);
    }

    //Получения списка ключей в виде коллекции Set
    public Set<String> getAllKey() {
        return maps.keySet();
    }

    //Получения списка значений в виде коллекции
    public Collection<String> getAllValue() {
        return maps.values();
    }

    //Функция проверки присутствия объекта по ключу без учёта регистра
    public boolean containsKey(String key) {
        for (String k : maps.keySet())
            if (k.equalsIgnoreCase(key)) {
                return true;
            }
        return false;
    }

    //Функция проверки присутствия объекта по значению
    public boolean containsValue(String value) {
        if (maps.containsValue(value))
            return true;
        return false;
    }

    //Получение значения по ключу
    public Object getValue(String key) {
        return maps.get(key);
    }

    //Удаление записи по ключу
    public void removeMap(String key) {
        maps.remove(key);
    }

    //Изменение значения
    public boolean replaceValue(String key, String oldValue, String newValue) {
        return maps.replace(key, oldValue, newValue);
    }
}
