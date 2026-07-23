import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        if (Arrays.stream(food_times).asLongStream().sum() <= k) return -1;
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> (int) (a.time - b.time));
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i + 1, food_times[i]));
        }

        long time = 0;
        long count = 0;

        while ((pq.peek().time - count) * pq.size() <= k - time) {
            int size = pq.size();
            Food food = pq.poll();
            time += (food.time - count) * size;
            count = food.time;
        }

        List<Food> list = new ArrayList<>(pq);
        list.sort((a, b) -> (int) (a.idx - b.idx));

        return list.get((int) ((k - time) % list.size())).idx;
    }

    class Food {
        int idx;
        long time;

        Food(int idx, long time) {
            this.idx = idx;
            this.time = time;
        }
    }
}