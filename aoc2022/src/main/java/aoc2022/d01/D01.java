package aoc2022.d01;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D01 extends AocBase {
	
	
	public D01() {
		super("/D01-Input.txt");
	}

	public void doit() throws IOException {
		
		List<Integer> list = new LinkedList<>();
	
		String line = reader.readLine();

		int tmp = 0;
		while(true) {
			
			if (line == null) {
				break;
			}
			
			if (line.strip().isEmpty() == false) {
				tmp += Integer.parseInt(line);

			} else {
				list.add(tmp);
				tmp = 0;
			}
			line = reader.readLine();
		
		}

		reader.close();
		
		int size = list.size(), max = 0;
		
		for(int i = 0 ; i < size ; i++) {
			int current = list.get(i);
			if(current > max) {
				max = current;
			}
		}
		// Aufgabe 1
		System.out.println("Aufgabe 1:"); // 72070
		System.out.println(max);
		System.out.println(" ");
		
		// Aufgabe 2
		Collections.sort(list);
		System.out.println("Aufgabe 2:"); // 211805
		int sum = list.get(size - 1);
		sum += list.get(size - 2);
		sum += list.get(size - 3);
		System.out.println(sum);
			
	}
}
