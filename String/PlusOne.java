public class PlusOne {
	public int[] plus(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int num = 0;
		int factor = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			num += digits * factor;
			factor *= 10;
		}

		num += 1;
		String numString = String.valueOf(num);
		int[] res = new int[numString.length()];
		for (int i = 0; i < numString.length(); i++) {
			res[i] = numString.charAt(i) - '0';
		}
		return res;
	}
}