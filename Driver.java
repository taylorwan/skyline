import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Building> buildings = new ArrayList<Building>();
		
//		buildings.add( new Building( 0, 50, 10) );
//		buildings.add( new Building( 0, 40, 20) );
//		buildings.add( new Building( 0, 60, 10) );
		
//		buildings.add(new Building(60, 89, 100));
//		buildings.add(new Building(80, 94, 120));
//		buildings.add(new Building(240, 8, 250));
//		buildings.add(new Building(0, 75, 75));
		
//		buildings.add(new Building(1, 10, 2));
//		buildings.add(new Building(4, 12, 7));
//		buildings.add(new Building(2, 20, 5));
//		buildings.add(new Building(6, 15, 9));
		
		buildings.add( new Building( 50, 40, 70 ) );
		buildings.add( new Building( 25, 80, 40 ) );
		buildings.add( new Building( 15, 10, 75 ) );
		buildings.add( new Building( 5, 20, 60 ) );
		buildings.add( new Building( 0, 40, 10 ) );
		

		System.out.println( "Buildings:" + buildings );
		Skyline sky = new Skyline( buildings );
		System.out.println( "\nSkyline:" + sky.skyline );
	}
}
