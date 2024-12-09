import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arrSort = Arrays.stream(array).sorted().toArray();
        int center = (int) array.length / 2;
        answer = arrSort[center];
        return answer;
    }
}