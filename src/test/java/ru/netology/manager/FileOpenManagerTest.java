package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    private FileOpenManager manager = new FileOpenManager();

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
        manager.removeMap("doc");
        assertFalse(manager.containsKey("doc"));
    }

    @Test
    void shouldReplaceValue() {
        //Изменение значения по ключу если пара ключ значение соответствуют
        manager.replaceValue("dwg", "AutoCAD", "FreeCAD");
        assertEquals("FreeCAD", manager.getValue("dwg"));
    }

}