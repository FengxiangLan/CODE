import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class ArrayDuplicateV {
	public int[] dedup(int[] array) {
		if (array == null || array.length <= 2) {
			return array;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(array[0], 0);
		map.put(array[1], 1);

		int slow = 2;		
		for (int fast = 2; fast < array.length; fast++) {
			if (array[fast] == array[slow - 1] && array[fast] == array[slow - 2]) {
				continue;
			} else {
				array[slow++] = array[fast];
			}
		}

		return Arrays.copyOf(array, slow);
	}

	public static void main(String[] args) {
		int[] array = {5,1,1,2,3,1,1,2,2,2,5,5,5,6};
		ArrayDuplicateV solution = new ArrayDuplicateV();
		int[] res = solution.dedup(array);
		for (int num : res) {
			System.out.print(num);
		}
	}
}