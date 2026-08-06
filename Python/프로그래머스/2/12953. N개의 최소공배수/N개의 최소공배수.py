from math import gcd


def solution(arr):
    answer = 1
    for val in arr:
        tmp = gcd(answer, val)
        answer = answer * val // tmp

    return answer