package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public String intToRoman(int num) {
		Map<Integer, String> codeMap = new HashMap<>();
		codeMap.put(1, "I");
		codeMap.put(4, "IV");
		codeMap.put(5, "V");
		codeMap.put(9, "IX");
		codeMap.put(10, "X");
		codeMap.put(40, "XL");
		codeMap.put(50, "L");
		codeMap.put(90, "XC");
		codeMap.put(100, "C");
		codeMap.put(400, "CD");
		codeMap.put(500, "D");
		codeMap.put(900, "CM");
		codeMap.put(1000, "M");

		StringBuilder result = new StringBuilder();

		// 중심 단위
		int[] units = {1000, 500, 100, 50, 10, 5};
		// 앞자리 삭감 단위
		int minusUnit = 100;

		for (int mainUnit : units) {
			// 10자릿수일 때마다 삭감단위도 축소
			if (mainUnit == minusUnit) {
				minusUnit /= 10;
			}

			// 중심 단위 표기수 계산
			int repeating = num / mainUnit;

			if (repeating > 0) {
				String roman = codeMap.get(mainUnit);
				result.append(roman.repeat(repeating));
			}

			num %= mainUnit;

			// 삭감 단위 표기수 계산
			int subUnit = mainUnit - minusUnit;

			if (subUnit <= num) {
				String append = codeMap.get(subUnit);
				result.append(append);
				num -= subUnit;
			}
		}

		if (num > 0) {
			result.append("I".repeat(num));
		}

		return result.toString();
	}
}
