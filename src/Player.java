import java.util.ArrayList;


public class Player {
	int numberOfPieces;
	boolean black = true;
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	ArrayList<Queen> queens = new ArrayList<Queen>();
	
	
	public Player(boolean isBlack) {
		if(!isBlack) {
			this.black = false;
		}else {
			this.black = true;
		}
	}
	
	public void setUpPieces() {
		if(black) {
			pieces.add(new Piece(0, 1, true));
			pieces.add(new Piece(0, 3, true));
			pieces.add(new Piece(0, 5, true));
			pieces.add(new Piece(0, 7, true));
			pieces.add(new Piece(1, 0, true));
			pieces.add(new Piece(1, 2, true));
			pieces.add(new Piece(1, 4, true));
			pieces.add(new Piece(1, 6, true));
			pieces.add(new Piece(2, 1, true));
			pieces.add(new Piece(2, 3, true));
			pieces.add(new Piece(2, 5, true));
			pieces.add(new Piece(2, 7, true));
			
		} else if(!black) {
			pieces.add(new Piece(7, 0, false));
			pieces.add(new Piece(7, 2, false));
			pieces.add(new Piece(7, 4, false));
			pieces.add(new Piece(7, 6, false));
			pieces.add(new Piece(6, 1, false));
			pieces.add(new Piece(6, 3, false));
			pieces.add(new Piece(6, 5, false));
			pieces.add(new Piece(6, 7, false));
			pieces.add(new Piece(5, 0, false));
			pieces.add(new Piece(5, 2, false));
			pieces.add(new Piece(5, 4, false));
			pieces.add(new Piece(5, 6, false));
		}
	
	}
	
	public boolean movePiece(int fromX, int fromY, int  toX, int toY) {
		boolean hasMovedPiece = false;
		
		for(int k = 0; k <pieces.size(); k++) {
			if(pieces.get(k).x == fromX && pieces.get(k).y == fromY) {
				//System.out.println("We got it on: "+k);
				pieces.get(k).x = toX;
				pieces.get(k).y = toY;	
				hasMovedPiece = true;
			}
			for(int j = 0; j <queens.size(); j++) {
				if(queens.get(j).x == fromX && queens.get(j).y == fromY) {
					//System.out.println("We got it on: "+k);
					queens.get(j).x = toX;
					queens.get(j).y = toY;	
					hasMovedPiece = true;
				}	
			}
		}
		return hasMovedPiece;	
	}
	
	public void killPiece(int x, int y) {

		for(int o = 0; o <pieces.size(); o++) {
			if(pieces.get(o).x == x && pieces.get(o).y == y) {
				//System.out.println("We got it on: "+k);
				pieces.remove(o);
			}
		}
	}
	
	public boolean isInRadiusforMove(int fromX, int fromY, int toX, int toY) {
		boolean inRange = false;
		
		if(Math.abs(toX - fromX)== 1 && Math.abs(toY - fromY) == 1 ) {
			inRange = true;
		}
		for(int h = 0; h < queens.size(); h++) {
			if(queens.get(h).x == fromX && queens.get(h).y == fromY) {
				if(Math.abs(toX-fromX) == Math.abs(toY-fromY)) {
					inRange = true;
				}
			}
		}
			
		return inRange;
	}
	
	
	public void makeQueen(int x, int y) {
		Queen queen = new Queen(x, y, false);
		queens.add(queen);
		System.out.println("Queen has been made");
		
	}
	
	
}
