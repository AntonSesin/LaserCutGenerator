package ru.antonsesin.model;

import ru.antonsesin.draw.DrawSVG;

public class BoxWithLid extends Box {
    DrawSVG drawSVG;

    double l;
    double w;
    double h;

    public BoxWithLid(double length, double width, double height, double thickness, int fingers) {
        this.length = length;
        this.width = width;
        this.height = height - thickness;
        this.thickness = thickness;
        this.fingers = fingers;
    }

    @Override
    String generateBoxSVG() {
        // Размеры SVG холста
        int svgWidth = (int) (height+thickness + length + height+thickness + length + 50); // Ширина
        int svgHeight = (int) (height+thickness + width + height+thickness + 50); // Высота

        drawSVG = new DrawSVG(svgWidth, svgHeight);

        int i = (fingers * 2) + 1; //вычисляем количество отрезков length

        l = length / i; //вычисляем длинну отрезков length
        w = width / i; //вычисляем длинну отрезков width
        h = height / i;  //вычисляем длинну отрезков height

        generateBottom();
        generateBack();
        generateFront();
        generateLeft();
        generateRight();
        generateTop();

        return drawSVG.getSVGFile();
    }

    private void generateTop() {
        double x = 10 + height+thickness + 10 + length + 10 + height+thickness + 10 + thickness;
        double y = 10 + height+thickness + 10;
        drawSVG.startPos(x, y);
        drawSVG.drawRight(length);
        drawSVG.drawDown(thickness);
        drawSVG.drawLeft(thickness+1);
        drawSVG.drawDown(width - thickness-thickness - 1.0);
        drawSVG.drawLeft(length - thickness-thickness-2);
        drawSVG.drawUp(width - thickness-thickness - 1.0);
        drawSVG.drawLeft(thickness+1);
        drawSVG.drawUp(thickness);
        drawSVG.endPos();
    }

    private void generateRight() {
        double x = 10 + height+thickness + 10 + length + 10+thickness;
        double y = 10 + height+thickness + 10;
        drawSVG.startPos(x, y);
        drawSVG.drawRight(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawDown(thickness);
            drawSVG.drawRight(h);
            drawSVG.drawUp(thickness);
            drawSVG.drawRight(h);
        }
        drawSVG.drawSkrygl(thickness, thickness, 0, 0, 1, thickness, thickness);
        drawSVG.drawDown(thickness + 1);
        drawSVG.drawSkrygl(thickness, thickness, 0, 0, 1, -thickness, thickness);
        drawSVG.drawDown(width - (thickness*2) - thickness - 1);

        drawSVG.drawLeft(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawUp(thickness);
            drawSVG.drawLeft(h);
            drawSVG.drawDown(thickness);
            drawSVG.drawLeft(h);
        }

        drawSVG.drawUp(w);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawLeft(thickness);
            drawSVG.drawUp(w);
            drawSVG.drawRight(thickness);
            drawSVG.drawUp(w);
        }

        drawSVG.endPos();

        drawSVG.startPos(x + height - thickness + 0.5, y + thickness);
        drawSVG.drawRight(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, 1, 1);
        drawSVG.drawDown(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, -1, 1);
        drawSVG.drawLeft(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, -1, -1);
        drawSVG.drawUp(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, 1, -1);
        drawSVG.endPos();
    }

    private void generateLeft() {
        double x = 10.0;
        double y = 10 + height+thickness + 10;
        drawSVG.startPos(x, y);
        drawSVG.drawRight(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawDown(thickness);
            drawSVG.drawRight(h);
            drawSVG.drawUp(thickness);
            drawSVG.drawRight(h);
        }

        drawSVG.drawDown(w);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawRight(thickness);
            drawSVG.drawDown(w);
            drawSVG.drawLeft(thickness);
            drawSVG.drawDown(w);
        }

        drawSVG.drawLeft(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawUp(thickness);
            drawSVG.drawLeft(h);
            drawSVG.drawDown(thickness);
            drawSVG.drawLeft(h);
        }
        drawSVG.drawUp(width - (thickness*2) - thickness - 1);
        drawSVG.drawSkrygl(thickness, thickness, 0, 0, 1, -thickness, -thickness);
        drawSVG.drawUp(thickness + 1);
        drawSVG.drawSkrygl(thickness, thickness, 0, 0, 1, thickness, -thickness);
        drawSVG.endPos();

        drawSVG.startPos(x + 0.5, y + thickness);
        drawSVG.drawRight(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, 1, 1);
        drawSVG.drawDown(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, -1, 1);
        drawSVG.drawLeft(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, -1, -1);
        drawSVG.drawUp(thickness - 1);
        drawSVG.drawSkrygl(1, 1, 0, 0, 1, 1, -1);
        drawSVG.endPos();
    }

    private void generateFront() {
        double x = 10 + height+thickness + 10 + thickness;
        double y = 10 + height+thickness + 10 + width + 10+thickness;
        drawSVG.startPos(x, y);
        drawSVG.drawRight(l - thickness);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawUp(thickness);
            drawSVG.drawRight(l);
            drawSVG.drawDown(thickness);
            if (j == fingers - 1) {
                drawSVG.drawRight(l - thickness);
            } else drawSVG.drawRight(l);
        }

        drawSVG.drawDown(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawRight(thickness);
            drawSVG.drawDown(h);
            drawSVG.drawLeft(thickness);
            if (j == fingers - 1) {
                drawSVG.drawDown(h - thickness);
            } else drawSVG.drawDown(h);
        }

        drawSVG.drawLeft(length - (thickness * 2));

        drawSVG.drawUp(h - thickness);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawLeft(thickness);
            drawSVG.drawUp(h);
            drawSVG.drawRight(thickness);
            drawSVG.drawUp(h);
        }
        drawSVG.endPos();
    }

    private void generateBack() {
        int x = (int) (10 + height+thickness + 10 + thickness);
        int y = 10;
        drawSVG.startPos(x, y);
        drawSVG.drawRight(length - (thickness * 2));
        drawSVG.drawDown(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawRight(thickness);
            drawSVG.drawDown(h);
            drawSVG.drawLeft(thickness);
            drawSVG.drawDown(h);
        }

        drawSVG.drawLeft(l - thickness);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawDown(thickness);
            drawSVG.drawLeft(l);
            drawSVG.drawUp(thickness);
            if (j == fingers - 1) {
                drawSVG.drawLeft(l - thickness);
            } else drawSVG.drawLeft(l);

        }

        drawSVG.drawUp(h);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawLeft(thickness);
            drawSVG.drawUp(h);
            drawSVG.drawRight(thickness);
            drawSVG.drawUp(h);

        }
        drawSVG.endPos();
    }

    private void generateBottom() {
        int x = (int) (10 + height+thickness + 10);
        int y = (int) (10 + height+thickness + 10);
        drawSVG.startPos(x, y);
        drawSVG.drawRight(l);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawDown(thickness);
            drawSVG.drawRight(l);
            drawSVG.drawUp(thickness);
            drawSVG.drawRight(l);
        }

        drawSVG.drawDown(w);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawLeft(thickness);
            drawSVG.drawDown(w);
            drawSVG.drawRight(thickness);
            drawSVG.drawDown(w);
        }

        drawSVG.drawLeft(l);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawUp(thickness);
            drawSVG.drawLeft(l);
            drawSVG.drawDown(thickness);
            drawSVG.drawLeft(l);

        }

        drawSVG.drawUp(w);
        for (int j = 0; j < fingers; j++) {
            drawSVG.drawRight(thickness);
            drawSVG.drawUp(w);
            drawSVG.drawLeft(thickness);
            drawSVG.drawUp(w);
        }
        drawSVG.endPos();
    }
}
