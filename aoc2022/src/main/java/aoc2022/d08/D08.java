package aoc2022.d08;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D08 extends AocBase {

	
	public D08() {
		super("/D08-Input.txt");
		//super("/D08-Input-demo.txt");
		//super("/D08-Input-demo-2.txt");
	}

	// globale Liste
	List<List<Integer>> glist = new LinkedList<>();
	
	public void doit() throws IOException {
	
		String lineAsString = null;
		
		while ((lineAsString = reader.readLine()) != null) {
			char[] charArray = lineAsString.toCharArray();
			List<Integer> l = new LinkedList<Integer>();
			glist.add(l);
			for (char c : charArray) {
				Integer integer = Integer.valueOf(String.valueOf(c));
				l.add(integer);
				
			}
		}
		
		int edge = glist.size() * 2 + 2 * (glist.get(0).size() - 2);
		int sum = edge;

		for (int i = 1 ; i < glist.size() - 1 ; i++) {
			List<Integer> line = glist.get(i);
			for (int j = 1 ; j < line.size() - 1; j++) {
				
				// left
				boolean visibleLeftRight = visibleFromLeftOrRight(line, j);
				
				if (visibleLeftRight) {
					sum++;
					continue;
				}
				
				boolean visibleFromTopOrBottom = visibleFromTopOrBottom(i, j);
				
				if (visibleFromTopOrBottom) {
					sum++;
					continue;
				}
			}
		}
		
		// 1715 OK
		System.out.println(sum);
		
		// Aufgabe 2
		int result = 0;
		for (int i = 1 ; i < glist.size() - 1 ; i++) {
			List<Integer> line = glist.get(i);
			for (int j = 1 ; j < line.size() - 1 ; j++) {
				int left = calcViewDistanceLeft(line, j);
				int right = calcViewDistanceRight(line, j);
				int top = calcViewDistanceTop(i, j);
				int bottom = calcViewDistanceBottom(i, j);
				
				int tmpResult = left * right * top * bottom;
				if (tmpResult > result) {
					result = tmpResult;
				}
				
				// System.out.println("x: " + i + " y: " + j + " - " + " current: " + glist.get(i).get(j) + " - " + tmpResult);
				
			}
		}
		
		// 374400
		System.out.println(result);
		
	}
	
	private int calcViewDistanceBottom(int lineIndex, int column) {
		if (lineIndex == 0) {
			return 0;
		}
		int counter = 0;
		int current = glist.get(lineIndex).get(column);
		
		for (int x = lineIndex + 1; x < glist.size(); x++) {
			int tmp = glist.get(x).get(column);
			if (tmp < current) {
				counter ++;
			} else if (tmp >= current) {
				counter++;
				break;
			}
		}
		
		
		return counter;
	}
	
	private int calcViewDistanceTop(int lineIndex, int column) {
		if (lineIndex == 0) {
			return 0;
		}
		int counter = 0;
		int current = glist.get(lineIndex).get(column);
		
		for (int x = lineIndex - 1; x >= 0; x--) {
			int tmp = glist.get(x).get(column);
			if (tmp < current) {
				counter ++;
			} else if (tmp >= current) {
				counter++;
				break;
			}
		}
		
		
		return counter;
	}
		
	private int calcViewDistanceRight(List<Integer> line, int column) {
		if (column == line.size() - 1) {
			return 0;
		}
		
		int counter = 0;
		int current = line.get(column);
		
		for (int x = column + 1 ; x < line.size() ; x++) {
			int tmp = line.get(x);
			if (tmp < current) {
				counter ++;
			} else if (tmp >= current) {
				counter++;
				break;
			}
		}
		
		return counter;
	}
	
	private int calcViewDistanceLeft(List<Integer> line, int column) {
		if (column == 0) {
			return 0;
		}
		
		int counter = 0;
		int current = line.get(column);
		
		for (int x = column - 1 ; x >= 0 ; x--) {
			int tmp = line.get(x);
			if (tmp < current) {
				counter ++;
			} else if (tmp >= current) {
				counter++;
				break;
			}
		}
		
		return counter;
	}
	
	///////////////////////////////

	public boolean visibleFromLeftOrRight(List<Integer> line, int column) {
		
		int current = line.get(column);
		boolean visibleLeft = true;
		
		for (int x = 0 ; x < column ; x++) {
			if (line.get(x) >= current) {
				visibleLeft = false;
				break;
			}
		}
		
		if (visibleLeft) {
			return true;
		}
	
		boolean visibleRight = true;
		for (int x = column + 1; x < line.size(); x++) {
			Integer tmp = line.get(x);
			if (tmp >= current) {
				visibleRight = false;
				break;
			}
		}
		
		return visibleRight;
	}
	
	public boolean visibleFromTopOrBottom(int line, int column) {
		
		int current = glist.get(line).get(column);
		
		// oben
		boolean visibleFromTop = true;
		for (int i = 0; i < line ; i++) {
			Integer tmp = glist.get(i).get(column);
			if (tmp >= current) {
				visibleFromTop = false;
				break;
			}
		}
		
		if (visibleFromTop) {
			return true;
		}
		

		boolean visibleFromBottom = true;
		
		// unten
		for (int i = line + 1; i < glist.size(); i++) {
			Integer tmp = glist.get(i).get(column);
			if (tmp >= current) {
				visibleFromBottom = false;
				break;
			}
		}
		
		return visibleFromBottom;
	}
	
}
