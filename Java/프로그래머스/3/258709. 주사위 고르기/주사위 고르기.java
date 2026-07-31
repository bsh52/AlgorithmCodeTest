import java.util.*;
class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        long min = 0;
        Result result = null;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != n / 2) continue;
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            if ((i & 1) == 0) continue;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    a.add(j);
                } else {
                    b.add(j);
                }
            }

            Result sum = getSum(a, b, dice);
            if (sum.result > min) {
                min = sum.result;
                result = sum;
            }
        }

        return result.dice.stream().mapToInt(i -> i + 1).toArray();
    }

    private Result getSum(List<Integer> a, List<Integer> b, int[][] dice) {
        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();
        sumDice(0, 0, a, dice, sumA);
        sumDice(0, 0, b, dice, sumB);
        Collections.sort(sumA);
        Collections.sort(sumB);
        long win = 0, lose = 0;

        for (int i : sumA) {
            win += lowerBound(sumB, i);
        }
        for (int i : sumB) {
            lose += lowerBound(sumA, i);
        }

        if (win > lose) {
            return new Result(win, a);
        } else {
            return new Result(lose, b);
        }
    }

    private int lowerBound(List<Integer> diceList, int target) {
        int left = 0;
        int right = diceList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (diceList.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private void sumDice(int idx, int sum, List<Integer> selected, int[][] dice, List<Integer> sums) {
        if (idx == selected.size()) {
            sums.add(sum);
            return;
        }

        int[] current = dice[selected.get(idx)];

        for (int i : current) {
            sumDice(idx + 1, sum + i, selected, dice, sums);
        }
    }

    class Result {
        long result;
        List<Integer> dice;

        public Result(long result, List<Integer> dice) {
            this.result = result;
            this.dice = dice;
        }
    }
}