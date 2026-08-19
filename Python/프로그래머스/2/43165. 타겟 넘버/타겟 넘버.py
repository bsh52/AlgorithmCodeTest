def solution(numbers, target):
    answer = 0

    def dfs(depth, sum):
        nonlocal answer
        if depth == len(numbers):
            if sum == target:
                answer += 1
            return
        dfs(depth + 1, sum + numbers[depth])
        dfs(depth + 1, sum - numbers[depth])

    dfs(0, 0)

    return answer