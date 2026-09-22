from collections import deque


def solution(n, roads, sources, destination):
    answer = [0] * len(sources)
    d = {}

    for i in range(1, n + 1):
        d[i] = []

    for a, b in roads:
        d.get(a).append(b)
        d.get(b).append(a)

    visited = [False] * (n + 1)
    time = [-1] * (n + 1)
    q = deque()
    q.append(destination)
    visited[destination] = True
    time[destination] = 0

    while q:
        cur = q.popleft()

        for next in d.get(cur):
            if not visited[next]:
                visited[next] = True
                q.append(next)
                time[next] = time[cur] + 1

    for i in range(len(sources)):
        answer[i] = time[sources[i]]

    return answer