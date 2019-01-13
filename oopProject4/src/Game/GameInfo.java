package Game;

import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;
import Robot.Play;



/**
 * This class represents all the info about all the placements of the objects in our current game.
 * @author Alex Ilya Nour
 *
 */
public class GameInfo {

	
	private Packman myPack;
	private ArrayList<Packman> packs ;
	private ArrayList<Packman> ghosts ;
	private ArrayList<Fruit> fruits ;
	private ArrayList<Box> boxes ; 

	/**
	 * Constructor
	 * @param packs
	 * @param ghosts
	 * @param fruits
	 * @param boxes
	 */
	public GameInfo(ArrayList<Packman> packs,ArrayList<Packman> ghosts,ArrayList<Fruit> fruits,ArrayList<Box> boxes)
	{
		this.packs = packs;
		this.ghosts = ghosts;
		this.fruits = fruits;
		this.boxes = boxes;
	}

	/**
	 * Copy Constructor
	 * @param gi
	 */
	public GameInfo(GameInfo gi)
	{
		this.packs = gi.getPacks();
		this.ghosts = gi.getGhosts();
		this.fruits = gi.getFruits();
		this.boxes = gi.getBoxes();
	}

	/**
	 * Constructor by Strings
	 * @param info
	 */
	public GameInfo(ArrayList<String> info)
	{
		this.packs =new ArrayList<Packman>();
		this.ghosts = new ArrayList<Packman>();
		this.fruits = new ArrayList<Fruit>();
		this.boxes = new ArrayList<Box>();
		
		Iterator<String> it = info.iterator();
		while(it.hasNext())
		{
			
			String line = it.next();
			String[] comps = line.split(",");

			if(comps[0].equals("M"))
			{
				Packman packman = new Packman(
						new Point3D(Double.parseDouble(comps[2]),Double.parseDouble(comps[3]),Double.parseDouble(comps[4]))
						,Integer.parseInt(comps[1]),Double.parseDouble(comps[5]),Double.parseDouble(comps[6])
						);
				
				this.myPack=packman;
			}
			
			if(comps[0].equals("P"))
			{
				Packman packman = new Packman(
						new Point3D(Double.parseDouble(comps[2]),Double.parseDouble(comps[3]),Double.parseDouble(comps[4]))
						,Integer.parseInt(comps[1]),Double.parseDouble(comps[5]),Double.parseDouble(comps[6])
						);
				
				this.packs.add(packman);
			}
			else if(comps[0].equals("G"))
			{
				Packman ghost = new Packman(
						new Point3D(Double.parseDouble(comps[2]),Double.parseDouble(comps[3]),Double.parseDouble(comps[4]))
						,Integer.parseInt(comps[1]),Double.parseDouble(comps[5]),Double.parseDouble(comps[6])
						);
				this.ghosts.add(ghost);
			}
			else if(comps[0].equals("F"))
			{
				Fruit fruit = new Fruit(
						new Point3D(Double.parseDouble(comps[2]),Double.parseDouble(comps[3]),Double.parseDouble(comps[4]))
						,Integer.parseInt(comps[1]),false
						);
				this.fruits.add(fruit);
			}
			else if(comps[0].equals("B"))
			{
				Box box = new Box(
						Integer.parseInt(comps[1]),
						new Point3D(Double.parseDouble(comps[2]),Double.parseDouble(comps[3]),Double.parseDouble(comps[4])),
						new Point3D(Double.parseDouble(comps[5]),Double.parseDouble(comps[6]),Double.parseDouble(comps[7]))
						);
				this.boxes.add(box);
			}



		}
	}
	
	
	

	public Packman getMyPack() {
		return myPack;
	}

	public void setMyPack(Packman myPack) {
		this.myPack = myPack;
	}

	public ArrayList<Packman> getPacks() {
		return packs;
	}

	public void setPacks(ArrayList<Packman> packs) {
		this.packs = packs;
	}

	public ArrayList<Packman> getGhosts() {
		return ghosts;
	}

	public void setGhosts(ArrayList<Packman> ghosts) {
		this.ghosts = ghosts;
	}

	public ArrayList<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(ArrayList<Fruit> fruits) {
		this.fruits = fruits;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	

}
