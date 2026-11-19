def solution(n):
    return make(0, 0, n)


def make(left, right, n):
    if left == n and right == n:
        return 1

    cnt = 0

    if left < n:
        cnt += make(left + 1, right, n)
    if right < left:
        cnt += make(left, right + 1, n)

    return cnt