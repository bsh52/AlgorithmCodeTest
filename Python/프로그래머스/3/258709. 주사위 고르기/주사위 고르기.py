from collections import defaultdict
from itertools import combinations, product


def solution(dice):
    answer = []
    n = len(dice)
    max_cnt = 0
    arr = [1, 2, 3]
    for choose in combinations(range(n), n // 2):
        choose_dice = [dice[i] for i in choose]

        A_probability = defaultdict(int)
        for p in product(*choose_dice):
            A_probability[sum(p)] += 1

        not_choose = tuple(set(range(n)) - set(choose))
        not_choose_dice = [dice[i] for i in not_choose]

        B_probability = defaultdict(int)
        for p in product(*not_choose_dice):
            B_probability[sum(p)] += 1

        presum = [0] * 501
        S = 0
        for i in range(501):
            if i in B_probability:
                S += B_probability[i]
            presum[i] = S

        cnt = 0
        for k, v in A_probability.items():
            cnt += v * presum[k - 1]

        if cnt > max_cnt:
            max_cnt = cnt
            answer = list(i + 1 for i in choose)

    return answer