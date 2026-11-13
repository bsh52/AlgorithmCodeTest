def solution(n, l, r):
    return count(r - 1) - count(l - 2)


def count(x):
    if x < 0:
        return 0

    digits = []

    while x > 0:
        digits.append(x % 5)
        x //= 5

    digits.reverse()

    answer = 0
    length = len(digits)

    for i, digit in enumerate(digits):
        remain = length - 1 - i
        smaller = sum(1 for d in [0, 1, 3, 4] if d < digit)
        answer += smaller * (4**remain)
        if digit == 2:
            return answer

    return answer + 1