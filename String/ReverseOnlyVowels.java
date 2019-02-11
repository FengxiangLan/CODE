import java.util.Set;
import java.util.HashSet;
public class ReverseOnlyVowels {
	public String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		char[] array = input.toCharArray();
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		helper(array, 0, array.length - 1, set);
		return new String(array);
	}

	private void helper(char[] array, int i, int j, Set<Character> set) {
		if (i >= j) {
			return;
		}

		if (!set.contains(array[i]) && !set.contains(array[j])) {
			helper(array, i + 1, j - 1, set);
		} else if (set.contains(array[i]) && !set.contains(array[j])) {
			helper(array, i, j - 1, set);
		} else if (!set.contains(array[i]) && set.contains(array[j])) {
			helper(array, i + 1, j, set);
		} else {
			swap(array, i, j);
			helper(array, i + 1, j - 1, set);
		}		
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		String input = "abbegi";
		ReverseOnlyVowels solution = new ReverseOnlyVowels();
		String res = solution.reverse(input);
		System.out.println(res);
	}
}