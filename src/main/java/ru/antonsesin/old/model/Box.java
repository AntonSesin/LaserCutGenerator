package ru.antonsesin.old.model;

abstract public class Box {
    double length;      // Длина
    double width;       // Ширина
    double height;      // Высота
    double thickness;   // Толщина материала
    int fingers;        // Количество пазов на стороне

    public String getBox(){
        return generateBoxSVG();
    };
    abstract String generateBoxSVG();
}
