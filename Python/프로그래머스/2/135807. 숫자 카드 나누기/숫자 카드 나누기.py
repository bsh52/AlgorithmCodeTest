from math import gcd


def solution(arrayA, arrayB):
    answer = 0

    def isDivisible(arr, num):
        for i in arr:
            if i % num == 0:
                return True
        return False

    a = arrayA[0]
    b = arrayB[0]

    for i in range(len(arrayA)):
        a = gcd(a, arrayA[i])
        b = gcd(b, arrayB[i])

    if not isDivisible(arrayA, b):
        answer = max(answer, b)

    if not isDivisible(arrayB, a):
        answer = max(answer, a)

    return answer