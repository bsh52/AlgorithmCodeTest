def solution(n):
    answer = ""
    nums = ["4", "1", "2"]

    while n > 0:
        mod = n % 3
        n //= 3

        if mod == 0:
            n -= 1

        answer = nums[mod] + answer

    return answer