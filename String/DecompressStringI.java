public class DecompressStringI {
	public String decompress(String input) {
		if (input.length() == 0) {
			return input;
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				res.append(input.charAt(i));
			} else {
				int cnt = 0;
				char temp = input.charAt(i - 1);
				int j = i;
				while (j < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
					cnt = cnt * 10 + (input.charAt(i) - '0');
					j++;
				}
				while (cnt > 1) {
					res.append(temp);
					cnt--;
				}
			}
		}
		return res.toString();
	}
}