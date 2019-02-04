public class MergeTwoSortedArray {
	public int[] merge(int[] A, int m , int[] B, int n) {
		int[] res = new int[m + n];
		m = m < A.length ? m : A.length;
		n = n < B.length ? n : B.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {
			if (A[i] <= B[j]) {
				res[k] = A[i];
				i++;
				k++;
			} else {
				res[k] = B[j];
				j++;
				k++;
			}
		}

		while (i < m) {
			res[k++] = A[i++];
		}

		while (j < n) {
			res[k++] = B[j++];
		}
		return res;
	}
}