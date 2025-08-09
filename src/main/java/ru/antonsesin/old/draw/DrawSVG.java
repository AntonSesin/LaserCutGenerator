package ru.antonsesin.old.draw;

public class DrawSVG {
    int svgWidth;
    int svgHeight;
    StringBuilder svg = new StringBuilder();

    public DrawSVG(int svgWidth, int svgHeight) {
        this.svgWidth = svgWidth;
        this.svgHeight = svgHeight;
        startSVGFile();
    }

    private void startSVGFile() {
        svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\"\n");
        svg.append("width=\"").append(svgWidth).append("mm\" ");
        svg.append("height=\"").append(svgHeight).append("mm\"\n");
        svg.append("viewBox=\"0 0 ").append(svgWidth).append(" ").append(svgHeight).append("\">\n");

    }

    public void startPos(double x, double y) {
        svg.append("<path d=\"M").append(x).append(" ").append(y);
    }
    public void endPos(){
        svg.append("Z");
        svg.append("\"");
        svg.append(" fill=\"none\" stroke-width=\"0.2\" stroke=\"black\" />\n");
    }

    private void endFile() {
        svg.append("</svg>");
    }

    public String getSVGFile() {
        endFile();
        return svg.toString();
    }

    public void drawLeft(double l) {
        svg.append(" l").append(l * (-1)).append(",").append(0).append(" ");
    }

    public void drawRight(double l) {
        svg.append(" l").append(l).append(",").append(0).append(" ");
    }

    public void drawUp(double l) {
        svg.append(" l").append(0).append(",").append(l * (-1)).append(" ");
    }

    public void drawDown(double l) {
        svg.append(" l").append(0).append(",").append(l).append(" ");
    }
//a rx,ry x-axis-rotation large-arc-flag sweep-flag dx,dy
    public void drawSkrygl(double rx, double ry, int x_axis_rotation, int large_arc_flag, int sweep_flag, double dx,double dy) {
        svg.append(" a");
        svg.append(rx).append(",");
        svg.append(ry).append(" ");
        svg.append(x_axis_rotation).append(" ");
        svg.append(large_arc_flag).append(" ");
        svg.append(sweep_flag).append(" ");
        svg.append(dx).append(",");
        svg.append(dy).append(" ");
    }
//a 5,5 0 0 1 -5,5 "
}
