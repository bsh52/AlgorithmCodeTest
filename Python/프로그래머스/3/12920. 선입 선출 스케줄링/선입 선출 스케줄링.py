def solution(n, cores):
    answer = 0
    left, right = 0, 100000
    time = 0

    while left <= right:
        mid = (left + right) // 2

        cnt = len(cores)
        for core in cores:
            cnt += mid // core

        if cnt >= n:
            right = mid - 1
            time = mid
        else:
            left = mid + 1

    prev = len(cores)
    for core in cores:
        prev += (time - 1) // core
    remain = n - prev

    for i in range(len(cores)):
        if time % cores[i] == 0:
            remain -= 1
            if remain == 0:
                answer = i + 1
                break

    return answer