package eg.edu.alexu.csd.datastructure.iceHockey.csx22;

import java.awt.Point;

public class MainAdditinalClass {

	public static void main(String[] args) {
		IceHockey h =new IceHockey();
		String [] photo ={ };
		Point [] centerPoints = h.findPlayers(photo,1,2);
		System.out.print("{");
		for (int i=0;i<centerPoints.length;i++) {
			System.out.print("("+centerPoints[i].x+","+centerPoints[i].y+")");
			if (i!=centerPoints.length-1) {
				System.out.print(",");
			}
		}
		System.out.print("}");
	}

}
