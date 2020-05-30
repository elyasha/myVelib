package core.components.factories;

import java.awt.Point;

import core.components.User;
import core.system.MyVelibSystem;

public class PointFactory {
	
	public static Point addPoint(int x,int y) {
		return new Point(x,y);
	}

}
