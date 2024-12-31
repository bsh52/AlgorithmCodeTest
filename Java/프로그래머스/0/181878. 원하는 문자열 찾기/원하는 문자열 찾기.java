class Solution {
    public int solution(String myString, String pat) {
        String lowerStr = myString.toLowerCase();
        String lowerPat = pat.toLowerCase();
        
        return lowerStr.contains(lowerPat) ? 1 : 0;
    }
}