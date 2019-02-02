public class TwoDiffInSortArray {
	public int[] twoDiff(int[] array, int target) {
		int[] res = {-1, -1};
		int i = 0;
		int j = 0;
		while (i < array.length && j < array.length) {
			if (i != j && (array[j] - array[i] == target)) {
				res[0] = target == 0 ? Math.min(i, j) : i;
				res[1] = target == 0 ? Math.max(i, j) : j;
				return res;
			} else if ((array[j] - array[i]) < target) {
				j++;
			} else {
				i++;
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] num = {1,5,5,10,14,22,23,30};
		int target = 12;
		TwoDiffInSortArray solution = new TwoDiffInSortArray();
		int[] res = new int[2];
		res = solution.twoDiff(num, target);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}