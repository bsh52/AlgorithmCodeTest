import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arrA = new int[topping.length];
        int[] arrB = new int[topping.length];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            setA.add(topping[i]);
            arrA[i] = setA.size();
        }
        for (int i = topping.length - 1; i >= 0; i--) {
            setB.add(topping[i]);
            arrB[i] = setB.size();
        }
        for (int i = 0; i < topping.length - 1; i++) {
            if (arrA[i] == arrB[i+1]) {
                answer++;
            }
        }

        return answer;
    }
}