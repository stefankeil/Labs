public class PrimeNumbers {

	static int numbers = 200;
	static boolean prime;

	public static void main(String[] args) {
		PrimeNumbers.computePrime();
	}

	public static void computePrime() {
		for (int i = 2; i < numbers; i++) {
			for (int j = 2; j < numbers; j++) {
				if (i != j && i % j == 0) {
					prime = false;
					break;
				} else {
					prime = true;
				}
			}
			if (prime) {
				System.out.println(i + " is a prime number!");
			}
		}
	}
}
