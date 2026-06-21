import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {
        List<Expression> expressionList = new ArrayList<>();
        List<Expression> xList = new ArrayList<>();
        int maxDigit = 0;

        for (int i = 0; i < expressions.length; i++) {
            for (char c : expressions[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    maxDigit = Math.max(maxDigit, c - '0');
                }
            }
            String[] split = expressions[i].split(" ");
            Expression expression = new Expression(split);
            if ("X".equals(expression.result)) {
                xList.add(expression);
            } else {
                expressionList.add(expression);
            }
        }

        List<Integer> digitList = new ArrayList<>();
        for (int i = maxDigit + 1; i <= 9; i++) {
            boolean isPossible = true;
            for (Expression expression : expressionList) {
                if (!calc(expression, i).equals(expression.result)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                digitList.add(i);
            }
        }

        if (digitList.isEmpty()) {
            for (int i = maxDigit + 1; i <= 9; i++) {
                digitList.add(i);
            }
        }

        String[] answer = new String[xList.size()];
        for (int i = 0; i < xList.size(); i++) {
            Expression expression = xList.get(i);
            answer[i] = expression.prefix();
            String first = null;
            boolean isUnique = true;
            for (int num : digitList) {
                String result = calc(expression, num);
                if (first == null) {
                    first = result;
                } else if (!first.equals(result)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                answer[i] += first;
            } else {
                answer[i] += "?";
            }
        }

        return answer;
    }

    String calc(Expression expression, int n) {
        String operator = expression.operator;

        int aInt = Integer.parseInt(expression.left, n);
        int bInt = Integer.parseInt(expression.right, n);

        int result = operator.equals("+")
                ? aInt + bInt
                : aInt - bInt;

        return Integer.toString(result, n);
    }

    class Expression {
        String left;
        String operator;
        String right;
        String symbol;
        String result;

        Expression(String[] split) {
            left = split[0];
            operator = split[1];
            right = split[2];
            symbol = split[3];
            result = split[4];
        }

        String prefix() {
            return left + " " + operator + " " + right + " " + symbol + " ";
        }
    }
}