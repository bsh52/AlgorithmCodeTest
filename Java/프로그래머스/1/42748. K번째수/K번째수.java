import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] subArray = new int[j - i + 1];
            for (int m = i - 1; m < j; m++) {
                subArray[m - (i - 1)] = array[m];
            }
            Arrays.sort(subArray);
            result[Arrays.asList(commands).indexOf(command)] = subArray[k - 1];
        }
        return result;
    }
}