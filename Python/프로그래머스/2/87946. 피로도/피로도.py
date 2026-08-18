from itertools import permutations


def solution(k, dungeons):
    answer = 0
    for per in permutations(dungeons):
        cnt, limit = 0, k
        for i, j in per:
            if limit >= i:
                limit -= j
                cnt += 1
        answer = max(cnt, answer)
    return answer