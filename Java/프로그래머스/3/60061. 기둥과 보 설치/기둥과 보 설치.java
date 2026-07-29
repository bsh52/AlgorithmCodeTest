import java.util.*;
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<List<Integer>> build = new ArrayList<>();
        for (int[] ints : build_frame) {
            int x = ints[0];
            int y = ints[1];
            int a = ints[2];
            int b = ints[3];

            if (b == 1) {
                if (isInstallable(x, y, a, build)) {
                    build.add(List.of(x, y, a));
                }
            } else {
                build.remove(List.of(x, y, a));
                for (List<Integer> list : build) {
                    int x2 = list.get(0);
                    int y2 = list.get(1);
                    int a2 = list.get(2);

                    if (!isInstallable(x2, y2, a2, build)) {
                        build.add(List.of(x, y, a));
                        break;
                    }
                }
            }
        }

        build.sort((a, b) -> {
            if (Integer.compare(a.get(0), b.get(0)) != 0) {
                return Integer.compare(a.get(0), b.get(0));
            }
            if (Integer.compare(a.get(1), b.get(1)) != 0) {
                return Integer.compare(a.get(1), b.get(1));
            }
            return Integer.compare(a.get(2), b.get(2));
        });

        int[][] answer = new int[build.size()][3];
        for (int i = 0; i < build.size(); i++) {
            answer[i][0] = build.get(i).get(0);
            answer[i][1] = build.get(i).get(1);
            answer[i][2] = build.get(i).get(2);
        }
        return answer;
    }

    private boolean isInstallable(int x, int y, int a, List<List<Integer>> build) {
        if (a == 0) {
            return y == 0 || build.contains(List.of(x, y, 1)) || build.contains(List.of(x - 1, y, 1)) || build.contains(List.of(x, y - 1, 0));
        } else {
            return build.contains(List.of(x, y - 1, 0)) || build.contains(List.of(x + 1, y - 1, 0)) || (build.contains(List.of(x - 1, y, 1)) && build.contains(List.of(x + 1, y, 1)));
        }
    }
}