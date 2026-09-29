from collections import defaultdict


def solution(info, edges):
    d = defaultdict(list)
    answer = 0
    
    for a, b in edges:
        d[a].append(b)

    def dfs(sheep, wolf, lst):
        nonlocal answer

        if sheep <= wolf:
            return

        answer = max(answer, sheep)

        for next in lst:
            n_lst = lst.copy()

            n_lst.remove(next)

            if next in d:
                n_lst.extend(d[next])

            if info[next] == 0:
                dfs(sheep + 1, wolf, n_lst)
            else:
                dfs(sheep, wolf + 1, n_lst)

    dfs(1, 0, d[0])

    return answer