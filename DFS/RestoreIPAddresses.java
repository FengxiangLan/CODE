public class RestoreIPAddresses {
	public List<String> Restore(String ip) {
		List<String> res = new ArrayList<String>();
		if (ip == null || ip.length() < 4 || ip.length() > 12) {
			return res;
		}

		List<String> address = new ArrayList<String>();
		helper(ip, address, res, 0);
		return res;
	}

	private void helper(String ip, List<String> address , List<String> res, int index) {
		if (address.size() == 4) {
			if (index == ip.length()) {
				StringBuilder ipAddress = new StringBuilder();
				for (String str : address) {
					ipAddress.append(str);
					ipAddress.append('.');
				}

				ipAddress.deleteCharAt(ipAddress.length() - 1);
				res.add(ipAddress.toString());
			}
			return;
		}

		for (int i = index; i < ip.length() && i < index + 3; i++) {
			String tmp = ip.substring(index, i + 1);
			if (isValid(tmp)) {
				address.add(tmp);
				helper(ip, address, res, i + 1);
				address.remove(address.size() - 1);
			}
		}
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}

		int num = Integer.valueOf(s);
		return num >= 0 && num <= 255;
	}
}