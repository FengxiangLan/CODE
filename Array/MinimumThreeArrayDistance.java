public class MinimumThreeArrayDistance {
	public int minDistance(int[] a, int[] b, int[] c) {
		// Write your solution here
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++){
				for (int k = 0; k < c.length; k++) {
					res = Math.min(Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]), res);
				}
			}
		}
		return res;
	}
}