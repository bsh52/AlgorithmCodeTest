import java.util.*;
class Solution {
    int[] cols;
    int count = 0;
    public int solution(int n) {
        int answer = 0;
        cols = new int[n];
        check(0, n);
        answer = count;
        return answer;
    }

    void check(int depth, int n) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            cols[depth] = i;
            if (possible(depth)) {
                check(depth + 1, n);
            }
        }
    }

    boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (cols[i] == cols[depth]) return false;
            if (Math.abs(cols[i] - cols[depth]) == Math.abs(depth - i)) return false;
        }
        return true;
    }
}