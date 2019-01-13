package Game;

import java.util.Date;


import Geom.Point3D;

public class Fruit {
	/**
	 * This class represents a fruit in the game with id, coordinates
	 * and indication if it was eaten or not.
	 * @author Alex Nour Ilya
	 *
	 */
	private int id;
	private Point3D place;
	private boolean eaten = false;
	/**
	 * Constructor
	 * @param place
	 * @param id
	 * @param weight
	 */
	public Fruit(Point3D place,int id,boolean eaten)
	{
		this.place = place;
		this.id = id;
		this.eaten = eaten;
	}
	
	public Fruit(Fruit f)
	{
		this.place = f.getPlace();
		this.id = f.getId();
		this.eaten = f.eaten();
	}
	
	


/**
 * @return coordinates of fruit
 */
	public Point3D getPlace() {
		return place;
	}
	
	/**
	 * @return id of the fruit
	 */
	public int getId() {
		return id;
	}


	/**
	 * sets the fruit with different coordinates
	 * @param p - coordinates
	 */
	
	public void setPlace(Point3D p) {
		this.place = p;
	
	}
	/**
	 * sets fruit to eaten/not eaten
	 * @param true/false
	 */
	
	public void eaten(boolean b) {
		this.eaten = b;
	}
	/**
	 * @return if fruit is eaten or not
	 */
	public boolean eaten() {
		return this.eaten;
	}



}
