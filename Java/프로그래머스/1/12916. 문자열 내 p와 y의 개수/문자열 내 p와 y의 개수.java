class Solution {
    boolean solution(String s) {
        String[] lowerArr = s.toLowerCase().split("");
        int count = 0;
        
        for (String str : lowerArr) {
            if (str.equals("p")) {
                count++;
            } else if (str.equals("y")){
                count--;
            }
        }
        
        return count == 0;
    }
}