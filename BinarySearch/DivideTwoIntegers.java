public class DivideTwoIntegers {
	public int divide(int a, int b) {
		if (b == 0 || (a == Integer.MIN_VALUE && b == -1)) {
			return Integer.MAX_VALUE;
		}

		long dividend = Math.abs((long)a);
		long divisor = Math.abs((long)b);

		int res = 0;
		while (dividend >= divisor) {
			int numShift = 0;
			while (dividend >= (divisor << numShift)) {
				numShift++;
			}

			res += 1 << (numShift - 1);
			dividend -= (divisor << (numShift - 1));
		}

		if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
			return res;
		}
		else {
			return -res;
		}
	}
}