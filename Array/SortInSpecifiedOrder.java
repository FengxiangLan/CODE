import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class SortInSpecifiedOrder {
	public int[] sortSpecial(int [] A1, int[] A2) {
		Map<Integer, Integer> hashMap = getMap(A1);
		List<Integer> list = getList(A2);
		List<Integer> other = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		for (Integer num : list) {
			Integer cnt = hashMap.get(num);
			if (cnt != null) {
				for (int i = 0; i < cnt; i++) {
					res.add(num);
				} 
			} else {
				continue;
			}
		}

		for (int num : A1) {
			if (!res.contains(num)) {
				other.add(num);
			}
		}

		Collections.sort(other);
		for (Integer num : other) {
			res.add(num);
		}

		for (int i = 0; i < res.size(); i++) {
			A1[i] = (int)res.get(i);
		}

		return A1;
	}

	private Map<Integer, Integer> getMap(int[] array) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer cnt = hashMap.get(array[i]);
			if (cnt == null) {
				hashMap.put(array[i], 1);
			} else {
				hashMap.put(array[i], cnt + 1);
			}
		}

		return hashMap;
	}

	private List<Integer> getList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0 ; i < array.length; i++) {
			if (!list.contains(new Integer(array[i]))) {
				list.add(new Integer(array[i]));
			} else {
				continue;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] A1 = {1,4,4,3,3,3};
		int[] A2 = {4};
		SortInSpecifiedOrder solution = new SortInSpecifiedOrder();
		solution.sortSpecial(A1, A2);
		for (int num : A1) {
			System.out.print(num);
		}
	}
}

/*
static class MyComparator implements Comparator<Integer> {
		private Map<Integer, Integer> map;
		public MyComparator(int[] array) {
			map = new HashMap<>();
			for (int i = 0; i < array.length; i++) {
				map.put(array[i], i);
			}
		}

		@Override
		public int compare(Integer i1, Integer i2) {
			Integer index1 = map.get(i1);
			Integer index2 = map.get(i2);
			if (index1 != null && index2 != null) {
				return index1.compareTo(index2);
			}
			else if (index1 == null && index2 == null) {
				return i1.compareTo(i2);
			}
			return index1 != null ? -1 : 1;
		}
	}
	public int[] sortSpecial(int[] A1, int[] A2) {
		Integer[] newArray = getInteger(A1);
		Arrays.sort(newArray, new MyComparator(A2));
		getInt(newArray, A1);
		return A1;
	}


	private Integer[] getInteger(int[] array) {
		Integer[] newArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	private void getInt(Integer[] newArray, int[] array) {
		for (int i = 0; i < newArray.length; i++) {
			array[i] = newArray[i];
		}
	}

*/