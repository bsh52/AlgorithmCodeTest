def solution(cookie):
    answer = 0
    n = len(cookie)

    for i in range(n - 1):
        left = i
        right = i + 1
        left_sum = cookie[left]
        right_sum = cookie[right]

        while True:
            if left_sum == right_sum:
                answer = max(answer, left_sum)

            if left_sum <= right_sum:
                left -= 1
                if left < 0:
                    break
                left_sum += cookie[left]
            else:
                right += 1
                if right >= n:
                    break
                right_sum += cookie[right]

    return answer