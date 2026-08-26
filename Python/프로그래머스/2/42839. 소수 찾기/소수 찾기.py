from itertools import permutations


def solution(numbers):
    answer = 0
    total = set()
    for i in range(1, len(numbers) + 1):
        for comb in permutations(numbers, i):
            target = ""
            for i in comb:
                target += i
            total.add(int(target))

    for num in total:
        if check(num):
            answer += 1
        else:
            continue

    return answer


def check(n):
    if n == 0 or n == 1:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True