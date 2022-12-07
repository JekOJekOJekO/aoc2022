package aoc2022.d05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import aoc2022.AocBase;

public class D05_2 extends AocBase {

	public D05_2() {
		super("/D05-Input.txt");
	}


	public void doit() throws IOException {

		List<List<Character>> list = new ArrayList<>(10);
		
		List<Character> list_0 = new LinkedList<>();
		
		List<Character> list_1 = new LinkedList<>();
		list_1.add('P');
		list_1.add('F');
		list_1.add('M');
		list_1.add('Q');
		list_1.add('W');
		list_1.add('G');
		list_1.add('R');
		list_1.add('T');

		List<Character> list_2 = new LinkedList<>();
		list_2.add('H');
		list_2.add('F');
		list_2.add('R');

		List<Character> list_3 = new LinkedList<>();
		list_3.add('P');
		list_3.add('Z');
		list_3.add('R');
		list_3.add('V');
		list_3.add('G');
		list_3.add('H');
		list_3.add('S');
		list_3.add('D');

		List<Character> list_4 = new LinkedList<>();
		list_4.add('Q');
		list_4.add('H');
		list_4.add('P');
		list_4.add('P');
		list_4.add('F');
		list_4.add('W');
		list_4.add('G');

		List<Character> list_5 = new LinkedList<>();
		list_5.add('P');
		list_5.add('S');
		list_5.add('M');
		list_5.add('J');
		list_5.add('H');		

		List<Character> list_6 = new LinkedList<>();
		list_6.add('M');
		list_6.add('Z');
		list_6.add('Z');
		list_6.add('H');
		list_6.add('S');
		list_6.add('R');
		list_6.add('P');
		list_6.add('L');		

		List<Character> list_7 = new LinkedList<>();
		list_7.add('P');
		list_7.add('T');
		list_7.add('H');
		list_7.add('N');
		list_7.add('M');
		list_7.add('L');	

		List<Character> list_8 = new LinkedList<>();
		list_8.add('F');
		list_8.add('D');
		list_8.add('Q');
		list_8.add('R');

		List<Character> list_9 = new LinkedList<>();
		list_9.add('D');
		list_9.add('S');
		list_9.add('C');
		list_9.add('N');
		list_9.add('L');
		list_9.add('P');
		list_9.add('H');
		

		list.add(list_0);
		list.add(list_1);
		list.add(list_2);
		list.add(list_3);
		list.add(list_4);
		list.add(list_5);
		list.add(list_6);
		list.add(list_7);
		list.add(list_8);
		list.add(list_9);
		
		for (int i = 0; i < 10; i++) {
			reader.readLine();
		}

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] split = line.split(" ");

			int count = Integer.valueOf(split[1]);
			int from = Integer.valueOf(split[3]);
			int to = Integer.valueOf(split[5]);
			reorg(count, from, to, list);
			
		}
		
		
		String result = "";
		
		for (int i = 1; i < 10; i++) {
			List<Character> list2 = list.get(i);
			result += list2.get(list2.size() - 1);
			
		}
		System.out.println(result); // richtig: TPGVQPFDH
		
	}

	
	public static void reorg(int count, int from, int to, List<List<Character>> list) {
		List<Character> fromList = list.get(from);
		List<Character> toList = list.get(to);
		
		List<Character> tmp = new LinkedList<>();
		
		for (int i = 0; i < count; i++) {
			int size = fromList.size();
			Character character = fromList.get(size - 1);
			fromList.remove(size -1);
			tmp.add(character);
		}
		
		for (int i = 0; i < tmp.size(); i++) {
			
			toList.add(tmp.get(tmp.size() - i - 1));
		}
		
//		for (int i = 0; i < tmp.size(); i++) {
//			toList.add(tmp.get(i));
//		}
		
	}
	
}
