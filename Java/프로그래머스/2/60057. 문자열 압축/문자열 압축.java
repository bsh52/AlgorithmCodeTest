import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= (int) Math.ceil((double) s.length() / 2); i++) {
            answer = Math.min(answer, getLength(s, i));
        }
        return answer;
    }

    int getLength(String s, int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) s.length() / size); i++) {
            String str = "";
            str += s.substring(i * size, Math.min((i + 1) * size, s.length()));
            list.add(str);
        }

        List<String> result = new ArrayList<>();
        int count = 1;
        String temp = list.get(0);

        if (list.size() == 1) {
            result.add(temp);
        } else {
            for (int i = 1; i < list.size(); i++) {
                if (temp.equals(list.get(i))) {
                    count++;
                } else {
                    result.add(count + temp);
                    count = 1;
                    temp = list.get(i);
                }

                if (i == list.size() - 1) {
                    result.add(count + temp);
                }
            }
        }

        String ans = result.stream().reduce("", (a, b) -> a + b);
        ans = ans.replaceAll("(?<!\\d)1(?!\\d)", "");

        return ans.length();
    }
}