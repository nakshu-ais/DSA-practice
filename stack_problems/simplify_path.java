import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir : parts) {
            if (dir.equals("") || dir.equals(".")) {
                // Skip empty or current directory
                continue;
            } else if (dir.equals("..")) {
                // Go up one directory
                if (!stack.isEmpty()) stack.pop();
            } else {
                // Valid directory name
                stack.push(dir);
            }
        }

        // Build simplified path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // If empty, root "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
