package GUI;

import java.util.ArrayList;

import Database.Statistics;
import Game.GameInfo;
import Geom.Point3D;
import Robot.Play;

public class Main {

	public static void main(String[] args) {
		///////////TEST////////////////
//		Map map = new Map();
//		Point3D p1 = new Point3D(32.1021493912899,35.20281754867361);
//		Point3D p2 = new Point3D(32.105414027818185,35.203302498815304);
//		
//		p1 = map.latlon2XY(p1);
//		p2 = map.latlon2XY(p2);
//		
//		int x = (int)(p1.x()/1433);
//		int y = (int)(p1.y()/642);
//		
//		System.out.println("X "+x+"| Y "+y);
		
		
		///////////GAME START//////////////
//		String file_name = "data/Ex4_OOP_example3.csv";
//		Play play1 = new Play(file_name);
//		
//		play1.setIDs(1111,2222,3333);
//		
//		String map_data = play1.getBoundingBox();
//		System.out.println("Bounding Box info: "+map_data);
//		
//		// 4) get the game-board data
//		ArrayList<String> board_data = play1.getBoard();
//		for(int i=0;i<board_data.size();i++) {
//			System.out.println(board_data.get(i));
//		}
//		
//		GameInfo game = new GameInfo(board_data);
		
		//Statistics s = new Statistics();
		//s.getStats(null);
		
	MyFrame mf = new MyFrame();
	mf.initGame("data/Ex4_OOP_example5.csv");

	}

}
