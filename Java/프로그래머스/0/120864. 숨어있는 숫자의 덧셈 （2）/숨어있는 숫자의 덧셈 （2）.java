class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.replaceAll("[a-zA-Z]", " ").split(" ");
        
        for (String str : arr) {
            if (!str.equals("")) {
                answer += Integer.valueOf(str);
            }
        }
        
        return answer;
    }
}