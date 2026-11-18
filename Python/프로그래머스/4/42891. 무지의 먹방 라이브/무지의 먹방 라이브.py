import heapq


def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    pq = []

    for i, food in enumerate(food_times):
        heapq.heappush(pq, (food, i + 1))

    time = cnt = 0

    while (pq[0][0] - cnt) * len(pq) <= k - time:
        size = len(pq)
        food = heapq.heappop(pq)
        time += (food[0] - cnt) * size
        cnt = food[0]

    lst = pq
    lst.sort(key=lambda x: x[1])

    return lst[(k - time) % len(lst)][1]