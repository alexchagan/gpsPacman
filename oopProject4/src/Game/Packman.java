package Game;

import java.util.ArrayList;
import java.util.Date;

import Geom.Point3D;
/**
 * This class represents a packman or a ghost.
 * @author Alex Nour Ilya
 *
 */
public class Packman {

	private Point3D place;
	private int id;
	private double speed;
	private double radius;
	private double angle;
	private Point3D target;
	



	
	/**
	 * Constructor
	 * @param place
	 * @param id
	 * @param speed
	 * @param radius
	 */

	public Packman(Point3D place, int id, double speed, double radius)
	{
		this.place = place;
		this.id = id;
		this.speed = speed;
		this.radius = radius;
		

	}
	/**
	 * Copy constructor
	 * @param pac
	 */
	public Packman(Packman pac)
	{	
		
		this.place = new Point3D(pac.getPlace());
		this.speed = pac.speed;
		this.radius = pac.radius;
	
		this.id = pac.getId();
	}
	
	public Packman(Point3D p) {

		
		this.place = new Point3D(p);
		

	}

	/**
	 * @return coordinates of packman
	 */

	public Point3D getPlace() {
		return this.place;
	}
	/**
	 * set new coordinates to packman
	 * @param point
	 */
	public void setPlace(Point3D point) {
		this.place = point;
	}
	
	/**
	 * @return speed of packman
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return radius of packman
	 */

	public double getRadius() {
		return radius;
	}
	
	

	
	
	/**
	 * set new target to the packman
	 * @param path
	 */
	
	public void setTarget(Point3D target) {
		this.target = target;
	}
	
	public Point3D getTarget()
	{
		return this.target;
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * 
	 * @return time of eating all fruits in path
	 */

	public void setRadius(int radius2) {
		this.radius = radius2;		
	}
	/**
	 * set new time of eating all fruits in path
	 * @param time
	 */
	public void setSpeed(int speed2) {
		this.speed = speed2;		
	}
	
	public double getAngle()
	{
		return this.angle;
	}
	
	public void setAngle(double angle)
	{
		this.angle = angle;
	}


	




}
