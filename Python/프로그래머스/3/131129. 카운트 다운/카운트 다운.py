def solution(target):
    dp = [[0] * 2 for _ in range(target + 1)]

    for i in range(1, target + 1):
        dp[i][0] = float("inf")
        dp[i][1] = 0

    for i in range(1, target + 1):
        for j in range(1, 21):
            if i - 50 >= 0:
                if dp[i][0] > dp[i - 50][0] + 1:
                    dp[i][0] = dp[i - 50][0] + 1
                    dp[i][1] = dp[i - 50][1] + 1
                elif dp[i][0] == dp[i - 50][0] + 1:
                    dp[i][1] = max(dp[i][1], dp[i - 50][1] + 1)

            if i - j >= 0:
                if dp[i][0] > dp[i - j][0] + 1:
                    dp[i][0] = dp[i - j][0] + 1
                    dp[i][1] = dp[i - j][1] + 1
                elif dp[i][0] == dp[i - j][0] + 1:
                    dp[i][1] = max(dp[i][1], dp[i - j][1] + 1)

            if i - 2 * j >= 0:
                if dp[i][0] > dp[i - 2 * j][0] + 1:
                    dp[i][0] = dp[i - 2 * j][0] + 1
                    dp[i][1] = dp[i - 2 * j][1]

            if i - 3 * j >= 0:
                if dp[i][0] > dp[i - 3 * j][0] + 1:
                    dp[i][0] = dp[i - 3 * j][0] + 1
                    dp[i][1] = dp[i - 3 * j][1]

    answer = dp[target]

    return answer