package Coords;

import Geom.Point3D;

public class Coords {

	public double azimuth(Point3D gps0,Point3D gps1)
	{
		double radianLat0 = Math.toRadians(gps0.x()) , radianLon0 = Math.toRadians(gps0.y()) ,
				radianLat1 =Math.toRadians(gps1.x()) , radianLon1 = Math.toRadians(gps1.y()) ;
		double longDiff= radianLon1-radianLon0;
		double y = Math.sin(longDiff)*Math.cos(radianLat1);
		double x = Math.cos(radianLat0)*Math.sin(radianLat1)-Math.sin(radianLat0)*Math.cos(radianLat1)*Math.cos(longDiff);
		return ( Math.toDegrees(Math.atan2(y, x)) + 360 ) % 360;

	}
	
	/**
	 * computes the 3D distance (in meters) between the two gps like points
	 * this distance method takes alt in calculation unlike the one in the excel file.
	 * source: https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
	 */
	
	public double distance3d(Point3D gps0, Point3D gps1) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(gps1.x() - gps0.x());
		double lonDistance = Math.toRadians(gps1.y() - gps0.y());
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(gps0.x())) * Math.cos(Math.toRadians(gps1.x()))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = gps0.z() - gps1.z();

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);

	}
	

}
