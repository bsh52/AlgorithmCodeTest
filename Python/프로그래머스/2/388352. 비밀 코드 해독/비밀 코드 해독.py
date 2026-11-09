def solution(n, q, ans):
    answer = 0

    def dfs(start, depth, arr):
        nonlocal answer
        if depth == 5:
            if check_answer(q, ans, arr):
                answer += 1
            return

        for i in range(start, n + 1):
            arr[depth] = i
            dfs(i + 1, depth + 1, arr)

    dfs(1, 0, [0] * 5)

    return answer


def check_answer(q, ans, arr):
    for i in range(len(q)):
        q_count = 0

        for num in q[i]:
            if num in arr:
                q_count += 1

        if q_count != ans[i]:
            return False

    return True