package ru.antonsesin.draw;

public class CommandPath {

    public enum Coordinates {
        ABSOLUTE,   // абсолютные координаты
        RELATIVE;   // относительные координаты
    }

    public CommandPath() {
        command.append("<path d=\"");
    }

    private StringBuilder command = new StringBuilder();

    private void endFile() {

        command.append(" fill=\"none\" stroke=\"black\" />\n");

    }

    public String getCommandPath() {
        return command.toString();
    }

    //M (moveto) - перемещает "перо" в указанные координаты
    //M x, y (абсолютные координаты)
    //m dx, dy (относительные координаты)
    public void moveTo(double startPosX, double startPosY, Coordinates coordinates){
        switch (coordinates){
            case ABSOLUTE:
                command.append("M").append(startPosX).append(" ").append(startPosY);
                break;
            case RELATIVE:
                command.append("m").append(startPosX).append(" ").append(startPosY);
                break;
        }
    }
    //L (lineto) - рисует линию до указанной точки
    //L x,y / l dx,dy
    public void lineTo(double x, double y, Coordinates coordinates){
        switch (coordinates){
            case ABSOLUTE:
                command.append("L").append(x).append(" ").append(y);
                break;
            case RELATIVE:
                command.append("l").append(x).append(" ").append(y);
                break;
        }

    }
    //H (horizontal lineto) - горизонтальная линия
    //H x / h dx
    public void horizontalLineTo(){

    }
    //V (vertical lineto) - вертикальная линия
    //V y / v dy
    public void verticalLineTo(){

    }
    //Z (closepath) - закрывает путь, рисуя линию к начальной точке
    //Z или z (не требует координат)
    public void closePath(){
        command.append("Z");
        command.append("\"");
    }
}



/*Основные команды path





Кривые Безье
C (curveto) - кубическая кривая Безье

        C x1,y1 x2,y2 x,y / c dx1,dy1 dx2,dy2 dx,dy

(x1,y1) - контрольная точка начала

        (x2,y2) - контрольная точка конца

        (x,y) - конечная точка

S (smooth curveto) - гладкая кубическая кривая (продолжение предыдущей)

        S x2,y2 x,y / s dx2,dy2 dx,dy

Q (quadratic curveto) - квадратичная кривая Безье

        Q x1,y1 x,y / q dx1,dy1 dx,dy

T (smooth quadratic curveto) - гладкая квадратичная кривая

        T x,y / t dx,dy

Дуги
A (elliptical arc) - эллиптическая дуга

        A rx,ry x-axis-rotation large-arc-flag sweep-flag x,y

        a rx,ry x-axis-rotation large-arc-flag sweep-flag dx,dy

rx,ry - радиусы по x и y

x-axis-rotation - угол поворота эллипса

large-arc-flag (0/1) - малая/большая дуга

sweep-flag (0/1) - направление рисования*/


