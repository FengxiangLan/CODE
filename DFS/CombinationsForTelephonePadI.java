import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CombinationsForTelephonePadI {
	public String[] combinations(int number) {
		// len(number) level
		// each level contains the characters of string
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");

		List<Integer> keys = new ArrayList<Integer>();
		while (number != 0) {
			int key = number % 10;
			if (key != 1 && key != 0) {
				keys.add(key);
			}			
			number = number / 10;
		}
		Collections.reverse(keys);
		List<String> res = new ArrayList<String>();
		StringBuilder path = new StringBuilder();
		// System.out.println(keys);
		helper(keys, 0, path, res, map);
		return res.toArray(new String[res.size()]);
	}

	private void helper(List<Integer> keys, int index, StringBuilder path, List<String> res, Map<Integer, String> map) {
		if (index == keys.size()) {
			res.add(path.toString());
			return;
		}
		
		String str = map.get(keys.get(index));
		//System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			path.append(str.charAt(i));
			helper(keys, index + 1, path, res, map);
			path.deleteCharAt(path.length() - 1);
		}
	}

	public static void main(String[] args) {
		int number = 231;
		CombinationsForTelephonePadI solution = new CombinationsForTelephonePadI();
		solution.combinations(number);
	}

}

// 		 a 			       b 			  c
//   /   |   \		   /   |   \     /    |    \
// d     e    f      d     e    f   d     e     f
	
