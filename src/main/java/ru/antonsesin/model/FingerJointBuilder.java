package ru.antonsesin.model;

import ru.antonsesin.draw.command.PathCommand;

public class FingerJointBuilder {
    public static void createHorizontalFingers(PathCommand path, double length, int count, double thickness, boolean truncatedLineFlag) {
        if (truncatedLineFlag) {
            path.horizontalLine(differenceMod(length, thickness));
        } else path.horizontalLine(length);
        for (int i = 0; i < count; i++) {
            path.verticalLine(thickness)
                    .horizontalLine(length)
                    .verticalLine(-thickness);
            if (truncatedLineFlag && i == count - 1) {
                path.horizontalLine(differenceMod(length, thickness));
            } else path.horizontalLine(length);
        }
    }

    public static void createVerticalFingers(PathCommand path, double length, int count, double thickness, boolean truncatedLineFlag) {
        if (truncatedLineFlag) {
            path.verticalLine(differenceMod(length, thickness));
        } else path.verticalLine(length);
        for (int i = 0; i < count; i++) {
            path.horizontalLine(-thickness)
                    .verticalLine(length)
                    .horizontalLine(thickness);
            if (truncatedLineFlag && i == count - 1) {
                path.verticalLine(differenceMod(length, thickness));
            } else path.verticalLine(length);
        }
    }

    private static double differenceMod(double x, double y) {
        if (x < 0) {
            return -(Math.abs(x) - Math.abs(y));
        } else return x - Math.abs(y);
    }
}

