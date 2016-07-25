package interviewPractise;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 1, temp = 0;

		System.out.println(a);
		System.out.println(b);

		for (int i = 1; i <= 100; i++) {
			temp = a + b;
			a = b;
			b = temp;
			if (temp >= 100) {
				break;

			}
			System.out.println(temp);
		}

	}

}
