from collections import deque


def solution(storage, requests):
    chars = [list(c) for c in storage]
    for request in requests:
        c = request[0]
        if len(request) == 1:
            use_car(chars, c)
        else:
            use_crane(chars, c)

    return sum(c != "0" for row in chars for c in row)


def use_crane(chars, c):
    for i in range(len(chars)):
        for j in range(len(chars[0])):
            if chars[i][j] == c:
                chars[i][j] = "0"


def use_car(chars, c):
    rows, cols = len(chars), len(chars[0])
    visited = [[False] * cols for _ in range(rows)]

    q = deque()

    for i in range(rows):
        for j in range(cols):
            if i == 0 or j == 0 or i == rows - 1 or j == cols - 1:
                q.append((i, j))
                visited[i][j] = True

    directions = ((0, 1), (0, -1), (1, 0), (-1, 0))
    remove = []

    while q:
        x, y = q.popleft()

        if chars[x][y] == c:
            remove.append((x, y))
            continue

        if chars[x][y] != "0":
            continue

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < rows and 0 <= ny < cols and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))

    for x, y in remove:
        chars[x][y] = "0"