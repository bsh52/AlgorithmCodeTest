import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(expression.substring(start, i));
                list.add(String.valueOf(expression.charAt(i)));
                start = i + 1;
            }
        }
        list.add(expression.substring(start));

        String[][] arr = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, {"-", "*", "+"}, {"*", "-", "+"}, {"*", "+", "-"}};

        for (int i = 0; i < arr.length; i++) {
            List<String> tmp = new ArrayList<>(list);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < tmp.size(); k++) {
                    if (arr[i][j].equals(tmp.get(k))) {
                        tmp.set(k - 1, calc(tmp.get(k - 1), tmp.get(k), tmp.get(k + 1)));
                        tmp.remove(k);
                        tmp.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
        }

        return answer;
    }

    String calc(String num1, String operator, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if (operator.equals("+")) {
            return n1 + n2 + "";
        } else if (operator.equals("-")) {
            return n1 - n2 + "";
        }
        return n1 * n2 + "";
    }
}