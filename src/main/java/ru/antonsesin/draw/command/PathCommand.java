package ru.antonsesin.draw.command;

/**
 * Класс для рисования командой Path
 */
public class PathCommand implements SVGCommand {

    private final StringBuilder pathData = new StringBuilder();

    /**
     * M (moveto) - перемещает "перо" в указанные координаты
     * M x, y (абсолютные координаты)
     * m dx, dy (относительные координаты)
     */
    public PathCommand moveTo(double x, double y) {
        pathData.append("M").append(x).append(" ").append(y);
        return this;
    }

    /**
     * L (lineto) - рисует линию до указанной точки
     * L x,y / l dx,dy
     */
    public PathCommand lineTo(double x, double y) {
        pathData.append(" l").append(x).append(" ").append(y);
        return this;
    }

    /**
     * H (horizontal lineto) - горизонтальная линия
     * H x / h dx
     */
    public PathCommand horizontalLine(double distance) {
        pathData.append(" h").append(distance);
        return this;
    }

    /**
     * V (vertical lineto) - вертикальная линия
     * V y / v dy
     */
    public PathCommand verticalLine(double distance) {
        pathData.append(" v").append(distance);
        return this;
    }

    /**
     * Дуги:
     * A (elliptical arc) - эллиптическая дуга.
     * A rx,ry x-axis-rotation large-arc-flag sweep-flag x,y
     * a rx,ry x-axis-rotation large-arc-flag sweep-flag dx,dy
     * rx,ry - радиусы по x и y
     * x-axis-rotation - угол поворота эллипса
     * large-arc-flag (0/1) - малая/большая дуга
     * sweep-flag (0/1) - направление рисования
     */

    public PathCommand ellipticalArc(double rx, double ry, int x_axis_rotation, int large_arc_flag, int sweep_flag, double dx, double dy) {
        pathData.append(" a").append(rx)
                .append(",")
                .append(ry).append(" ")
                .append(x_axis_rotation).append(" ")
                .append(large_arc_flag).append(" ")
                .append(sweep_flag).append(" ")
                .append(dx).append(",")
                .append(dy).append(" ");
        return this;
    }

    /**
     * Z (closepath) - закрывает путь, рисуя линию к начальной точке
     * Z или z (не требует координат)
     */
    public PathCommand closePath() {
        pathData.append(" Z");
        return this;
    }

    @Override
    public String toSVG() {
        return "<path d=\"" + pathData.toString() +
                "\" fill=\"none\" stroke-width=\"0.2\" stroke=\"black\" />";
    }
}

/**
 * Кривые Безье
 * C (curveto) - кубическая кривая Безье
 * C x1,y1 x2,y2 x,y / c dx1,dy1 dx2,dy2 dx,dy
 * (x1,y1) - контрольная точка начала
 * (x2,y2) - контрольная точка конца
 * (x,y) - конечная точка
 * S (smooth curveto) - гладкая кубическая кривая (продолжение предыдущей)
 * S x2,y2 x,y / s dx2,dy2 dx,dy
 * Q (quadratic curveto) - квадратичная кривая Безье
 * Q x1,y1 x,y / q dx1,dy1 dx,dy
 * T (smooth quadratic curveto) - гладкая квадратичная кривая
 * T x,y / t dx,dy
 */
