public class InterleavePosAndNeg {
	public int[] interleave(int[] array) {
		List<Integer> pos = new ArrayList<Integer>();
		List<Integer> neg = new ArrayList<Integer>();

		for (int num : array) {
			if (num > 0) {
				pos.add(num);
			} else {
				neg.add(num);
			}
		}

		int i = 0;
		while (!pos.isEmpty() && !neg.isEmpty()) {
			if (i % 2 == 0) {
				array[i] = pos.get(0);
				pos.remove(0);
			} else {
				array[i] = neg.get(0);
				neg.remove(0);
			}
			i++;
		}

		while (!pos.isEmpty()) {
			array[i++] = pos.get(0);
			pos.remove(0);
		}

		while (!neg.isEmpty()) {
			array[i++] = neg.get(0);
			neg.remove(0);
		}

		return array;
	}
}