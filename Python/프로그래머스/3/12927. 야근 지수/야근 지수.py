import heapq


def solution(n, works):
    answer = 0

    if sum(works) < n:
        return answer

    q = []
    for work in works:
        heapq.heappush(q, -work)

    while n > 0:
        m = heapq.heappop(q)
        if m == 0:
            break
        heapq.heappush(q, m + 1)
        n -= 1

    for i in q:
        answer += i**2

    return answer