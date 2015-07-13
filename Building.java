public class Building {

	public int left;
	public int height;
	public int right;

	public Building( int left, int height, int right ) {
		this.left = left;
		this.height = height;
		this.right = right;
	}
	
	public String toString() {
		return "[ " + left + ", " + height + ", " + right + " ]";
	}
	
}
