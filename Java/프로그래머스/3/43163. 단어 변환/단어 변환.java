class Solution {
    boolean[] visited;
    int count;
    int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        boolean isSame = false;
        for (String word : words) {
            if (word.equals(target)) {
                isSame = true;
            }
        }
        if (!isSame) return 0;

        dfs(begin, target, words, count);
        if (min != Integer.MAX_VALUE) answer = min;
        return answer;
    }

    void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            if (isPossible(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    boolean isPossible(String begin, String target) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) count++;
        }
        return count == 1;
    }
}