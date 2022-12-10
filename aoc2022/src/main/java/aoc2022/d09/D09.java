package aoc2022.d09;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D09 extends AocBase {

	List<Instruction> glist = new LinkedList<>();
	List<String> visitedIndexList = new LinkedList<>();
	
	int xh = 0, yh = 0; // head x/y
	int xt = 0, yt = 0; // tail x/y
	
	public D09() {
		//super("/D09-Input.txt");
		super("/D09-Input.txt");
	}

	public void doit() throws IOException {

		String line = null;
		
		int count = 0;
		
		while ((line = reader.readLine()) != null) {
			glist.add(new Instruction(line));
			count++;
		}
		
		// 2000 Zeilen, 2000 Anweisungen
		//System.out.println(count + " " + glist.size());
		
		// Startposition: 0 0 mitzählen
		visitedIndexList.add(xt + " " + yt);
		
		for (Iterator iterator = glist.iterator(); iterator.hasNext();) {
			Instruction instruction = (Instruction) iterator.next();
			
			switch (instruction.direction) {
			case D:
				for (int i = 0 ; i < instruction.amount ; i++) {
					xh++;
					moveTailD();
					addTailPosition(xt, yt);
				}
				break;
			case U:
				for (int i = 0 ; i < instruction.amount ; i++) {
					xh--;
					moveTailU();
					addTailPosition(xt, yt);
				}
				break;
			case L:
				for (int i = 0 ; i < instruction.amount ; i++) {
					yh--;
					moveTailL();
					addTailPosition(xt, yt);
				}
				break;
			case R:
				for (int i = 0 ; i < instruction.amount ; i++) {
					yh++;
					moveTailR();
					addTailPosition(xt, yt);
				}
				break;

			default:
				break;
			}

			// T bewegen?

		}
		
		
		// OK 5710
		System.out.println(visitedIndexList.size());
		
	}
	
	
	private void moveTailR() {
		if (xh == xt) { // head und tail nebeneinander
			if (Math.abs(yt - yh) > 1 ) {
				yt++;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(yt - yh) > 1 ) {
				yt++;
				xt = xh;
			}
			
		}
	}
	
	// Bewegung links
	private void moveTailL() {
		if (xh == xt) { // head und tail nebeneinander
			if (Math.abs(yt - yh) > 1 ) {
				yt--;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(yt - yh) > 1 ) {
				yt--;
				xt = xh;
			}
			
		}
	}
	
	// Bewegung runter
	private void moveTailD() {
		if (yh == yt) { // head und tail untereinander
			if (Math.abs(xt - xh) > 1 ) {
				xt++;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				xt++;
				yt = yh;
			}
			
		}
	}
	
	// Bewegung hoch
	private void moveTailU() {
		if (yh == yt) { // head und tail untereinander
			if (Math.abs(xt - xh) > 1 ) {
				xt--;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				xt--;
				yt = yh;
			}
			
		}
	}
	
	
	/*
	private void moveTailR() {
		if (xh == xt) { // head und tail nebeneinander
			if (Math.abs(yt - yh) > 1 ) {
				yt++;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				yt++;
				xt = xh;
			}
			
		}
	}
	
	// Bewegung links
	private void moveTailL() {
		if (xh == xt) { // head und tail untereinander
			if (Math.abs(yt - yh) > 1 ) {
				yt--;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				yt--;
				xt = xh;
			}
			
		}
	}
	
	// Bewegung runter
	private void moveTailD() {
		if (yh == yt) { // head und tail untereinander
			if (Math.abs(xt - xh) > 1 ) {
				xt++;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				xt++;
				yt = yh;
			}
			
		}
	}
	
	// Bewegung hoch
	private void moveTailU() {
		if (yh == yt) { // head und tail untereinander
			if (Math.abs(xt - xh) > 1 ) {
				xt--;
			}
		} else { // vorher diagonal zueinander
			if (Math.abs(xt - xh) > 1 ) {
				xt--;
				yt = yh;
			}
			
		}
	}
	*/
	private void addTailPosition(int x, int y) {
		String pos = x + " " + y;
		if (visitedIndexList.contains(pos) == false) {
			System.out.println(pos);
			visitedIndexList.add(pos);
		}
	}
	
}
