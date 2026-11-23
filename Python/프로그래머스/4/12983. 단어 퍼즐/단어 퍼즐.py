def solution(strs, t):
    dp = [float("inf")] * (len(t) + 1)
    dp[0] = 0
    for i in range(len(t)):
        for string in strs:
            if t.startswith(string, i):
                dp[i + len(string)] = min(dp[i + len(string)], dp[i] + 1)

    return -1 if dp[len(t)] == float("inf") else dp[len(t)]