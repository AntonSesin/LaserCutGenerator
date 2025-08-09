package ru.antonsesin.model;

import ru.antonsesin.draw.Drawer;
import ru.antonsesin.draw.command.PathCommand;

/// Простая коробка
public class SimpleBox extends Box {

    double l;   // длинна отрезков length
    double w;   // длинна отрезков width
    double h;   // длинна отрезков height

    /// (height - thickness) чтобы высота боковушек соответствовала размеру
    public SimpleBox(double length, double width, double height,
                     double thickness, int fingers) {
        super(length, width, height - thickness, thickness, fingers);
    }

    @Override
    public String generateSVG() {
        int count = (fingers * 2) + 1; //вычисляем количество отрезков length

        l = length / count;     // вычисляем длинну отрезков length
        w = width / count;      // вычисляем длинну отрезков width
        h = height / count;     // вычисляем длинну отрезков height

        Drawer drawer = createDrawer();

        generateBottom(drawer);
        generateBack(drawer);
        generateFront(drawer);
        generateLeft(drawer);
        generateRight(drawer);

        return drawer.generateSVG();
    }

    /// Рисуем правую стенку
    private void generateRight(Drawer drawer) {
        double x = 10 + height + thickness + 10 + length + 10 + thickness;
        double y = 10 + height + thickness + 10;
        PathCommand path = drawer.createPath().moveTo(x, y);
        FingerJointBuilder.createHorizontalFingers(path, h, fingers, thickness, false);
        path.verticalLine(width);
        FingerJointBuilder.createHorizontalFingers(path, -h, fingers, -thickness, false);
        FingerJointBuilder.createVerticalFingers(path, -w, fingers, thickness, false);
        path.closePath();

    }

    /// Рисуем левую стенку
    private void generateLeft(Drawer drawer) {
        double x = 10.0;
        double y = 10 + height + thickness + 10;
        PathCommand path = drawer.createPath().moveTo(x, y);
        FingerJointBuilder.createHorizontalFingers(path, h, fingers, thickness, false);
        FingerJointBuilder.createVerticalFingers(path, w, fingers, -thickness, false);
        FingerJointBuilder.createHorizontalFingers(path, -h, fingers, -thickness, false);
        path.verticalLine(-width).closePath();
    }

    /// Рисуем переднюю стенку
    private void generateFront(Drawer drawer) {
        double x = 10 + height + thickness + 10 + thickness;
        double y = 10 + height + thickness + 10 + width + 10 + thickness;
        PathCommand path = drawer.createPath()
                .moveTo(x, y);
        FingerJointBuilder.createHorizontalFingers(path, l, fingers, -thickness, true);
        FingerJointBuilder.createVerticalFingers(path, h, fingers, -thickness, false);
        path.horizontalLine(-(length - (thickness * 2)));
        FingerJointBuilder.createVerticalFingers(path, -h, fingers, thickness, false);
        path.closePath();
    }

    /// Рисуем заднюю стенку
    private void generateBack(Drawer drawer) {
        double x = 10 + height + thickness + 10 + thickness;
        double y = 10;
        PathCommand path = drawer.createPath()
                .moveTo(x, y)
                .horizontalLine(length - (thickness * 2));
        FingerJointBuilder.createVerticalFingers(path, h, fingers, -thickness, false);
        FingerJointBuilder.createHorizontalFingers(path, -l, fingers, thickness, true);
        FingerJointBuilder.createVerticalFingers(path, -h, fingers, thickness, false);
        path.closePath();
    }

    /// Рисуем дно
    private void generateBottom(Drawer drawer) {
        double x = 10 + height + thickness + 10;
        double y = 10 + height + thickness + 10;
        PathCommand path = drawer.createPath().moveTo(x, y);
        FingerJointBuilder.createHorizontalFingers(path, l, fingers, thickness, false);
        FingerJointBuilder.createVerticalFingers(path, w, fingers, thickness, false);
        FingerJointBuilder.createHorizontalFingers(path, -l, fingers, -thickness, false);
        FingerJointBuilder.createVerticalFingers(path, -w, fingers, -thickness, false);
        path.closePath();
    }

}
