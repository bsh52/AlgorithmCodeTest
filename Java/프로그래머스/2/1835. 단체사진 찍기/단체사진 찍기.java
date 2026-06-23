class Solution {
    String[] friend = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;
    String[] data;
    public int solution(int n, String[] data) {
        this.data = data;
        dfs("");
        return answer;
    }

    private void dfs(String s) {
        if (s.length() == friend.length) {
            for (String datum : data) {
                if (!isPossible(s, datum)) {
                    return;
                }
            }
            answer++;
        }
        for (String f : friend) {
            if (s.contains(f)) continue;
            dfs(s + f);
        }
    }

    private boolean isPossible(String s, String datum) {
        int gap = Math.abs(s.indexOf(datum.charAt(0)) - s.indexOf(datum.charAt(2))) - 1;
        int count = datum.charAt(4) - '0';
        char symbol = datum.charAt(3);

        if ((symbol == '>' && gap > count) || (symbol == '<' && gap < count) || (symbol == '=' && gap == count)) {
            return true;
        }

        return false;
    }
}