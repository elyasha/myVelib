package core.components.factories;

import java.awt.Point;

import core.components.User;
import core.system.MyVelibSystem;

/**
 * The PointFactory class : This is the factory to create and add new points, that represent the coordinates in the project
 * It is uses the simple factory design pattern
 */
public class PointFactory {

    /**
     * This method creates a new point instance
     * @param x the x coordinate on the x-axis
     * @param y the y coordinate on the y-axis
     * @return the Point instance
     */
    public static Point addPoint(int x, int y) {
        return new Point(x, y);
    }

}
