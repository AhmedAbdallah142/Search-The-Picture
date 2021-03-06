package eg.edu.alexu.csd.datastructure.iceHockey.csx22;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class TestingTheProgram {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		IceHockey h = new IceHockey();
		//------------------------------------------------------------------------------------------------\\
					//Random test
		String [] photo1 ={
				"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"
				};
		Point [] centerPoints1 = {new Point (1,17),new Point (3,3),new Point (3,10),new Point (3,25),new Point (5,21),new Point (8,17),
				new Point (9,2),new Point (10,9),new Point (12,23),new Point (17,16),new Point (18,3),new Point (18,11),new Point (18,28),
				new Point (22,20),new Point (23,26),new Point (24,15),new Point (27,2),new Point (28,26),new Point (29,16)};
					
		assertEquals(centerPoints1,h.findPlayers(photo1,8, 9));
		//------------------------------------------------------------------------------------------------\\
					//Random test
		String []photo2 = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		Point [] centerPoints2 = {new Point (4,5),new Point (13,9),new Point (14,2)};
					
		assertEquals(centerPoints2,h.findPlayers(photo2,3,16));
		//------------------------------------------------------------------------------------------------\\
					//Random test
		String [] photo3 ={
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		Point [] centerPoints3 = {new Point (3,8),new Point (4,16),new Point (5,4),new Point (16,3),new Point (16,17),new Point (17,9)};					
		assertEquals(centerPoints3,h.findPlayers(photo3,4,16));
		//------------------------------------------------------------------------------------------------\\
					//testing if the two player have the same center point
		String [] photo4 ={
				"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"
				};
		Point [] centerPoints4 = {new Point (5,5),new Point (5,5)};
		assertEquals(centerPoints4,h.findPlayers(photo4,1,3));
		//------------------------------------------------------------------------------------------------\\
					// testing image with wrong required players
		String [] photo5 ={     
				"11111",
				"11111",
				"11111"
				};
		Point [] centerPoints5 = {};
		assertEquals(centerPoints5,h.findPlayers(photo5,3,1));
		//------------------------------------------------------------------------------------------------\\
					// testing image with area smaller than required
		String [] photo6 ={  
				"11111",
				"11111",
				"11111"
				};
		Point [] centerPoints6 = {};
		assertEquals(centerPoints6,h.findPlayers(photo6,1,100));//smallest area required in image = 100
		//------------------------------------------------------------------------------------------------\\
					// testing a null/empty image  
		String [] photo7 ={ 
				"11111",
				"11111",
				"11111"
				};
		Point [] centerPoints7 = { new Point (5,3)};
		assertEquals(centerPoints7,h.findPlayers(photo7,1,4));
		String [] photo8 ={};            
		Point [] centerPoints8 = {};
		
		try {
			assertEquals(centerPoints8,h.findPlayers(photo8,1,4));
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
		//------------------------------------------------------------------------------------------------\\
					//testing if the user entered a wrong threshold 
		String [] photo9 ={
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		Point [] centerPoints9 = {};
		try {
			assertEquals(centerPoints9,h.findPlayers(photo9,4,-16));
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
		//------------------------------------------------------------------------------------------------\\
		//testing if the user entered a wrong team number 
		String [] photo10 ={    
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		Point [] centerPoints10 = {};
		try {
			assertEquals(centerPoints10,h.findPlayers(photo10,14,16));
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
	}

}
