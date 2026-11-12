def solution(cost, hint):
    answer = float("inf")
    hint_cnt = [0] * len(cost)
    max_hint = len(cost[0]) - 1

    def dfs(idx, total):
        nonlocal answer, max_hint

        if idx == len(cost):
            answer = min(answer, total)
            return
        result = total + cost[idx][min(hint_cnt[idx], max_hint)]
        if idx < len(hint):
            result += hint[idx][0]
            for i in range(1, len(hint[idx])):
                hint_cnt[hint[idx][i] - 1] += 1
            
            dfs(idx + 1, result)

            for i in range(1, len(hint[idx])):
                hint_cnt[hint[idx][i] - 1] -= 1
                
        result = total + cost[idx][min(hint_cnt[idx], max_hint)]
        dfs(idx + 1, result)

    dfs(0, 0)
    return answer