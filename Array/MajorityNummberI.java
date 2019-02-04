public class MajorityNummberI {
	public int majority(int[] array) {
		Map<Integer, Integer> hashMap = getMap(array);
		int n = array.length;
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (entry.getValue() > n / 2) {
        return entry.getKey();
      }
    } 
		return -1;
	}
  
  private HashMap<Integer, Integer> getMap(int[] array) {
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      Integer cnt = hashMap.get(array[i]);
      if ( cnt != null) {
        hashMap.put(array[i], cnt + 1);
      } else {
        hashMap.put(array[i], 1);
      }
    }
    return hashMap;
  }
}