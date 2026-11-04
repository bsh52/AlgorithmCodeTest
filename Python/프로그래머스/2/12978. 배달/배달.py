import heapq


def solution(N, road, K):
    answer = 0
    d = {}
    for i in range(1, N + 1):
        d[i] = []

    for info in road:
        d[info[0]].append((info[1], info[2]))
        d[info[1]].append((info[0], info[2]))

    distance = [float("inf")] * (N + 1)
    distance[1] = 0
    pq = []
    heapq.heappush(pq, (0, 1))

    while pq:
        poll = heapq.heappop(pq)
        cur = poll[1]
        dist = poll[0]

        if dist > distance[cur]:
            continue

        for lst in d[cur]:
            nxt = lst[0]
            nxt_dist = lst[1] + distance[cur]

            if nxt_dist < distance[nxt]:
                distance[nxt] = nxt_dist
                heapq.heappush(pq, (nxt_dist, nxt))

    for i in distance:
        if i <= K:
            answer += 1

    return answer