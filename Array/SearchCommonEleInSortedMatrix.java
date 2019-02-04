import java.util.Map;
import java.util.HashMap;
public class SearchCommonEleInSortedMatrix {
	public int search(int[][] matrix) {
		if (matrix.length <= 1) {
	      return -1;
	    }
		int[] indexs = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			indexs[i] = matrix[i].length - 1;
		}
		int localMin = 0;
		while (indexs[localMin] >= 0) {
			
			for (int i = 0; i < matrix.length; i++) {
				localMin = matrix[i][indexs[i]] < matrix[localMin][indexs[localMin]] ? i : localMin;
			}

			int cnt = 0;
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][indexs[i]] > matrix[localMin][indexs[localMin]]) {
					if (indexs[i] == 0) {
						return -1;
					}
					indexs[i]--;
				} else {
					cnt++;
				}
			}

			if (cnt == matrix.length) {
				return matrix[localMin][indexs[localMin]];
			}
		}

		return -1;
		
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][];
		matrix[0] = new int[]{0};
		matrix[1] = new int[]{1};
		matrix[2] = new int[]{1};
		SearchCommonEleInSortedMatrix solution = new SearchCommonEleInSortedMatrix();
		int res = solution.search(matrix);
		System.out.println(res);
	}
}