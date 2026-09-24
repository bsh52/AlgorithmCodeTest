def solution(a):
    answer = 0
    left = [0] * len(a)
    right = [0] * len(a)

    first = a[0]
    for i in range(len(a)):
        if a[i] < first:
            first = a[i]
        left[i] = first

    last = a[len(a) - 1]
    for i in range(len(a) - 1, -1, -1):
        if a[i] < last:
            last = a[i]
        right[i] = last

    for i in range(len(a)):
        if not (left[i] < a[i] and right[i] < a[i]):
            answer += 1

    return answer