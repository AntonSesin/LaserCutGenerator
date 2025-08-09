package ru.antonsesin;

import ru.antonsesin.model.SimpleBox;
import ru.antonsesin.old.model.BoxWithLid;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeneratorSVG {
    public static void main(String[] args) {
        // Параметры коробки (в мм)
        double length = 280.0;    // Длина
        double width = 95.0;     // Ширина
        double height = 30.0;     // Высота
        double thickness = 4.0;   // Толщина материала
        int fingers = 2;          // Количество пазов на стороне

        BoxWithLid boxWithLid = new BoxWithLid(length, width, height, thickness, fingers);

        // Генерируем и сохраняем SVG
        saveToFile("коробка с крышкой.svg", boxWithLid.getBox());

        // Рефракторная коробка

        ru.antonsesin.model.BoxWithLid box = new ru.antonsesin.model.BoxWithLid(length,width,height,thickness,fingers);
       saveToFile("тест коробка.svg",box.generateSVG());

        SimpleBox simpleBox = new SimpleBox(length,width,height,thickness,fingers);
        saveToFile("Простая коробка.svg",simpleBox.generateSVG());

    }

    private static void saveToFile(String fileName, String content) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(content);
            System.out.println("SVG-файл успешно создан: "+ fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка создания файла: " + e.getMessage());
        }
    }
}
