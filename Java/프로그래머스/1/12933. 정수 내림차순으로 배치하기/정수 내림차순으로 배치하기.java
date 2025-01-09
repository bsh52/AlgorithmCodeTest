import java.util.*;
class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        
        Arrays.sort(arr, Comparator.reverseOrder());
        
        StringBuffer sb = new StringBuffer();
        
        for (String s : arr) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }
}