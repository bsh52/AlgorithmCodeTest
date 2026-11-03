def solution(arr):
    answer = [0, 0]

    def dfs(x, y, n):
        start = arr[x][y]
        if all(arr[i][j] == start for i in range(x, x + n) for j in range(y, y + n)):
            answer[start] += 1
            return
        size = n // 2
        dfs(x, y, size)
        dfs(x, y + size, size)
        dfs(x + size, y, size)
        dfs(x + size, y + size, size)

    dfs(0, 0, len(arr))
    return answer