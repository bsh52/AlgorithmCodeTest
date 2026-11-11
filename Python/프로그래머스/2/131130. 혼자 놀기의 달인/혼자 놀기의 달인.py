def solution(cards):
    n = len(cards)
    visited = [False] * n

    first = second = 0

    for i in range(n):
        if visited[i]:
            continue

        cnt = 0
        nxt = i

        while not visited[nxt]:
            visited[nxt] = True
            nxt = cards[nxt] - 1
            cnt += 1

        if cnt > first:
            first, second = cnt, first
        elif cnt > second:
            second = cnt

    return first * second