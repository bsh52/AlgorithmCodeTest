def solution(n, times):
    answer = 0
    minimum = 0
    maximum = times[len(times) - 1] * n
    times.sort()

    while minimum <= maximum:
        mid = (minimum + maximum) // 2
        cnt = 0

        for time in times:
            cnt += mid // time

        if cnt >= n:
            maximum = mid - 1
            answer = mid
        else:
            minimum = mid + 1

    return answer