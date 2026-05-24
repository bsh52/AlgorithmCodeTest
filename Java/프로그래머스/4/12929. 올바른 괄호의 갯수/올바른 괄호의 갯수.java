import java.util.*;
class Solution {
    List<String> list;
    public int solution(int n) {
        int answer = 0;
        list = new ArrayList<>();
        String str = "";
        make(str, 0, 0, n);
        answer = list.size();
        return answer;
    }

    void make(String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (left < n) {
            make(s + "(", left + 1, right, n);
        }
        if (right < left) {
            make(s + ")", left, right + 1, n);
        }
    }
}