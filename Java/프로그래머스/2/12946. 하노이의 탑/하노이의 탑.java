import java.util.*;

class Solution {
    List<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            answer[i][0] = arr.get(i)[0];
            answer[i][1] = arr.get(i)[1];
        }
        return answer;
    }

    void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};

        if (n == 1) {
            arr.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            arr.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}