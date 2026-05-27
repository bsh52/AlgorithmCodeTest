import java.util.*;
class Solution {
    Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }

    long findRoom(long n) {
        if (!map.containsKey(n)) {
            map.put(n, n + 1);
            return n;
        }
        long next = findRoom(map.get(n));
        map.put(n, next);
        return next;
    }
}