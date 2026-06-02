import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<String[]> bookQueue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        PriorityQueue<String[]> roomQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        bookQueue.addAll(Arrays.asList(book_time));
        roomQueue.add(bookQueue.poll());

        while (!bookQueue.isEmpty()) {
            String[] next = bookQueue.poll();
            String[] prev = roomQueue.peek();
            if (timeToInt(prev[1]) + 10 <= timeToInt(next[0])) {
                roomQueue.poll();
                roomQueue.add(next);
            } else {
                roomQueue.add(next);
            }
        }
        answer = roomQueue.size();

        return answer;
    }

    int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}