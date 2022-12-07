package aoc2022.d02;

import java.io.IOException;

import aoc2022.AocBase;

public class D02 extends AocBase {
	public D02() {
		super("/D02-Input.txt");
	}

	public void doit() throws IOException {
		/*
		 * A, X for Rock
		 * B, Y for Paper 
		 * C, Z for Scissors
		 * 
		 * Rock 	+1
		 * Paper 	+2
		 * Scissors +3
		 * 
		 * Lost		+0
		 * Win		+6
		 * Draw		+3
		 * 
		 * X -> lose
		 * Y -> draw
		 * Z -> win
		 * 
		 */
		
		try {
			String line = null;

			int task1 = 0, task2 = 0;
			
			
			while ((line = reader.readLine()) != null) {
				
				line = line.strip();
				
				if ("A X".equals(line)) {
					task1 += 1 + 3; // Rock, Draw
					task2 += 3 + 0; // Scissors, Lose
				} else
				if ("A Y".equals(line)) {
					task1 += 2 + 6; // Paper, Win
					task2 += 1 + 3; // Rock, Draw
				} else			
				if ("A Z".equals(line)) {
					task1 += 3 + 0; // Scissors, Lose
					task2 += 2 + 6; // Paper, Win
				} else
					
				if ("B Y".equals(line)) {
					task1 += 2 + 3; // Paper, Draw
					task2 += 2 + 3; // Paper, Draw
				} else						
				if ("B X".equals(line)) {
					task1 += 1 + 0; // Rock, Lose
					task2 += 1 + 0; // Rock, Lose
				} else	
				if ("B Z".equals(line)) {
					task1 += 3 + 6; // Scissors, Win
					task2 += 3 + 6; // Scissors, Win
				} else
					
				if ("C Z".equals(line)) {
					task1 += 3 + 3; // Scissors, Draw
					task2 += 1 + 6; // Rock, Win
				} else
				if ("C X".equals(line)) {
					task1 += 1 + 6; // Rock, Win
					task2 += 2 + 0; // Scissors, Lose
				} else					
				if ("C Y".equals(line)) {
					task1 += 2 + 0; // Scissors, Lose
					task2 += 3 + 3; // Scissors, Draw
				} else {
					System.out.println("!!!!!!!!!!!!" + line);
				}
				
			}
			
			System.out.println(task1); // 11386
			System.out.println(task2); // 13600
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
