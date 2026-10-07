import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int leftRem, int rightRem,
                     int balance, StringBuilder current) {

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && balance == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(') {
            if (leftRem > 0) {
                dfs(s, index + 1, leftRem - 1, rightRem, balance, current);
            }

            current.append(c);
            dfs(s, index + 1, leftRem, rightRem, balance + 1, current);
            current.deleteCharAt(current.length() - 1);

        } else if (c == ')') {
            if (rightRem > 0) {
                dfs(s, index + 1, leftRem, rightRem - 1, balance, current);
            }

            if (balance > 0) {
                current.append(c);
                dfs(s, index + 1, leftRem, rightRem, balance - 1, current);
                current.deleteCharAt(current.length() - 1);
            }

        } else {
            current.append(c);
            dfs(s, index + 1, leftRem, rightRem, balance, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}