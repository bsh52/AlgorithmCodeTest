def solution(begin, end):
    return [get_max_divisor(i) for i in range(begin, end + 1)]


def get_max_divisor(n):
    if n == 1:
        return 0

    arr = [1]
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            arr.append(i)
            if n // i <= 10_000_000:
                arr.append(n // i)

    return max(arr)