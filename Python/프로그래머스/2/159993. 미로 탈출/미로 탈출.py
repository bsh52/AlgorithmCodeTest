def solution(maps):
    start = None
    lever = None
    end = None

    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j] == "S":
                start = (i, j)
            if maps[i][j] == "L":
                lever = (i, j)
            if maps[i][j] == "E":
                end = (i, j)

    start_lever = bfs(start, lever, maps)
    if start_lever == -1:
        return -1

    lever_end = bfs(lever, end, maps)
    if lever_end == -1:
        return -1

    return start_lever + lever_end


def bfs(start, target, maps):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    visited = [[False] * (len(maps[0])) for _ in range(len(maps))]
    visited[start[0]][start[1]] = True
    q = [(start[0], start[1], 0)]

    while q:
        x, y, dist = q.pop(0)

        if (x, y) == target:
            return dist

        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if (
                0 <= nx < len(maps)
                and 0 <= ny < len(maps[0])
                and maps[nx][ny] != "X"
                and not visited[nx][ny]
            ):
                visited[nx][ny] = True
                q.append((nx, ny, dist + 1))

    return -1