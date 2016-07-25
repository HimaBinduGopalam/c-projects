package interviewPractise;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input value");
		int input = sc.nextInt();

		for (int i = 2; i <= input / 2; i++) {
			input = input % i;
			if (input == 0) {
				System.out.println("not prime");

			} else
				System.out.println("prime");
		}
	}

}
