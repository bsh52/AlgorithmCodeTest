import heapq as hq


def solution(n, paths, gates, summits):
    graph = [[] for _ in range(n + 1)]
    for a, b, w in paths:
        graph[a].append((b, w))
        graph[b].append((a, w))

    is_gate = [False] * (n + 1)
    is_summit = [False] * (n + 1)

    for gate in gates:
        is_gate[gate] = True
    for summit in summits:
        is_summit[summit] = True

    intensity_list = [float("inf")] * (n + 1)

    pq = []

    for gate in gates:
        hq.heappush(pq, (0, gate))
        intensity_list[gate] = 0

    while pq:
        intensity, cur = hq.heappop(pq)

        if intensity > intensity_list[cur]:
            continue

        if is_summit[cur]:
            continue

        for next, weight in graph[cur]:
            if is_gate[next]:
                continue

            next_intensity = max(intensity, weight)

            if intensity_list[next] > next_intensity:
                intensity_list[next] = next_intensity
                hq.heappush(pq, (next_intensity, next))

    answer = [0, float("inf")]
    for summit in sorted(summits):
        if intensity_list[summit] < answer[1]:
            answer = [summit, intensity_list[summit]]

    return answer