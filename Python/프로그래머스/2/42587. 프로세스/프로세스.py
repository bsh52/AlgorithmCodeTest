import heapq


def solution(priorities, location):
    answer = 0
    pq = []
    for val in priorities:
        heapq.heappush(pq, -val)

    while pq:
        for i in range(len(priorities)):
            if -pq[0] == priorities[i]:
                heapq.heappop(pq)
                answer += 1
                if i == location:
                    return answer

    return answer