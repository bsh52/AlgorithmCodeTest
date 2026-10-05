from collections import Counter


def solution(a):
    answer = -1
    d = Counter(a)
    for key in d:
        if d[key] <= answer:
            continue

        cnt = 0
        i = 0

        while i < len(a) - 1:
            if (a[i] == key or a[i + 1] == key) and a[i] != a[i + 1]:
                cnt += 1
                i += 2
            else:
                i += 1
        answer = max(answer, cnt)
    return answer * 2