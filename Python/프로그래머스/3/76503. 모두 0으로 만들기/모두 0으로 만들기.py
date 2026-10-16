def solution(a, edges):
    if sum(a) != 0:
        return -1
    n = len(a)

    graph = [[] for _ in range(n)]

    for x, y in edges:
        graph[x].append(y)
        graph[y].append(x)

    parent = [-1] * n
    order = []
    stack = [0]

    while stack:
        node = stack.pop()
        order.append(node)

        for child in graph[node]:
            if child == parent[node]:
                continue

            parent[child] = node
            stack.append(child)

    answer = 0

    for node in reversed(order[1:]):
        answer += abs(a[node])
        a[parent[node]] += a[node]

    return answer