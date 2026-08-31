from collections import defaultdict


def solution(n, wires):
    answer = float("inf")
    d = defaultdict(list)

    for a, b in wires:
        d[a].append(b)
        d[b].append(a)

    def dfs(num):
        visited[num] = True
        count = 1

        for i in d[num]:
            if not visited[i]:
                count += dfs(i)

        return count

    for a, b in wires:
        visited = [False] * (n + 1)

        d[a].remove(b)
        d[b].remove(a)

        count = dfs(b)
        answer = min(answer, abs(count - (n - count)))

        d[a].append(b)
        d[b].append(a)

    return answer