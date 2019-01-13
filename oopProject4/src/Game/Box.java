package Game;

import Geom.Point3D;

/**
 * This class represents the boxes in the game that out packman can't go through.
 * The min point represents the left bottom point of the box.
 * The max point represents the right top point of the box.
 * @author Alex Ilya Nour
 *
 */
public class Box {

	private int id;
	private Point3D min; //left bottom point of the box 
	private Point3D max; // right top point of the box
	
	/**
	 * Constructor
	 * @param min
	 * @param max
	 */
	public Box(int id, Point3D min,Point3D max)
	{
		this.id = id;
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Copy Constructor
	 * @param b
	 */
	public Box(Box b)
	{
		this.id = b.getId();
		this.min = b.getMin();
		this.max = b.getMax();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point3D getMin() {
		return min;
	}

	public void setMin(Point3D min) {
		this.min = min;
	}

	public Point3D getMax() {
		return max;
	}

	public void setMax(Point3D max) {
		this.max = max;
	}
	
	
	
}
