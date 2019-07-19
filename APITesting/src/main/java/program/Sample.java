package program;

import java.util.Hashtable;
import java.util.Set;

public class Sample {
 // n = no of characters
	// o(n) + 0(26)  = O(n)
	public static void main(String[] args) {
		// charCount();
		

	}

	// O(26) * O(n) 
	public static void charCount() {
		String input = "We ate pizza ";
		String str = input.toLowerCase().trim();
		int count = 0;

		//O(26)
		for (char i = 'a'; i <= 'z'; i++) {
			// O(n)
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == i) {
					count++;
				}
			}

			if (count != 0) {
				System.out.println(i + " =" + count);
				count = 0;
			}
		}
	}

	//o(n)
	public static void charCountUsingHashTable() {
		Hashtable<Character, Integer> data = new Hashtable<Character, Integer>();
		String input = "We ate pizza ";
		String str = input.toLowerCase().trim();
		char[] ch = str.toCharArray();
		for (char c : ch) {
			Integer value = data.getOrDefault(c, 0);
			value += 1;

			data.put(c, value);

		}
		Set<Character> set = data.keySet();
		for (Character k : set) {
			System.out.println(k + ":" + data.get(k));
		}
	}
	
	public static void charCountUsingArray() {
		String input = "We ate pizza ";
		String str = input.toLowerCase().trim();
		char[] ch = str.toCharArray();
		int[] num = new int[26];

		// O(n)
		for (char c : ch) {
			if (c != ' ') {
				num[c - 'a'] += 1;
			}
		}

		// O(26) => c
		for (int i = 0; i < 26; i++) {
			int n = num[i];
			if (n != 0) {
				char c = (char) (i + 'a');
				System.out.println(c + ":" + n);
			}
		}
	}
}
