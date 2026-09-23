from collections import defaultdict
import heapq


def solution(n, costs):
    answer = 0
    d = defaultdict(list)

    for a, b, c in costs:
        d[a].append((b, c))
        d[b].append((a, c))

    visited = [False] * n
    q = [(0, 0)]

    while q:
        cost, node = heapq.heappop(q)

        if visited[node]:
            continue

        visited[node] = True
        answer += cost

        for n_node, n_cost in d[node]:
            if not visited[n_node]:
                heapq.heappush(q, (n_cost, n_node))

    return answer