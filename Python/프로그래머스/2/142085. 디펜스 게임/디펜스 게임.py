import heapq


def solution(n, k, enemy):
    answer = 0
    pq = []

    for i in range(len(enemy)):
        n -= enemy[i]
        heapq.heappush(pq, -enemy[i])

        if n < 0:
            if k > 0:
                n += -heapq.heappop(pq)
                k -= 1
            else:
                break

        answer += 1

    return answer