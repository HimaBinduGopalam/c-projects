package interviewPractise;

public class EvenNumbers {

	public static void main(String[] args) {
		int n;

		for (int i = 100; i < 200; i++) {
			n = i % 2;
			if (n == 0) {
				System.out.println(i);
			}
		}
	}
}