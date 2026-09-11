def solution(triangle):
    n = len(triangle)
    arr = [[0] * n for _ in range(n)]
    arr[0][0] = triangle[0][0]
    for i in range(1, n):
        arr[i][0] = arr[i - 1][0] + triangle[i][0]

        for j in range(1, i + 1):
            arr[i][j] = max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j]

    return max(arr[len(arr) - 1])