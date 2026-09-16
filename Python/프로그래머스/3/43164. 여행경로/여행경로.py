def solution(tickets):
    answer = []
    tickets.sort()
    n = len(tickets)
    visited = [False] * n

    def dfs(arr):
        if len(arr) == n + 1:
            answer.append(arr[:])
            return

        for i in range(n):
            if tickets[i][0] == arr[-1] and visited[i] == False:
                visited[i] = True
                arr.append(tickets[i][1])
                dfs(arr)
                arr.pop()
                visited[i] = False

    dfs(["ICN"])

    return answer[0]