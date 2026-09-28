def solution(n, s, a, b, fares):
    floyd = [[float("inf")] * (n + 1) for _ in range(n + 1)]

    for edgeA, edgeB, edgeC in fares:
        floyd[edgeA][edgeB] = floyd[edgeB][edgeA] = edgeC

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j:
                    floyd[i][j] = 0
                    continue
                floyd[i][j] = min(floyd[i][j], floyd[i][k] + floyd[k][j])

    answer = floyd[s][a] + floyd[s][b]
    for i in range(1, n + 1):
        answer = min(floyd[s][i] + floyd[i][a] + floyd[i][b], answer)

    return answer