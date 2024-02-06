package leetcode;

import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new LinkedList<>();

		for (int size = 0; size <= nums.length; size++) {
			Stack<Deque<Integer>> stack = new Stack<>();
			stack.push(new LinkedList<>());

			while (!stack.isEmpty()) {
				Deque<Integer> current = stack.pop();

				if (current.size() == size) {
					results.add(new ArrayList<>(current));
					continue;
				}

				int last = current.isEmpty() ? -11 : current.peekLast();

				for (int num : nums) {
					if (num <= last) {
						continue;
					}

					Deque<Integer> next = new LinkedList<>(current);
					next.addLast(num);
					stack.push(next);
				}
			}
		}

		return results;
	}
}
