from collections import deque


def solution(x, y, n):
    q = deque()
    q.append((x, 0))
    visited = set()

    while q:
        cur, cnt = q.popleft()
        if cur == y:
            return cnt
        if cur > y or cur in visited:
            continue
        visited.add(cur)

        q.append((cur + n, cnt + 1))
        q.append((cur * 2, cnt + 1))
        q.append((cur * 3, cnt + 1))

    return -1