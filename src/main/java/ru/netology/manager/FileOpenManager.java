package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@AllArgsConstructor
public class FileOpenManager {

    private Map<String, String> maps = new HashMap<>();

    public FileOpenManager() {

    }

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

    // Получения записей в виде коллекции Set
    public Set set() {
        return maps.entrySet();
    }

    //Функция проверки присутствия объекта по ключу без учёта регистра
    // Но при этом я пожертвовал методом containsKey, если проделать тоже самое, но с этим методом, я рад был бы узнать как.
    public boolean containsKey(String key) {
        Iterator iterator = maps.keySet().iterator();
        while (iterator.hasNext()) {
            if (key.equalsIgnoreCase((String) iterator.next()))
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
