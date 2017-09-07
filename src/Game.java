import java.util.Scanner;


public class Game {
	
	Scanner scanner = new Scanner(System.in);
	Player black;
	Player white;
	Board board;
	InputHandler inputHandler;
	int startX, startY, fromX, fromY, toX, toY;
	
	public void startGame() {
		board = new Board();
		board.createBoard();
		black = new Player(true);
		black.setUpPieces();
		white = new Player(false);
		white.setUpPieces();
		
		updateBoard();
		board.printBoard();
		
		while(true) {
		System.out.println("Make a move white");
		askForMove(white, black);
		board.printBoard();
			if(black.pieces.size() == 0 && black.pieces.size() == 0) {
			System.out.println("White has won!");
			break;
		}
		
		System.out.println("Make a move black");
		askForMove(black, white);
		board.printBoard();
		
		if(white.pieces.size() == 0 && white.pieces.size() == 0) {
			System.out.println("Black has won!");
			break;
		}
	
		
		}

	}
	
	public void askForMove(Player player, Player player2) {
		inputHandler = new InputHandler();	
		
		String input = scanner.nextLine();
		int numberOfMoves = inputHandler.splitInput(input);
		
		if(inputHandler.isInputValid) {
			for(int i = 0; i < numberOfMoves; i++) {
				inputHandler.transformInput(inputHandler.positions.get(i), inputHandler.positions.get(i + 1));
				if(!handleCommand(player, player2)) {
					System.out.println("Bad Command try another one!");
					askForMove(player,player2);
					break;
					
				}
				updateBoard();
			}
		}else {
			System.out.println("Can not execute move, try another one!");
			askForMove(player, player2);
		}
	}
	
	public boolean handleCommand(Player player, Player player2) {
		String command =  inputHandler.command;
		fromY = inputHandler.inputX;
		fromX = inputHandler.inputY;
		toY = inputHandler.destinationX;
		toX = inputHandler.destinationY;
		startX = fromX;
		startY = fromY;
		boolean validCommand = true;
		
		
		if(command.equals("move")) {
			//move commands for pieces and queens
			if(board.freeSpot(toX, toY) && player.isInRadiusforMove(fromX, fromY, toX, toY) && board.queenCanMove(fromX, fromY, toX, toY)) {
				validCommand = player.movePiece(fromX, fromY, toX, toY);
				board.clearSpot(fromX, fromY);
				if(player == white && toX == 0 && board.spots[fromX][fromY].pieceColor != 'W') {
					player.killPiece(toX, toY);
					player.makeQueen(toX, toY);
				}
				if(player == black && toX == 7 && board.spots[fromX][fromY].pieceColor != 'B') {
					player.killPiece(toX, toY);
					player.makeQueen(toX, toY);
				}
		}else {
			validCommand = false;
		}
		}else if(command.equals("jump")) {
			//for normal pieces
			if(board.spots[fromX][fromY].pieceColor == 'b' || board.spots[fromX][fromY].pieceColor == 'w') {
			if(board.freeSpot(toX, toY) && board.canJump(player,  fromX, fromY, toX, toY) ) {
				
				player2.killPiece(board.pieceToKillX, board.pieceToKillY);
				player.movePiece(fromX, fromY, toX, toY);
				board.clearSpot(fromX,fromY);
				board.clearSpot(board.pieceToKillX, board.pieceToKillY);
				
				if(player == white && toX == 0) {
					player.killPiece(toX, toY);
					player.makeQueen(toX, toY);
				}
				if(player == black && toX == 7) {
					player.killPiece(toX, toY);
					player.makeQueen(toX, toY);
				}
				
			}else {
				validCommand = false;
			}
			}
			//for queens
			if(board.spots[fromX][fromY].pieceColor == 'B' || board.spots[fromX][fromY].pieceColor == 'W') {
				if(board.freeSpot(toX, toY) && board.queenCanJump(player, fromX, fromY, toX, toY)) {
					player2.killPiece(board.pieceToKillX, board.pieceToKillY);
					player.movePiece(fromX, fromY, toX, toY);
					board.clearSpot(fromX, fromY);
					board.clearSpot(board.pieceToKillX, board.pieceToKillY);
						
				}else {
					validCommand = false;
				}
						
			}
		}
		

			return validCommand;
	}
	
	public void updateBoard() {
		for(int i = 0; i < black.pieces.size(); i++) {
			int x = black.pieces.get(i).x;
			int y = black.pieces.get(i).y;
			board.spots[x][y].x = x;
			board.spots[x][y].y = y;
			board.spots[x][y].occupySpot('b');	
		}
		for(int j = 0; j < white.pieces.size(); j++) {
			int x = white.pieces.get(j).x;
			int y = white.pieces.get(j).y;
			board.spots[x][y].x = x;
			board.spots[x][y].y = y;
			board.spots[x][y].occupySpot('w');	
		}
		for(int k = 0; k < white.queens.size(); k++) {
			int x = white.queens.get(k).x;
			int y = white.queens.get(k).y;
			board.spots[x][y].x = x;
			board.spots[x][y].y = y;
			board.spots[x][y].occupySpot('W');
		}
		for(int l = 0; l < black.queens.size(); l++) {
			int x = black.queens.get(l).x;
			int y = black.queens.get(l).y;
			board.spots[x][y].x = x;
			board.spots[x][y].y = y;
			board.spots[x][y].occupySpot('B');
			
		}
		
	}
	
		
}
