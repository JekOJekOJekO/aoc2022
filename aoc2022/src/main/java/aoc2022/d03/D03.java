package aoc2022.d03;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D03 extends AocBase {
	
	public D03() {
		super("/D03-Input.txt");
	}

	public void doit() throws IOException {
		List<String> a2List = new LinkedList<>();
		
		String line = null;
		
		int sum = 0;
		while ((line = reader.readLine()) != null) {
			a2List.add(line);
			line = line.strip();
			int lineHalfindex = line.length() / 2;

			String h1 = line.substring(0, lineHalfindex);
			String h2 = line.substring(lineHalfindex);

			char[] h1Arr = h1.toCharArray();
			char[] h2Arr = h2.toCharArray();
			
			int x = getInt(h1Arr, h2Arr);
			if (x > 0) {
				sum += x;
			}
		}
		System.out.println(sum);
		
		// richtig: 7980
		
		// Aufgabe 2
		
		int sum2 = 0;
		
		for(int i = 0 ; i < 300 ; ) {
			char[] line1 = a2List.get(i++).toCharArray();
			String line2 = a2List.get(i++);
			String line3 = a2List.get(i++);
			
			for (char c : line1) {
				if (line2.contains(String.valueOf(c)) && line3.contains(String.valueOf(c))) {
					int x = (int)c;
					if (x < 97) {
						x -= 38;
					} else {
						x -= 96;
					}
					sum2 += x;
					break;
				}
			}
			
			
		}
		
		System.out.println(sum2);	// 2881 
	}
	
	
	public static int getInt(char[] h1Arr, char[] h2Arr) {
		for (char c : h1Arr) {
			for (char d : h2Arr) {
				if (c == d) {
					// gefunden
					int x = (int)c;
					
					if (x < 97) {
						x -= 38;
					} else {
						x -= 96;
					}
					
					return x;
				}
			}
		}
		
		return -1;
	}
	
}
