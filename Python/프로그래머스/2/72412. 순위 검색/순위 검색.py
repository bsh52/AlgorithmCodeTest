from bisect import bisect_left
from collections import defaultdict
from itertools import product


def solution(info, query):
    answer = []
    cache = defaultdict(list)

    for person in info:
        conditions = person.split()
        score = int(conditions[4])

        for combination in product(*[(condition, "-") for condition in conditions[:4]]):
            cache[combination].append(score)

    for scores in cache.values():
        scores.sort()

    for q in query:
        q_arr = q.replace(" and", " ").split()

        key = tuple(q_arr[:4])
        target_score = int(q_arr[4])

        scores = cache[key]

        answer.append(len(scores) - bisect_left(scores, target_score))

    return answer