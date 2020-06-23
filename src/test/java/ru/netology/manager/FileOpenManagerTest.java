package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void shouldSetUp() {

        manager.saveMap("dwg", "AutoCAD");
        manager.saveMap("doc", "MS Word");
        manager.saveMap("jpg", "Paint");
    }

    @Test
    void shouldCheckContainsKey() {
        //Проверка наличия записи по ключу без учёта регистра
        assertTrue(manager.containsKey("DWG"));
    }

    @Test
    void shouldCheckContainsValue() {
        //Проверка наличия записи по значению
        assertTrue(manager.containsValue("MS Word"));
    }

    @Test
    void shouldGetValue() {
        //Получение значения по ключу
        assertEquals("MS Word", manager.getValue("doc"));
    }

    @Test
    void shouldDeleteMapByKey() {
        //Удаление по ключу
        Set<String> actual = new HashSet<>();
        actual.add("jpg");
        actual.add("dwg");
        manager.removeMap("doc");
        assertEquals(manager.getAllKey(), actual);
    }

    @Test
    void shouldReplaceValue() {
        //Изменение значения по ключу если пара ключ значение соответствуют
        Collection<String> actual = new HashSet<>();
        actual.add("Paint");
        actual.add("FreeCAD");
        actual.add("MS Word");
        manager.replaceValue("dwg", "AutoCAD", "FreeCAD");
        assertEquals(manager.getAllValue(), actual);
    }

}