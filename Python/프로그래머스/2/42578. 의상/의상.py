def solution(clothes):
    answer = 1
    d = {}
    for val, key in clothes:
        if key not in d:
            d[key] = []
        d[key].append(val)

    for key in d:
        answer *= len(d.get(key)) + 1

    return answer - 1