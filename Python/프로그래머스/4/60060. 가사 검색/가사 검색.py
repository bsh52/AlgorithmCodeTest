from bisect import bisect_left, bisect_right
from collections import defaultdict


def solution(words, queries):
    word_map = defaultdict(list)
    reverse_word_map = defaultdict(list)

    for word in words:
        length = len(word)
        word_map[length].append(word)
        reverse_word_map[length].append(word[::-1])

    for lst in word_map.values():
        lst.sort()

    for lst in reverse_word_map.values():
        lst.sort()

    answer = []

    for query in queries:
        length = len(query)

        if query[0] != "?":
            lst = word_map[length]
            target = query
        else:
            lst = reverse_word_map[length]
            target = query[::-1]

        left = target.replace("?", "a")
        right = target.replace("?", "z")

        cnt = bisect_right(lst, right) - bisect_left(lst, left)
        answer.append(cnt)

    return answer