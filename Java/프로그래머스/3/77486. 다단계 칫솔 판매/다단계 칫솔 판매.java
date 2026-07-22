import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            idxMap.put(enroll[i], i);
        }

        int[] parent = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            parent[i] = idxMap.getOrDefault(referral[i], -1);
        }

        for (int i = 0; i < seller.length; i++) {
            int idx = idxMap.get(seller[i]);
            int price = amount[i] * 100;

            while (idx != -1 && price > 0) {
                int next = price / 10;
                answer[idx] += price - next;
                price = next;
                idx = parent[idx];
            }
        }
        
        return answer;
    }
}