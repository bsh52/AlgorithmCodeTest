class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = and((or(x1, x2)), (or(x3, x4)));
        return answer;
    }
    
    public boolean or (boolean a, boolean b) {
        if (a || b) return true; else return false;
    }
    
    public boolean and (boolean a, boolean b) {
        if (a && b) return true; else return false;
    }
}