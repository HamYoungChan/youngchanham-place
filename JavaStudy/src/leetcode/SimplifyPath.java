package leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> pathStack = new Stack<>();
		String[] directories = path.split("/");

		for (String directory : directories) {
			if (directory.isEmpty() || directory.equals(".")) {
				continue;
			}

			if (!directory.equals("..")) {
				pathStack.push(directory);
				continue;
			}

			if (!pathStack.isEmpty()) {
				pathStack.pop();
			}
		}

		if (pathStack.isEmpty()) {
			return "/";
		}

		String result = pathStack.stream().collect(Collectors.joining("/"));
		return String.format("/%s", result);
	}
}
