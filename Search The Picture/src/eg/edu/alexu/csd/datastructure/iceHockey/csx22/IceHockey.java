package eg.edu.alexu.csd.datastructure.iceHockey.csx22;

import java.awt.Point;

public class IceHockey implements IPlayersFinder{

	private static int ymin ,ymax,xmin,xmax,counter;
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		Point [] centerPoints = new Point [2500];//the array of points that i used to save the center points of the players 
		char [][] tempArr = new char [photo.length][photo[0].length()];
		for (int i = 0;i<photo.length;i++) {
			tempArr[i]=photo[i].toCharArray();	
		}
		int temp = 0;//temporary variable to save in the array of points 
		int nbox=(threshold+3)/4;//the least number of boxes that refer to a player
		if (photo.length!=0) {
			for (int y=0;y<tempArr.length;y++) {
				for (int x=0;x<tempArr[y].length;x++) {
					ymin=50;ymax=0;xmin=50;xmax=0;counter=0;
					//System.out.println(tempArr[y][x]+" "+team);
					if (tempArr[y][x]==team+'0') {
						tempArr[y][x] = 'f';
						check (y,x,tempArr,team);
					}
					if (counter >= nbox) {
						centerPoints [temp] = new Point (xmin+xmax+1,ymin+ymax+1);
						temp++;
					}
				}
			}
		}
		Point [] points = new Point [temp];
		System.arraycopy(centerPoints, 0, points, 0, temp);
		sortpoints(points);
		return points ;
	}
	
	public static void check (int y,int x,char[][] photo,int team) {
		if (y<ymin)ymin=y;
		if (y>ymax)ymax=y;
		if (x<xmin)xmin=x;
		if (x>xmax)xmax=x;
		counter++;
		if (x<photo[y].length-1 && photo[y][x+1]==team+'0') {
			photo[y][x+1] = 'f';
			check(y,x+1,photo,team);
		}
		if ( x>0 && photo[y][x-1]==team+'0') {
			photo[y][x-1] = 'f';
			check(y,x-1,photo,team);
		}
		if (y<photo.length-1 && photo[y+1][x]==team+'0') {
			photo[y+1][x] = 'f';
			check(y+1,x,photo,team);
		}
		if (y>0 && photo[y-1][x]==team+'0') {
			photo[y-1][x] = 'f';
			check(y-1,x,photo,team);
		}
	}
	public static void sortpoints (Point [] points) {
		Point temp ;
		if (points.length!=0) {
			for (int i = 0;i<points.length-1;i++) {
				for (int j=i+1;j<points.length;j++) {
					if (points[i].x>points[j].x) {
						temp = points[i];
						points[i] = points[j];
						points[j] = temp ;
					}else if (points[i].x==points[j].x) {
						if (points[i].y>points[j].y) {
							temp = points[i];
							points[i] = points[j];
							points[j] = temp ;
						}
					}
				}
			}
		}
	}
}
