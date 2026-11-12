def solution(info, n, m):
    answer = float("inf")
    visited = [[[False] * (m + 1) for _ in range(n + 1)] for __ in range(len(info) + 1)]

    def dfs(depth, a_total, b_total):
        nonlocal answer

        if visited[depth][a_total][b_total]:
            return

        if depth == len(info):
            answer = min(answer, a_total)
            return

        visited[depth][a_total][b_total] = True

        if b_total + info[depth][1] < m:
            dfs(depth + 1, a_total, b_total + info[depth][1])

        if a_total + info[depth][0] < n:
            dfs(depth + 1, a_total + info[depth][0], b_total)

    dfs(0, 0, 0)

    return answer if answer != float("inf") else -1