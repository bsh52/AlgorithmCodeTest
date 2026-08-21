import heapq


def solution(scoville, K):
    answer = 0
    pq = scoville
    heapq.heapify(pq)

    while pq[0] < K:
        if len(pq) < 2:
            return -1
        heapq.heappush(pq, heapq.heappop(pq) + (heapq.heappop(pq) * 2))
        answer += 1

    return answer