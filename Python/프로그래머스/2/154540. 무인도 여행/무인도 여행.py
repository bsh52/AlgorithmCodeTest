def solution(maps):
    answer = []
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * len(maps[0]) for _ in range(len(maps))]

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for i in range(n):
        for j in range(m):
            if maps[i][j] != "X" and not visited[i][j]:
                stack = [(i, j)]
                visited[i][j] = True
                day = 0

                while stack:
                    x, y = stack.pop()
                    day += int(maps[x][y])

                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]

                        if nx < 0 or ny < 0 or nx >= n or ny >= m:
                            continue

                        if maps[nx][ny] != "X" and not visited[nx][ny]:
                            visited[nx][ny] = True
                            stack.append((nx, ny))

                answer.append(day)

    if not answer:
        return [-1]

    answer.sort()

    return answer