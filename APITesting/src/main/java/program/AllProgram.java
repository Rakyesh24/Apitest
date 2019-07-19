package program;

public class AllProgram {

	public static void main(String[] args) {
		// System.out.println(reverseString("hsekaR"));
		// fibonnaciSeries(10);
		System.out.println(reverseNumber(4321));
	}

	public static String reverseString(String input) {

		String output = "";
		for (char c : input.toCharArray()) {
			output = c + output;//
			System.out.println(output);
		}
		return output;

	}

	public static void fibonnaciSeries(int num) {
		int prenum = -1;
		int nextnum = 1;
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum = prenum + nextnum;
			System.out.println(sum);
			prenum = nextnum;
			nextnum = sum;
		}
	}

	public static int reverseNumber(int num) {

		int r;
		int sum = 0;
		while (num != 0) {
			r = num % 10;
			num = num / 10;
			sum = sum * 10 + r;
		}
		return sum;

	}
}
