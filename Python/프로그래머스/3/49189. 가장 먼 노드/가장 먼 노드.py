from collections import deque


def solution(n, edge):
    d = [[] for _ in range(n + 1)]
    for a, b in edge:
        d[a].append(b)
        d[b].append(a)

    dist = [-1] * (n + 1)
    dist[1] = 0

    q = deque([1])

    while q:
        cur = q.popleft()

        for next in d[cur]:
            if dist[next] == -1:
                dist[next] = dist[cur] + 1
                q.append(next)

    return dist.count(max(dist))