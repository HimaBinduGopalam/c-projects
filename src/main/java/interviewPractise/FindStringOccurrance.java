package interviewPractise;

import java.util.Scanner;

public class FindStringOccurrance {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String PartialText = sc.nextLine();
		String result = findOccurrenceOfInput(input, PartialText);
		System.out.println(result);

	}

	public static String findOccurrenceOfInput(String input, String partialText) {
		String result = null;
		int count = 0;
		String[] temp = partialText.split(input);
		for (String splitstring : temp) {
			if (splitstring.equalsIgnoreCase(input)) {
				count = ++count;
			}

		}

		result = "The" + input + "has occurred" + count + "times in" + partialText;
		return result;
	}
}