
public class Launcher {

	public static void main(String [] args) {
		System.out.println("To make a move write for example: 'move from C3 to B4'");
		System.out.println("To jump write for example: ' jump from C3 to A5");
		System.out.println("If you want to jump over multiple pieces just at: 'to C5' to the command");
		
		Game game = new Game();
		game.startGame();
		
		
	}
	
	
}
