


public class Board {
	
	Spot[][] spots;
	int pieceToKillX;
	int pieceToKillY;
	
	
	public void createBoard() {
		spots = new Spot[8][8];
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				spots[i][j] = new Spot(i, j);
			}
		}
	
	}
	
	public void printBoard() {
		for(int y = 0; y < 8; y++) {
			
			switch(y) {
			case 0:
				System.out.print(8 +" |");
				break;
			case 1:
				System.out.print(7+" |");
				break;
			case 2:
				System.out.print(6+" |");
				break;
			case 3:
				System.out.print(5+" |");
				break;
			case 4:
				System.out.print(4+" |");
				break;
			case 5:
				System.out.print(3+" |");
				break;
			case 6:
				System.out.print(2+" |");
				break;
			case 7:
				System.out.print(1+" |");
				break;

			}
			
			for(int z = 0; z < 8; z++) {
				char output =' ';
				if(spots[y][z].isOccupied) {
					output = spots[y][z].pieceColor;
					
				}else {
					output = '_';
				}
				System.out.print(output + "|");
			}
			System.out.println();
		}
		System.out.println("    A B C D E F G H");
	}
	
	public boolean freeSpot(int x, int y) {
		boolean emptyBlackSpot = false;
		
			if(spots[x][y].blackSpot && !spots[x][y].isOccupied) {
				emptyBlackSpot = true;
			
			}
		return emptyBlackSpot;
	}
	
	
	public boolean canJump(Player player, int fromX, int fromY, int toX, int toY) {
		boolean jumpable = false;
		pieceToKillX  = (toX + fromX)/2 ;
		pieceToKillY = (toY + fromY)/2;
		//for normal pieces
		if(!spots[toX][toY].isOccupied) {
			if(player.black) {
				if(spots[pieceToKillX][pieceToKillY].pieceColor == 'w') {
					jumpable = true;
				}
			}else if(!player.black) {
				if(spots[pieceToKillX][pieceToKillY].pieceColor == 'b') {
					jumpable = true;
				}
			}
		}
		
		//for queens
		
		
			
		return jumpable;
	}
	
	public void clearSpot(int x, int y) {
		spots[x][y].isOccupied = false;
		
	}
	
	public boolean queenCanMove(int fromX, int fromY, int toX, int toY) {
		int fieldsBetween = Math.abs(fromX - toX) - 1;
		int spaceInBetweenX = 0;
		int spaceInBetweenY = 0;
		boolean yesSheCan = true;
		
		for(int i = 0; i <= fieldsBetween; i++) {
			if(toX > fromX) { 
				spaceInBetweenX = toX - 1 - i;
				}else {
					spaceInBetweenX = toX + 1 + i;
				}
				
				if(toY > fromY) { 
					spaceInBetweenY = toY - 1 - 1;
				}else {
					spaceInBetweenY = toY + 1 + 1;
				}
			
			
		if(fieldsBetween > 0 && spots[spaceInBetweenX][spaceInBetweenY].isOccupied == true) {
			yesSheCan = false;
		}
		}
		
		
		return yesSheCan;
	}
	
	public boolean queenCanJump(Player player, int fromX, int fromY, int toX, int toY) {
		boolean yesSheCan = false;
		int fieldsBetween = Math.abs(fromX - toX) - 2;
		if(toX > fromX) { 
		pieceToKillX = toX - 1;
		}else {
		pieceToKillX = toX + 1;
		}
		
		if(toY > fromY) { 
			pieceToKillY = toY - 1;
		}else {
			pieceToKillY = toY + 1;
		}
			
		
		int Xbetween = 0;
		int Ybetween = 0;
		
		if(player.black && spots[pieceToKillX][pieceToKillY].pieceColor == 'w' ) {
			yesSheCan = true;
		}else if(!player.black && spots[pieceToKillX][pieceToKillY].pieceColor == 'b') {
			yesSheCan = true;
		}
		

	for(int i = 0; i < fieldsBetween; i++) {	
	
	if(toX > fromX) { 
		Xbetween = toX - 2 - i;
		}else {
		Xbetween = toX + 2 + i;
		}
		
		if(toY > fromY) { 
			Ybetween = toY - 2 - i;
		}else {
			Ybetween = toY + 2 + i;
		}
	
	
	if(!freeSpot(Xbetween, Ybetween)) {
		yesSheCan = false;
	}
	}
	
	if(!freeSpot(toX, toY)) {
		yesSheCan = false;
	}
			
		return yesSheCan;
	}
	
}
