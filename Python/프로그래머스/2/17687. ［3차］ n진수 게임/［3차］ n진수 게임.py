def solution(n, t, m, p):
    answer = "0"
    s = "0123456789ABCDEF"

    for num in range(1, t * m):
        base = ""
        while num > 0:
            num, mod = divmod(num, n)
            base += s[mod]
        answer += base[::-1]

    return answer[p - 1 :: m][:t]