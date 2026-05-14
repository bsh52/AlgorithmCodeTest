import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> gap = new ArrayList<>();
        List<Integer> abs = new ArrayList<>();

        for (int i : numlist) {
            gap.add(i - n);
            abs.add(Math.abs(i - n));
        }

        Collections.sort(abs);

        for (int i = 0; i < numlist.length; i++) {
            if (gap.contains(abs.get(i)) && (i == 0 || !abs.get(i).equals(abs.get(i - 1)))) {
                numlist[i] = n + abs.get(i);
            } else {
                numlist[i] = n - abs.get(i);
            }
        }

        return numlist;
    }
}