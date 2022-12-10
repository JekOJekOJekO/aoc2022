package aoc2022.d09;

public class Instruction {
	
	Direction direction;
	int amount;
	
	public Instruction(String input) {
		String[] split = input.split(" ");
		switch (split[0]) {
		case "R":
			direction = Direction.R;
			break;
		case "L":
			direction = Direction.L;
			break;
		case "U":
			direction = Direction.U;
			break;
		case "D":
			direction = Direction.D;
			break;

		default:
			break;
		}
		
		amount = Integer.valueOf(split[1]);
		
	}
	
}
