package ru.antonsesin;

import ru.antonsesin.model.BoxWithLid;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeneratorSVG {
    public static void main(String[] args) {
        // Параметры коробки (в мм)
        double length = 100.0;    // Длина
        double width = 100.0;     // Ширина
        double height = 50.0;     // Высота
        double thickness = 4.0;   // Толщина материала
        int fingers = 2;          // Количество пазов на стороне

        BoxWithLid boxWithLid = new BoxWithLid(length, width, height, thickness, fingers);

        try (PrintWriter out = new PrintWriter("parametric_box.svg")) {
            out.println(boxWithLid.getBox());
            System.out.println("SVG-файл успешно создан: parametric_box.svg");
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка создания файла: " + e.getMessage());
        }
    }
}
