
public class Spot {
	int x;
	int y;
	Piece piece;
	boolean blackSpot;
	boolean isOccupied = false;
	char pieceColor;
	
	public Spot(int x, int y) {
		piece= null;
		this.x = x;
		this.y = y;
		
		if((x + y) % 2 == 0) {
			blackSpot = false;
		}else {
			blackSpot = true;
		}
	}
	
	
	public void occupySpot(char type) {
		isOccupied = true;
		pieceColor = type;
	}
	
	
	
	
}
