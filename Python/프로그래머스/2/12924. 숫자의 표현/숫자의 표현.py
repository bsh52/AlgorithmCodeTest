def solution(n):
    answer = 0
    prefix = [0] * (n + 1)

    for i in range(1, n + 1):
        prefix[i] = prefix[i - 1] + i

    left = 0
    right = 1
    while left < right:
        sum = prefix[right] - prefix[left]
        if sum < n:
            right += 1
        else:
            left += 1
            if sum == n:
                answer += 1

    return answer