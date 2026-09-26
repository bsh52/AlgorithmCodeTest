def solution(scores):
    answer = 1
    a, b = scores[0]
    total = a + b

    scores = sorted(scores, key=lambda x: (-x[0], x[1]))

    tmp = 0
    for x, y in scores:
        if a < x and b < y:
            return -1

        if tmp <= y:
            tmp = y
            if x + y > total:
                answer += 1

    return answer