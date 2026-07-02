class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int size = 0;
        for (int[] edge : edges) {
            size = Math.max(size, edge[0]);
            size = Math.max(size, edge[1]);
        }
        int[] out = new int[size + 1];
        int[] in = new int[size + 1];

        for (int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        }

        for (int i = 1; i <= size; i++) {
            if (in[i] == 0 && out[i] > 1) {
                answer[0] = i;
            }
            if (out[i] == 0 && in[i] > 0) {
                answer[2]++;
            }
            if (in[i] > 1 && out[i] > 1) {
                answer[3]++;
            }
        }
        answer[1] = out[answer[0]] - (answer[2] + answer[3]);

        return answer;
    }
}