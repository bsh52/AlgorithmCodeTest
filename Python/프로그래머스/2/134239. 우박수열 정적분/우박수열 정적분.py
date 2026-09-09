def solution(k, ranges):
    answer = [0] * len(ranges)
    arr = []
    n = 0
    while k != 1:
        arr.append((n, k))
        if k % 2 == 0:
            k = k // 2
        else:
            k = k * 3 + 1
        n += 1
    arr.append((n, k))

    area = [0] * n
    for i in range(n):
        area[i] = get_area(i, i + 1, arr)

    for i, val in enumerate(ranges):
        if val[0] > n + val[1]:
            answer[i] = -1.0
            continue
        answer[i] = get_sum(val[0], n + val[1], area)

    return answer


def get_sum(start, end, area):
    result = 0
    for i in range(start, end):
        result += area[i]
    return result


def get_area(start, end, arr):
    min_height = min(arr[start][1], arr[end][1])
    gap = abs(arr[end][1] - arr[start][1])
    return min_height + gap / 2