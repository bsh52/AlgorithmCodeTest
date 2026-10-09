def solution(e, starts):
    divisors = [0] * (e + 1)

    for i in range(1, e + 1):
        for j in range(i, e + 1, i):
            divisors[j] += 1

    maxi, idx = 0, 0

    for i in range(e, 0, -1):
        if divisors[i] >= maxi:
            maxi = divisors[i]
            idx = i
        divisors[i] = idx

    return [divisors[s] for s in starts]