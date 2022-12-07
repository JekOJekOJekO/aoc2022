package aoc2022.d06;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D06 extends AocBase {

	public D06() {
		super("/D06-Input.txt");
	}

	public void doit() throws IOException {

		String line = reader.readLine();

		char[] arr = line.toCharArray();

		for (int i = 0; i < arr.length - 3; i++) {
			if (unique(arr[i], arr[i + 1], arr[i + 2], arr[i + 3])) {
				System.out.println(i + 4);
				// korrekt 1640
				break;
			}
		}

		for (int i = 0; i < arr.length - 13; i++) {
			List<Character> list = new LinkedList<Character>();
			for (int j = 0; j < 14; j++) {
				Character c = arr[i + j];
				if (list.contains(c) == false) {
					list.add(c);
				}
			}

			if (list.size() == 14) {
				System.out.println(i + 14);
				// korrekt 3613
				break;
			}
		}

	}

	public static boolean unique(Character c1, Character c2, Character c3, Character c4) {
		if (c1 == c2 || c1 == c3 || c1 == c4 || c2 == c3 || c2 == c4 || c3 == c4) {
			return false;
		}
		return true;
	}

}
