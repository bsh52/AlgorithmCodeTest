def solution(alp, cop, problems):
    max_alp, max_cop = [max(problem[i] for problem in problems) for i in range(2)]

    alp = min(alp, max_alp)
    cop = min(cop, max_cop)

    dp = [[float("inf")] * (max_cop + 1) for _ in range(max_alp + 1)]

    dp[alp][cop] = 0

    for a in range(alp, max_alp + 1):
        for c in range(cop, max_cop + 1):
            if dp[a][c] == float("inf"):
                continue

            time = dp[a][c]

            if a < max_alp:
                dp[a + 1][c] = min(dp[a + 1][c], time + 1)

            if c < max_cop:
                dp[a][c + 1] = min(dp[a][c + 1], time + 1)

            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if a < alp_req or c < cop_req:
                    continue

                nxt_alp = min(max_alp, a + alp_rwd)
                nxt_cop = min(max_cop, c + cop_rwd)
                dp[nxt_alp][nxt_cop] = min(dp[nxt_alp][nxt_cop], time + cost)

    return dp[max_alp][max_cop]