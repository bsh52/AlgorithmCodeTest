import heapq as hq


def solution(coin, cards):
    answer = 1
    n = len(cards)
    target = n + 1
    order = [0] * target
    visited = [False] * target
    pq = []

    for i in range(n // 3):
        card = cards[i]
        pair = target - card
        order[card] = i
        visited[card] = True

        if visited[pair]:
            hq.heappush(pq, 0)

    for i in range(n // 3, n):
        card = cards[i]
        pair = target - card
        order[card] = i
        visited[card] = True

        if visited[pair]:
            if order[pair] < n // 3:
                hq.heappush(pq, 1)
            else:
                hq.heappush(pq, 2)

        if i % 2 == 1:
            if pq:
                cost = hq.heappop(pq)
                if coin >= cost:
                    coin -= cost
                    answer += 1
                else:
                    break
            else:
                break

    return answer