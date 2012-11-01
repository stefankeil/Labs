public class FourtyBits {

	static long number = 1099511627776L;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		FourtyBits.computePrime();
		System.out.println("Time: " + (System.currentTimeMillis() - start));
	}

	public static void computePrime() {
		for (long i = number; i < number + 100; i++) {
			boolean prime = true;
			if (i % 2 == 0) {
				prime = false;
			} else {
				for (long j = 3; j < (int) Math.sqrt(number) + 100; j = j + 2) {
					if (i != j && i % j == 0) {
						prime = false;
						break;
					}
				}
			}
			if (prime) {
				System.out.println(i + " is a prime number!");
			}
		}
	}
}