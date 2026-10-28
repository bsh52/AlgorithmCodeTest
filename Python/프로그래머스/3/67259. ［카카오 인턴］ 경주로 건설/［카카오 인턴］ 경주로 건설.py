import heapq as hq


def solution(board):
    n = len(board)
    costs = [[[float("inf")] * 4 for _ in range(n)] for _ in range(n)]

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    pq = []
    hq.heappush(pq, [0, 0, 0, 1])
    hq.heappush(pq, [0, 0, 0, 2])

    while pq:
        cur = hq.heappop(pq)
        cost = cur[0]
        x = cur[1]
        y = cur[2]
        dir = cur[3]

        if x == n - 1 and y == n - 1:
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if n <= nx or nx < 0 or n <= ny or ny < 0 or board[nx][ny] == 1:
                continue
            n_cost = cost + 100 if dir == i else cost + 600
            if costs[nx][ny][i] >= n_cost:
                costs[nx][ny][i] = n_cost
                hq.heappush(pq, [n_cost, nx, ny, i])

    return min(costs[n - 1][n - 1])