public class SearchInSortedMatrixII {
	// Assumption: The given matrix is not null
	// return {index, index}
	// have duplicate element
	// return {-1, -1} if not such target number
	public int[] search(int[][] matrix, int target) {
		int[] res = new int[] {-1, -1};

		int m = matrix.length;
		System.out.println(m);
		int n = matrix[0].length;
		if (m == 0 || n == 0) {
			return res;
		}

		int row = findRow(matrix, 0, m - 1, target);
		if (row == -1) {
			return res;
		}
		//System.out.println(row);
		for (int i = 0; i <= row; i++) {
			int col = findCol(matrix[i], 0, n - 1, target);
			if (col != -1) {
				res[0] = i;
				res[1] = col;
				return res;
			}	
		}
		return res;
		
	}

	private int findRow(int[][] matrix, int up, int down, int target) {
		while (up <= down) {
			int mid = up + (down - up) / 2;
			if (matrix[mid][0] > target) {
				down = mid - 1;
			}
			else {
				up = mid + 1;
			}
		}
		return down;
	}

	private int findCol(int[] row, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (row[mid] == target) {
				return mid;
			}
			else if (row[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,5,6,8},{4,5,5,7,10},{7,7,10,11,11},{9,12,14,14,14}};
		int target = 8;
		SearchInSortedMatrixII solution = new SearchInSortedMatrixII();
		int[] res = solution.search(matrix, target);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}