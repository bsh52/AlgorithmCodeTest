def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    left = 0
    right = distance

    while left <= right:
        mid = (left + right) // 2

        if get_count(rocks, distance, mid) <= n:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

    return answer


def get_count(rocks, distance, mid):
    start = 0
    remove = 0

    for rock in rocks:
        if rock - start < mid:
            remove += 1
            continue
        start = rock

    if distance - start < mid:
        remove += 1

    return remove