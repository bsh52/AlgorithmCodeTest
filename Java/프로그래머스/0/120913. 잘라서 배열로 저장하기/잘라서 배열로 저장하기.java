class Solution {
    public String[] solution(String my_str, int n) {
        int count = (my_str.length() + n - 1) / n;
        String[] answer = new String[count];
        
        for (int i = 0; i < count; i++) {
            int s = n * i;
            int e = s + n >= my_str.length() ? my_str.length() : s + n;
            answer[i] = my_str.substring(s, e);
        }
        return answer;
    }
}