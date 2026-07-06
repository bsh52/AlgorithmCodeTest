import heapq
def solution(k, score):
    answer = []
    heap = []
    for e in score:
        heapq.heappush(heap, e)
        if len(heap) > k:
            heapq.heappop(heap)
        answer.append(heap[0])

    return answer