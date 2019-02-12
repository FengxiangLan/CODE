public class OneEditDistance {
	public boolean oneEditDistance(String source, String target) {
		if (Math.abs(source.length() - target.length()) > 1) {
			return false;
		}

		int i = 0;
		int j = 0;
		int cnt = 0;
		int m = source.length();
		int n = target.length();
		while (i < m && j < n) {
			if (source.charAt(i) == target.charAt(j)) {
				i++;
				j++;
			} else {
				cnt++;
				if (cnt > 1) {
					return false;
				} 
				if (m > n) {
					i++;
				} else if (m < n) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}

		if (i < m || j < n) {
			cnt++;
		}

		if (cnt == 1) {
			return true;
		}

		return false;
	}
}