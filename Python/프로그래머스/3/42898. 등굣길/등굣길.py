def solution(m, n, puddles):
    route = [[0] * (m + 1) for _ in range(n + 1)]

    for i, j in puddles:
        route[j][i] = -1
    route[1][1] = 1

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if route[i][j] == -1:
                continue

            if route[i - 1][j] != -1:
                route[i][j] += route[i - 1][j]

            if route[i][j - 1] != -1:
                route[i][j] += route[i][j - 1]

            route[i][j] %= 1000000007

    return route[n][m]