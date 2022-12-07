package aoc2022.d04;

import java.io.IOException;

import aoc2022.AocBase;

public class D04 extends AocBase {
	public D04() {
		super("/D04-Input.txt");
	}

	public void doit() throws IOException {

		String line = null;

		int countTeask1 = 0;
		int countTeask2 = 0;
		
		while ((line = reader.readLine()) != null) {
			String[] split = line.split(",");
			
			if (fullyContains(split[0], split[1]) || fullyContains(split[1], split[0])) {
				countTeask1++;
			}
			
			if (partialContains(split[0], split[1])) {
				countTeask2++;
			}
		}
		
		System.out.println(countTeask1);	// richtig 547
		System.out.println(countTeask2);	// richtig 843	
			
	}

	private static boolean partialContains(String s1, String s2) {
		String[] split1 = s1.split("-");
		String[] split2 = s2.split("-");

		int x1 = Integer.valueOf(split1[0]);
		int x2 = Integer.valueOf(split1[1]);
		int y1 = Integer.valueOf(split2[0]);
		int y2 = Integer.valueOf(split2[1]);
		
		if (fullyContains(s1, s2) || fullyContains(s2, s1)) {
			return true;
		}
		
		// "x1-x2","y1-y2"
		
		// S1
		if (y1 < x1 && y2 >= x1) {
			return true;
		}
		
		// S2
		if (y2 > x2 && y1 <= x2) {
			return true;
		}
		
		return false;
	}

	private static boolean fullyContains(String s1, String s2) {
		// "x1-x2","y1-y2"
		String[] split1 = s1.split("-");
		String[] split2 = s2.split("-");

		int x1 = Integer.valueOf(split1[0]);
		int x2 = Integer.valueOf(split1[1]);
		int y1 = Integer.valueOf(split2[0]);
		int y2 = Integer.valueOf(split2[1]);
		
		if (y1 < x1) {
			return false;
		}
		
		if (y2 > x2) {
			return false;
		}
		
		return true;
	}

}
