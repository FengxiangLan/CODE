public class ValidAnagram {
	public boolean isAnagram(String source, String target) {
		if (source.length() != target.length()) {
            return false;
        }
        
        int[] charArray = new int[26];
        for (int i = 0; i < source.length(); i++) {
            charArray[source.charAt(i) - 'a']++;
            charArray[target.charAt(i) - 'a']--;
        }
        
        for (int num : charArray) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
	}
}