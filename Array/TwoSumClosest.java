import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class TwoSumClosest {
	public List<Integer> closest(int[] array, int target) {
		List<Integer> res = new ArrayList<>();
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		int closest = Integer.MAX_VALUE;
		res.add(array[left]);
		res.add(array[right]);
		while (left < right) {
			if (array[left] + array[right] == target) {
				return Arrays.asList(array[left], array[right]);
			} else if (array[left] + array[right] < target) {
				if (Math.abs((array[left] + array[right]) - target) < closest) {
					res = Arrays.asList(array[left], array[right]);
					closest = Math.abs((array[left] + array[right]) - target);
				}
				left++;
			} else {
				if (Math.abs((array[left] + array[right]) - target) < closest) {
					res = Arrays.asList(array[left], array[right]);
					closest = Math.abs((array[left] + array[right]) - target);
				}
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 7, 13};
		int target = 7;
		TwoSumClosest solution = new TwoSumClosest();
		List<Integer> res = solution.closest(array, target);
		System.out.println(res);
	}
}