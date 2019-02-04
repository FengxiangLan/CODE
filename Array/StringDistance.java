public class StringDistance {
	public int distance(String[] array, String source, String target) {
		int s = -1;
		int t = -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(source)) {
				s = i;
			} else if (array[i].equals(target)) {
				t = i;
			}

			if (s != -1 && t != -1) {
				res = Math.min(res, Math.abs(s - t));
			}
			
		}

		if (s == -1 || t == -1) {
			return -1;
		} else {
			return res;
		}
	}
}