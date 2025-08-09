package ru.antonsesin.draw;

import ru.antonsesin.draw.command.SVGCommand;

import java.util.ArrayList;
import java.util.List;

/// Отвечает за структуру SVG-документа
public class SVGDocument {
    private final StringBuilder svg = new StringBuilder();
    private final List<SVGCommand> commands = new ArrayList<>();
    private final int width;
    private final int height;

    public SVGDocument(int width, int height) {
        this.width = width;
        this.height = height;
        initDocument();
    }

    private void initDocument() {
        svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<svg xmlns=\"http://www.w3.org/2000/svg\"\n")
                .append("width=\"").append(width).append("mm\" ")
                .append("height=\"").append(height).append("mm\"\n")
                .append("viewBox=\"0 0 ").append(width).append(" ").append(height).append("\">\n");
    }

    public void addCommand(SVGCommand command) {
        commands.add(command);
    }

    public String generate() {
        for (SVGCommand command : commands) {
            svg.append(command.toSVG()).append("\n");
        }
        svg.append("</svg>");
        return svg.toString();
    }
}
