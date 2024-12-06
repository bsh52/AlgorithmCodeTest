class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] strBits = my_string.split("");
        
        for(String str : strBits) {
            for (int i = 0; i < n; i++) {
                sb.append(str);
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}