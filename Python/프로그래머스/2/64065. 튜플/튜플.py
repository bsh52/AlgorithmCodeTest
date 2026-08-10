import re


def solution(s):
    d = {}
    for i in re.findall(r"\d+", s):
        d[i] = d.get(i, 0) + 1

    return [int(k) for k, v in sorted(d.items(), key=lambda x: x[1], reverse=True)]