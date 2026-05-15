class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            for (String word : words) {
                b = b.replace(word, " ");
            }
            b = b.trim();
            if (b.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}