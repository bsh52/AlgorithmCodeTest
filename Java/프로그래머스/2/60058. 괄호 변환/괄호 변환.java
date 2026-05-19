import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if (p.isEmpty()) return "";

        String u = "";
        String v = "";
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                u += p.substring(0, i + 1);
                v += p.substring(i + 1);
                break;
            }
        }

        if (isComplete(u)) {
            answer = u + solution(v);
        } else {
            answer += "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') answer += ')';
                else answer += "(";
            }
        }

        return answer;
    }

    boolean isComplete(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') stack.push(p.charAt(i));
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}