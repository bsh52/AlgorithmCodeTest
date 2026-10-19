from collections import defaultdict
import sys

sys.setrecursionlimit(10**6)


def solution(n, lighthouse):
    answer = 0
    d = defaultdict(list)
    visited = [False] * (n + 1)
    for x, y in lighthouse:
        d[x].append(y)
        d[y].append(x)

    def dfs(parent, node):
        nonlocal answer
        for child in d[node]:
            if child == parent:
                continue
            dfs(node, child)
            if not visited[node] and not visited[child]:
                visited[node] = True
                answer += 1

    dfs(1, 1)

    return answer