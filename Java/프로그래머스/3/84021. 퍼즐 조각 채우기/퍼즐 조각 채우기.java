import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<int[][]> holes = new ArrayList<>();
        List<int[][]> pieces = new ArrayList<>();

        getList(game_board, holes, 0);
        getList(table, pieces, 1);

        boolean[] used = new boolean[pieces.size()];
        int answer = 0;

        for (int[][] hole : holes) {
            for (int i = 0; i < pieces.size(); i++) {
                int[][] piece = pieces.get(i);
                if (!used[i] && hole.length == piece.length && matchPiece(hole, piece)) {
                    answer += piece.length;
                    used[i] = true;
                    break;
                }
            }
        }

        return answer;
    }

    private boolean matchPiece(int[][] hole, int[][] piece) {
        int[][] copy = piece.clone();

        for (int i = 0; i < 4; i++) {
            rotate(copy);
            if (sameShape(hole, copy)) {
                return true;
            }
        }

        return false;
    }

    private boolean sameShape(int[][] hole, int[][] piece) {
        Comparator<int[]> comparator = (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        Arrays.sort(hole, comparator);
        Arrays.sort(piece, comparator);

        int holeXMin = Integer.MAX_VALUE;
        int holeYMin = Integer.MAX_VALUE;
        for (int[] a : hole) {
            holeXMin = Math.min(holeXMin, a[0]);
            holeYMin = Math.min(holeYMin, a[1]);
        }

        int pieceXMin = Integer.MAX_VALUE;
        int pieceYMin = Integer.MAX_VALUE;
        for (int[] b : piece) {
            pieceXMin = Math.min(pieceXMin, b[0]);
            pieceYMin = Math.min(pieceYMin, b[1]);
        }

        for (int i = 0; i < hole.length; i++) {
            int holeX = hole[i][0] - holeXMin;
            int holeY = hole[i][1] - holeYMin;
            int pieceX = piece[i][0] - pieceXMin;
            int pieceY = piece[i][1] - pieceYMin;

            if (holeX != pieceX || holeY != pieceY) return false;
        }

        return true;
    }

    private void rotate(int[][] copy) {
        for (int i = 0; i < copy.length; i++) {
            copy[i] = new int[]{copy[i][1], -copy[i][0]};
        }
    }

    private void getList(int[][] target, List<int[][]> list, int num) {
        int n = target.length;
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != num || visited[i][j]) continue;

                List<int[]> block = new ArrayList<>();
                Deque<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    block.add(cur);
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || target[nx][ny] != num) continue;
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                list.add(block.toArray(new int[0][]));
            }
        }
    }
}