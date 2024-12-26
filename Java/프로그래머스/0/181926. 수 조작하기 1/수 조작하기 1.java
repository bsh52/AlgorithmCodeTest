class Solution {
    public int solution(int n, String control) {
        int answer = n;
        String[] ca = control.split("");
        for (int i = 0; i < ca.length; i++) {
            switch(ca[i]){
                case "w" :
                    answer += 1;
                    break;
                case "s" :
                    answer -= 1;
                    break;
                case "d" :
                    answer += 10;
                    break;
                case "a" :
                    answer -= 10;
                    break;
            }
        }
        return answer;
    }
}