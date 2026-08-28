def solution(sequence, k):
    n = len(sequence)
    answer = []
    gap = n + 1
    arr_sum = [0] * (n + 1)
    arr_sum[1] = sequence[0]

    for i in range(n):
        arr_sum[i + 1] = arr_sum[i] + sequence[i]

    s, e = 0, 1
    while e < n + 1:
        if arr_sum[e] - arr_sum[s] == k:
            if e - s < gap:
                gap = e - s
                answer = [s, e - 1]
            s += 1
            e += 1
        elif arr_sum[e] - arr_sum[s] > k:
            s += 1
        else:
            e += 1

    return answer