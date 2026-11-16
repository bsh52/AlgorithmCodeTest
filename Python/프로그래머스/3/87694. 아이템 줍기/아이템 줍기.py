from collections import deque


def solution(rectangle, characterX, characterY, itemX, itemY):
    rectangle = [[x1 * 2, y1 * 2, x2 * 2, y2 * 2] for x1, y1, x2, y2 in rectangle]

    board = [[0] * 102 for _ in range(102)]

    for x1, y1, x2, y2 in rectangle:
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                board[x][y] += 1

    start = (characterX * 2, characterY * 2)
    target = (itemX * 2, itemY * 2)

    queue = deque([(start[0], start[1], 0)])
    visited = {start}

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while queue:
        x, y, dist = queue.popleft()

        if (x, y) == target:
            return dist // 2

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if board[nx][ny] == 0 or (nx, ny) in visited:
                continue

            if any(x1 < nx < x2 and y1 < ny < y2 for x1, y1, x2, y2 in rectangle):
                continue

            visited.add((nx, ny))
            queue.append((nx, ny, dist + 1))

    return -1