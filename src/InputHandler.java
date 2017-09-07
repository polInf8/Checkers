import java.util.ArrayList;

public class InputHandler {
		int inputX;
		int inputY;
		int destinationX;
		int destinationY;
		String command;
		ArrayList<String> positions = new ArrayList<String>();
		boolean isInputValid = true;
		
	public int splitInput(String input) {
		int numberOfMoves = 1;
		String startPosition;
		String endPosition;
		String nextPosition;
		
		String[] inputParts = input.split("\\s");

		command = inputParts[0];
		startPosition = inputParts[2];
		endPosition = inputParts[4];
		positions.add(startPosition);
		positions.add(endPosition);	
		
		if(inputParts.length > 5) {
			for(int i = 6; i <= inputParts.length; i += 2) {
			numberOfMoves++;
			nextPosition = inputParts[i];
			positions.add(nextPosition);
		}
		}
		if((!command.equals("move") && !command.equals("jump")) || inputParts.length < 5) {
			isInputValid = false;
		}
		
		return numberOfMoves;
	}
	
	
	public void transformInput(String startPosition, String endPosition) {
		String inputXstring = startPosition.substring(0,1);
		String inputYstring = startPosition.substring(1, 2);
		String endXstring = endPosition.substring(0,1);
		String endYstring = endPosition.substring(1,2);
		
		inputX = convertX(inputXstring);
		inputY = convertY(inputYstring);
		destinationX = convertX(endXstring);
		destinationY = convertY(endYstring);
		
	}
	
	
	public int convertX(String x) {
		int returnableX;
		
		switch(x) {
		case "A":
			returnableX = 0;
			break;
		case "B":
			returnableX = 1;
			break;
		case "C":
			returnableX = 2;
			break;
		case "D":
			returnableX = 3;
			break;
		case "E":
			returnableX = 4;
			break;
		case "F": 
			returnableX = 5;
			break;
		case "G":
			returnableX = 6;
			break;
		case "H":
			returnableX = 7;
			break;
		default:
			returnableX = 9;	
		}
		
		return returnableX;
	}
	
	public int convertY(String y) {
		int returnableY;
		switch(y) {
		case "8":
			returnableY = 0;
			break;
		case "7":
			returnableY = 1;
			break;
		case "6":
			returnableY = 2;
			break;
		case "5":
			returnableY = 3;
			break;
		case "4":
			returnableY = 4;
			break;
		case "3": 
			returnableY = 5;
			break;
		case "2":
			returnableY = 6;
			break;
		case "1":
			returnableY = 7;
			break;
		default:
			returnableY = 9;
		}
		
		
		return returnableY;
	}
	
	
	
	
}
