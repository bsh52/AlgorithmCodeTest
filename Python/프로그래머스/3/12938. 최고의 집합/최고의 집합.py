def solution(n, s):
    if n > s:
        return [-1]

    div = s // n
    rem = s % n

    answer = [div] * n

    for i in range(0, rem):
        answer[n - 1 - i] += 1

    return answer