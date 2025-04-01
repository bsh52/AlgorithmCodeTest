import java.util.*;
class Solution {
    public String solution(String my_string, int[][] queries) {
        String[] strArr = my_string.split("");
        for (int[] arr : queries) {
            int s = arr[0];
            int e = arr[1];
            
            while (s < e) {
                String temp = strArr[s];
                strArr[s] = strArr[e];
                strArr[e] = temp;
                s++;
                e--;
            }
        }
        return String.join("", strArr);
    }
}