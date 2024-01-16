package leetcode;

public class LongestSubstr {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}

		String check = "";
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (check.contains(Character.toString(c))) {
				check = check.substring(check.indexOf(c) + 1);
			}

			check += c;
			max = Math.max(check.length(), max);
		}

		return max;
	}
}