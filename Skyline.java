import java.util.*;

public class Skyline {

	public ArrayList<Point> skyline;
	
	// constructor
	public Skyline( ArrayList<Building> b ) {
		skyline = makeSkyline( b );
	}
	
	// recursive function for dividing and conquering
	// splits input into halves before merging them at the end
	public ArrayList<Point> makeSkyline( ArrayList<Building> b ) {
		int length = b.size();

		// base case: return the node as two points
		// point 1 is where the building begins and its height
		// point 2 is where the building ends, with height 0
		if ( length == 1 ) {
			ArrayList<Point> result = new ArrayList<Point>();
			result.add( new Point ( b.get(0).left, b.get(0).height ) );
			result.add( new Point ( b.get(0).right, 0 ) );
			return result;
		}
		
		// copying input over to two ArrayLists
		ArrayList<Building> first = new ArrayList<Building>();
		ArrayList<Building> second = new ArrayList<Building>();
		
		int mid = length/2;
		int i = 0;

		for ( ; i < mid; i++ ) {
			first.add( b.get(i) );
		}
		for ( int j = mid ; j < length; j++ ) {
			second.add( b.get( j) );
		}
		
		// merge the two split ArrayLists
		return merge( makeSkyline( first ) , makeSkyline( second ) );
	}
	
	
	// merge skylines
	public ArrayList<Point> merge( ArrayList<Point> a, ArrayList<Point> b ) {
		
		int currentHeightA = 0;
		int currentHeightB = 0;
		int counterA = 0;
		int counterB = 0;
		
		Point currentA;
		Point currentB;
		
		ArrayList<Point> result = new ArrayList<Point>();
		
		while ( counterA < a.size() && counterB < b.size() ) {
			currentA = a.get( counterA );
			currentB = b.get( counterB );
			
			// if x values are equal
			if ( currentA.x == currentB.x ) {
				
				// add the the taller building
				int tallerHeight = currentA.y > currentB.y ? currentA.y : currentB.y;
				result.add( new Point( currentA.x, tallerHeight ) );
				
				//update values
				
				currentHeightA = currentA.y;
				currentHeightB = currentB.y;
				
				counterA++;
				counterB++;
			}
			
			// if x values unequal
			// take smaller value
			else if ( currentA.x < currentB.x ) {
				
				// case 1: the current height is greater than the last height from the other list
				// case 2: we're at the end of our list, but the other list hasn't been started yet
				if ( currentA.y > currentHeightB ||
					 ( counterA == ( a.size()-1 ) && counterB == 0 ) ) {
					result.add( currentA );
				}
				// case 3: the current height is less
				// don't duplicate if the y value is the same as the last value added
				else if ( currentA.y < currentHeightB &&
					currentHeightB != result.get( result.size() - 1 ).y ) {
					result.add( new Point( currentA.x, currentHeightB ));
				}
				// update values
				currentHeightA = currentA.y;
				counterA++;
			}
			
			// see above
			else {
				if ( currentB.y > currentHeightA ||
					( counterB == ( b.size()-1 ) && counterA == 0 ) ) {
					result.add( currentB );
				}
				else if ( currentB.y < currentHeightB && 
						currentHeightA != result.get( result.size() - 1).y ) {
					result.add( new Point( currentB.x, currentHeightA ));
				}
				currentHeightB = currentB.y;
				counterB++;
			}
		}
		
		// add remaining items on list
		while ( counterA < a.size() ) {
			result.add( a.get( counterA ) );
			counterA++;
		}
		while ( counterB < b.size() ) {
			result.add( b.get( counterB ) );
			counterB++;
		}
		
		// return
		return result;
	}
	
}