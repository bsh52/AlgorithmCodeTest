def solution(arr):
    n = len(arr) // 2 + 1
    nums = [0] * n
    ops = [""] * (n - 1)

    for i in range(n):
        nums[i] = int(arr[2 * i])
        if i < n - 1:
            ops[i] = arr[2 * i + 1]

    min_dp = [[0] * n for _ in range(n)]
    max_dp = [[0] * n for _ in range(n)]

    for i in range(n):
        min_dp[i][i] = max_dp[i][i] = nums[i]

    for length in range(2, n + 1):
        i = 0
        while i + length <= n:
            j = i + length - 1
            max_dp[i][j] = -float("inf")
            min_dp[i][j] = float("inf")

            for k in range(i, j):
                left_max = max_dp[i][k]
                left_min = min_dp[i][k]
                right_max = max_dp[k + 1][j]
                right_min = min_dp[k + 1][j]

                if ops[k] == "+":
                    max_val = left_max + right_max
                    min_val = left_min + right_min
                else:
                    max_val = left_max - right_min
                    min_val = left_min - right_max

                max_dp[i][j] = max(max_dp[i][j], max_val)
                min_dp[i][j] = min(min_dp[i][j], min_val)
            i += 1

    return max_dp[0][n - 1]