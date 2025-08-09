package ru.antonsesin.draw;

import ru.antonsesin.draw.command.PathCommand;

/// Фасад для упрощенного рисования
public class Drawer {
    private final SVGDocument document;

    public Drawer(int width, int height) {
        this.document = new SVGDocument(width, height);
    }

    public PathCommand createPath() {
        PathCommand path = new PathCommand();
        document.addCommand(path);
        return path;
    }

    // Можно добавить методы для других фигур

    public String generateSVG() {
        return document.generate();
    }
}
