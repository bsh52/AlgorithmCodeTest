import java.util.*;
class Solution {
    int size = 0;
    int[][] points;
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        int answer = 0;

        List<List<List<Integer>>> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(getRoute(route));
        }

        for (int i = 0; i < size; i++) {
            Map<List<Integer>, Integer> map = new HashMap<>();
            for (List<List<Integer>> lists : list) {
                if (i >= lists.size()) continue;
                List<Integer> point = lists.get(i);
                map.put(point, map.getOrDefault(point, 0) + 1);
            }

            for (int value : map.values()) {
                if (value >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private List<List<Integer>> getRoute(int[] route) {
        List<List<Integer>> routeList = new ArrayList<>();
        for (int i = 0; i < route.length - 1; i++) {
            int[] start = points[route[i] - 1];
            int[] end = points[route[i + 1] - 1];
            int startX = start[0];
            int startY = start[1];
            int endX = end[0];
            int endY = end[1];
            while (startX != endX || startY != endY) {
                routeList.add(Arrays.asList(startX, startY));
                if (startX != endX) {
                    startX = startX > endX ? startX - 1 : startX + 1;
                } else {
                    startY = startY > endY ? startY - 1 : startY + 1;
                }
            }
            if (i == route.length - 2) {
                routeList.add(Arrays.asList(startX, startY));
            }
        }
        size = Math.max(size, routeList.size());

        return routeList;
    }
}