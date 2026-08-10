from collections import deque
def solution(maps):
    n, m = len(maps), len(maps[0])

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    q = deque([(0, 0)])

    while q:
        x, y = q.popleft()

        if x == n - 1 and y == m - 1:
            return maps[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or n <= nx or m <= ny or maps[nx][ny] == 0:
                continue

            if maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx, ny))

    return -1