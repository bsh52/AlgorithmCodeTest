from collections import deque


def solution(land):
    n = len(land)
    m = len(land[0])

    col_sum = [0] * m
    visited = [[False] * m for _ in range(n)]
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for i in range(m):
        for j in range(n):
            if land[j][i] == 0 or visited[j][i]:
                continue

            q = deque([(j, i)])
            visited[j][i] = True
            count = 0
            columns = set()

            while q:
                cx, cy = q.popleft()
                count += 1
                columns.add(cy)

                for k in range(4):
                    nx = cx + dx[k]
                    ny = cy + dy[k]

                    if (
                        nx < 0
                        or nx >= n
                        or ny < 0
                        or ny >= m
                        or visited[nx][ny]
                        or land[nx][ny] == 0
                    ):
                        continue

                    q.append((nx, ny))
                    visited[nx][ny] = True

            for column in columns:
                col_sum[column] += count

    return max(col_sum)