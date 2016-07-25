package interviewPractise;

public class StarPattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 5;
		for (int i = 0; i < size; i++) {
			for (int j = 5; j >= i; j--) {
				if (j > i) {
					System.out.print("*");
				} else {
					System.out.print("");
				}
				System.out.println();
			}
		}
	}
}
