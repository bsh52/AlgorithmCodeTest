from collections import Counter
from itertools import combinations


def solution(orders, course):
    answer = []

    for count in course:
        menu = Counter()

        for order in orders:
            comb = combinations(sorted(order), count)
            menu.update("".join(c) for c in comb)

        if menu:
            max_count = max(menu.values())

            if max_count > 1:
                answer.extend(key for key, val in menu.items() if val == max_count)

    return sorted(answer)