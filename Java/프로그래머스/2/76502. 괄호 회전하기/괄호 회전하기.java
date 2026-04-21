import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(j));
                } else if (s.charAt(j) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (s.charAt(j) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (s.charAt(j) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}