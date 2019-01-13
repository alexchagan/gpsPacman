package GUI;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;






import Geom.Geom_element;
import Geom.Point3D;
import Robot.Play;
import Coords.Coords;

import Database.Statistics;
import GUI.MyFrame.Animation;
import Game.Box;
import Game.Fruit;
import Game.GameInfo;
import Game.Packman;

/**
 * This Class represents the GUI of our game
 * Contain functions such as: opening a game, saving a game, editing a new game, clearing everything
 * and playing the game(making the packmen move and eat the fruits)
 * @author Alex Nour Ilya
 *
 */
public class MyFrame extends JFrame implements MouseListener
{

	
	private static final long serialVersionUID = 1L;

	private BufferedImage arielimg;
	private Map map = new Map();
	private Play play;
	private boolean oneClick = true;
	static boolean pacf = false;
	static boolean clik = false;
	static boolean mou = false;
	private static Point3D point;
	private GameInfo game ; 
	private Coords coords = new Coords();
	private double angle;
	private int hashCode;
	private Animation animation;



	/**
	 * Frame constructor
	 */
	public MyFrame() {
		initGUI();		
		this.addMouseListener(this); 
		this.setVisible(true);
		this.setSize(1297,this.arielimg.getHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(arielimg.getWidth()+"    "+arielimg.getHeight());
		System.out.println(this.getSize());
		this.setResizable(false);
		
		repaint();



	}
	/**
	 * Gui initialization
	 */
	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();
		Menu input = new Menu("Insert");
		 

		
		MenuItem pac = new MenuItem("Packman");
		Menu playM = new Menu("Play");

		MenuItem play = new MenuItem("Play");






		
		menuBar.add(input);

		input.add(pac);


		menuBar.add(playM);
		playM.add(play);



		this.setMenuBar(menuBar);


		pac.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				pacf = true;

			}
		});




		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				runpac();
			}
		});






		try {
			arielimg = ImageIO.read(new File("Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("reading image err");
		}		

	}
	
	/**
	 * Gets the initial "game-board" of the configuration
	 * @param conf
	 */

	public void initGame(String conf)
	{
		String file_name = conf;

		play = new Play(file_name);


		hashCode = play.getHash1();

		play.setIDs(123,123,123);

		String map_data = play.getBoundingBox();
		System.out.println("Bounding Box info: "+map_data);

		//  get the game-board data
		ArrayList<String> board_data = play.getBoard();
		for(int i=0;i<board_data.size();i++) {
			System.out.println(board_data.get(i));
		}


		game = new GameInfo(board_data);
	}

	/**
	 * performs the back scene mechanical "repainting" of main window graphics
	 */
	public void paint(Graphics g)

	{
		g.drawImage(arielimg, 0, 0, getWidth()-10, getHeight()-10,null);


		if(clik==true)
		{
			Packman myPack = new Packman(game.getMyPack());
			myPack.setPlace(map.latlon2XY(new Point3D(myPack.getPlace().y(),myPack.getPlace().x(),0)));

			int r = 25,x = 0,y = 0;



			x = (int) (myPack.getPlace().x()/point.getCompW() * getWidth());
			y = (int) (myPack.getPlace().y()/point.getComph() * getHeight());



			g.setColor(Color.pink);
			g.fillOval(x , y , r, r);



		}

		Iterator<Fruit> fit = game.getFruits().iterator();
		Iterator<Packman> pit = game.getPacks().iterator();
		Iterator<Packman> git = game.getGhosts().iterator();
		Iterator<Box> bit = game.getBoxes().iterator();

		//fruit painting


		while(fit.hasNext() ) {



			Fruit fruit = new Fruit (fit.next());

			fruit.setPlace(map.latlon2XY(new Point3D(fruit.getPlace().y(),fruit.getPlace().x(),0)));

			int r = 10,x = 0,y = 0;


			x = (int) (fruit.getPlace().x()/1297 * getWidth());
			y = (int) (fruit.getPlace().y()/642 * getHeight());



			g.setColor(Color.green);

			g.fillOval(x, y , r, r);




		}

		//packmen painting
		while (pit.hasNext()) {

			Packman pac = new Packman (pit.next());

			pac.setPlace(map.latlon2XY(new Point3D(pac.getPlace().y(),pac.getPlace().x(),0)));


			int r = 20,x = 0,y = 0;


			x = (int) (pac.getPlace().x()/1297  * getWidth());
			y = (int) (pac.getPlace().y()/642 * getHeight());

			g.setColor(Color.yellow);
			g.fillOval(x , y , r, r);
		}
		//ghosts paiting
		while(git.hasNext()) {

			Packman ghost = new Packman(git.next());	
			ghost.setPlace(map.latlon2XY(new Point3D(ghost.getPlace().y(),ghost.getPlace().x(),0)));

			int r = 20,x = 0,y = 0;


			x = (int) (ghost.getPlace().x()/1297 * getWidth());
			y = (int) (ghost.getPlace().y()/642 * getHeight());

			g.setColor(Color.red);
			g.fillOval(x , y , r, r);
		}

		//box painting
		while(bit.hasNext()) {
			Box box = new Box(bit.next());
			box.setMin(map.latlon2XY(new Point3D(box.getMin().y(),box.getMin().x(),0)));
			box.setMax(map.latlon2XY(new Point3D(box.getMax().y(),box.getMax().x(),0)));

			int bottomCorX = (int) (box.getMax().x()/1297 * getWidth())+10;
			int bottomCorY = (int) (box.getMin().y()/642 * getHeight())+5;


			int topCorX = (int) (box.getMin().x()/1297 * getWidth())+10;
			int topCorY = (int) (box.getMax().y()/642 * getHeight())+5;


			int width = bottomCorX - topCorX;
			int height = bottomCorY - topCorY;


			g.setColor(Color.BLACK);
			g.fillRect(topCorX, topCorY,width ,height);




		}

	}
	public void runpac()
	{
		play.start();
		animation = new Animation();
		Thread thread = new Thread(animation);
		thread.start();
	}


	/**
	 * supports the "run" function of the game, visualizing the actual "game" action 
	 */
	class Animation implements Runnable{
		@Override
		public void run() {


			while(play.isRuning())
			{
				play.rotate(angle);

				String info = play.getStatistics();
				System.out.println(info);
				ArrayList<String> board_data = play.getBoard();

				for(int a=0;a<board_data.size();a++) {
					System.out.println(board_data.get(a));

				}
				GameInfo newGame = new GameInfo(board_data);
				game = newGame;

				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				paint(getGraphics());
			}
			Statistics stats = new Statistics();
			String info = play.getStatistics();
			stats.getStats(info, hashCode);




		}
	}



	@Override
	public void mouseClicked(MouseEvent arg) {
		clik = true;
		
		if(pacf)
		{
			if(oneClick)
			{
				point = new Point3D(arg.getX(),arg.getY());
				point.setComph(getHeight());point.setCompW(getWidth());
				Point3D point2 = new Point3D(map.XY2latlon(point).y(),map.XY2latlon(point).x());

				System.out.println(point2.x() +"  "+point2.y());

				game.setMyPack(new Packman(point2,0,2.0,1.0));
				play.setInitLocation(point2.x(),point2.y());
				angle = 270;
				repaint();
				oneClick = false;
			}
			else 
			{
				point = new Point3D(arg.getX(),arg.getY());
				point.setComph(getHeight());point.setCompW(getWidth());
				Point3D point2 = new Point3D(map.XY2latlon(point).y(),map.XY2latlon(point).x());
				double newAngle = coords.azimuth(game.getMyPack().getPlace(), point2);
				angle = newAngle;
			}
		}





	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}





}





