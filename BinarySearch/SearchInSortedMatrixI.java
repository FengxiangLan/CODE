public class SearchInSortedMatrixI {
	public int[] search(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] res = new int[] {-1, -1};
		if (m == 0 || n == 0) {
			return res;
		}

		int left = 0;
		int right = m * n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / n;
			int col = mid % n;
			if (matrix[row][col] == target) {
				res[0] = row;
				res[1] = col;
				return res;
			}
			else if (matrix[row][col] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return res;
	}
}