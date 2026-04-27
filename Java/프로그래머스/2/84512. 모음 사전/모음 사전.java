import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        answer = list.indexOf(word);
        return answer;
    }

    void dfs(String word, int depth) {
        list.add(word);
        if (depth == 5){
            return;
        }
        for (String s : words) {
            dfs(word + s, depth + 1);
        }
    }
}