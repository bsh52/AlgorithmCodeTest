class Solution {
    int m = 0, n = 0;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        m = key.length;
        n = lock.length;
        int angle = 0;

        key = expand(key);

        while (angle < 360) {
            if (check(key, lock)) {
                answer = true;
                break;
            }
            angle += 90;
            key = rotate(key);
        }

        return answer;
    }

    int[][] rotate(int[][] key) {
        int[][] rotated = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotated[j][key.length - 1 - i] = key[i][j];
            }
        }

        return rotated;
    }

    int[][] expand(int[][] key) {
        int[][] expanded = new int[m + ((n - 1) * 2)][m + ((n - 1) * 2)];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                expanded[i + n - 1][j + n - 1] = key[i][j];
            }
        }

        return expanded;
    }

    boolean check(int[][] key, int[][] lock) {
        for (int i = 0; i < key.length - (n - 1); i++) {
            for (int j = 0; j < key.length - (n - 1); j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (key[k + i][l + j] != lock[k][l]) {
                            count++;
                        }
                    }
                }
                if (count == n * n) {
                    return true;
                }
            }
        }

        return false;
    }
}