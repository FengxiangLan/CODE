public class RainbowSortIII {
	public int[] rainbowSortIII(int[] array, int k) {
		if (array.length <= 1) {
			return array;
		}

		helper(array, 0, array.length - 1, 1, k);
		return array;
	}

	private void helper(int[] array, int left, int right, int colOne, int colTwo) {
		if (colOne == colTwo) {
			return;
		}

		if (left >= right) {
			return;
		}

		int colMid = colOne + (colTwo - colOne) / 2;
		int l = left;
		int r = right;
		while (l <= r) {
			while (l <= r && array[l] <= colMid) {
				l++;
			}

			while (l <= r && array[r] > colMid) {
				r--;
			}

			if (l <= r) {
				int temp = array[l];
				array[l] = array[r];
				array[r] = temp;
				l++;
				r--;
			}
		}

		helper(array, left, r, colOne, colMid);
		helper(array, l, right, colMid + 1, colTwo);
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}