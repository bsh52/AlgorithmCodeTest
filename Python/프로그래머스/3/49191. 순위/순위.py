def solution(n, results):
    answer = 0
    arr = [[0] * (n + 1) for _ in range(n + 1)]
    for a, b in results:
        arr[a][b] = 1
        arr[b][a] = -1

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            for k in range(1, n + 1):
                if arr[i][k] == 1 and arr[k][j] == 1:
                    arr[i][j] = 1
                    arr[j][i] = -1
                if arr[i][k] == -1 and arr[k][j] == -1:
                    arr[i][j] = -1
                    arr[j][i] = 1

    for lst in arr:
        cnt = 0
        for i in lst:
            if i == 1 or i == -1:
                cnt += 1
        if cnt == n - 1:
            answer += 1

    return answer