def solution(k, tangerine):
    answer = 0
    d = {}

    for i in tangerine:
        d[i] = d.get(i, 0) + 1

    lst = list(d.keys())
    lst.sort(key=lambda i: d[i], reverse=True)

    for i in lst:
        if k <= 0:
            break

        answer += 1
        k -= d[i]

    return answer