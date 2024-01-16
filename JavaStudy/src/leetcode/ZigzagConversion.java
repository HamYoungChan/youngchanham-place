package leetcode;

public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		char[] arr = s.toCharArray();
		char[][] zigzag = new char[numRows][arr.length];

		int r = 0;
		int c = 0;
		int[][] dirs = {{1, 0}, {-1, 1}};
		int dirIdx = 0;

		for (char ch : arr) {
			zigzag[r][c] = ch;
			r += dirs[dirIdx][0];
			c += dirs[dirIdx][1];

			if (r == 0 || r == numRows - 1) {
				dirIdx = (dirIdx + 1) % 2;
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < arr.length; j++) {
				char ch = zigzag[i][j];

				if (ch == '\u0000') {
					continue;
				}

				answer.append(zigzag[i][j]);
			}
		}

		return answer.toString();
	}
}
