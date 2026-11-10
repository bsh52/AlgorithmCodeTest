def solution(n):
    answer = 0
    cols = [0] * n

    def check(depth):
        nonlocal answer
        if depth == n:
            answer += 1
            return
        for i in range(n):
            cols[depth] = i
            if possible(depth):
                check(depth + 1)

    def possible(depth):
        for i in range(depth):
            if cols[i] == cols[depth]:
                return False
            if abs(cols[i] - cols[depth]) == abs(depth - i):
                return False
        return True

    check(0)
    return answer