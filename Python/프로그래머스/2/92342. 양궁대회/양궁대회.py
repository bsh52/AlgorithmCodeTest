def solution(n, info):
    ryan = [0] * 11
    max_diff = -sum(10 - i for i, v in enumerate(info) if v > 0)
    comb = []

    def dfs(idx, remain, now):
        nonlocal max_diff, comb

        if remain == 0:
            if now > max_diff:
                max_diff = now
                comb = [ryan.copy()]
            elif now == max_diff:
                comb.append(ryan.copy())
            return

        if idx == 11:
            return

        for i in range(min(info[idx] + 1, remain) + 1):
            ryan[idx] = i
            next_now = now
            if i > info[idx]:
                next_now += (10 - idx) * (2 if info[idx] > 0 else 1)

            dfs(idx + 1, remain - i, next_now)
            ryan[idx] = 0

    dfs(0, n, max_diff)

    if max_diff <= 0:
        return [-1]

    for i in range(10, -1, -1):
        if len(comb) == 1:
            break

        max_point = max(r[i] for r in comb)
        comb = [r for r in comb if r[i] == max_point]

    return comb[0]