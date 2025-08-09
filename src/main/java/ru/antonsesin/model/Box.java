package ru.antonsesin.model;

import ru.antonsesin.draw.Drawer;

public abstract class Box {
    protected double length;
    protected double width;
    protected double height;
    protected double thickness;
    protected int fingers;

    public Box(double length, double width, double height,
               double thickness, int fingers) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.fingers = fingers;
    }

    public abstract String generateSVG();

    protected Drawer createDrawer() {
        // Вычисляем размер поля для рисования
        int svgWidth = (int) (height + thickness + length + height + thickness + length + 50);
        int svgHeight = (int) (height + thickness + width + height + thickness + 50);
        return new Drawer(svgWidth, svgHeight);
    }
}
