import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (getCount(rocks, distance, mid) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    int getCount(int[] rocks, int distance, int mid) {
        int start = 0;
        int remove = 0;

        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - start < mid) {
                remove++;
                continue;
            }
            start = rocks[i];
        }
        if (distance - start < mid) {
            remove++;
        }

        return remove;
    }
}