package leetcode;

import java.util.stream.IntStream;

public class MedianOfArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		IntStream s1 = IntStream.of(nums1);
		IntStream s2 = IntStream.of(nums2);

		int[] arr = IntStream.concat(s1, s2).sorted().toArray();
		int len = arr.length;
		int mid = len / 2;

		if (len % 2 == 1) {
			return arr[mid];
		}

		return (arr[mid - 1] + arr[mid]) / 2.0;
	}
}
