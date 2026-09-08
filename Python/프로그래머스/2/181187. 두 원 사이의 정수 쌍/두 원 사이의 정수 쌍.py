from math import ceil, floor, sqrt


def solution(r1, r2):
    answer = 0
    for i in range(1, r2 + 1):
        min_y = 0 if i > r1 else ceil(sqrt(r1 * r1 - i * i))
        max_y = floor(sqrt(r2 * r2 - i * i))
        answer += max_y - min_y + 1
    return answer * 4