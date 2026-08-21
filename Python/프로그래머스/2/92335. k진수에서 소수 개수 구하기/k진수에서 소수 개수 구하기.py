def solution(n, k):
    answer = 0
    arr = base(n, k).split("0")
    for num in arr:
        if num and isPrime(int(num)):
            answer += 1
    return answer


def isPrime(n):
    if n < 2:
        return False

    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False

    return True


def base(n, q):
    result = ""
    while n > 0:
        n, remainder = divmod(n, q)
        result += str(remainder)
    return result[::-1]