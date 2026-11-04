from collections import deque


def solution(players, m, k):
    answer = 0
    now_server = 0
    que = deque()
    for player in players:
        if len(que) >= k:
            removed = que.popleft()
            now_server -= removed
        need = max(0, player // m - now_server)
        now_server += need
        answer += need
        que.append(need)
    return answer