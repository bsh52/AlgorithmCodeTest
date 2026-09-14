from collections import deque


def solution(begin, target, words):
    answer = 0
    q = deque([(0, begin)])
    visited = [False] * len(words)

    while q:
        cnt, cur = q.popleft()

        if cur == target:
            return cnt

        for i in range(len(words)):
            if change(cur, words[i]) and not visited[i]:
                q.append((cnt + 1, words[i]))
                visited[i] = True
            else:
                continue

    return answer


def change(current, target):
    cnt = 0

    for i in range(len(current)):
        if current[i] == target[i]:
            cnt += 1

    if cnt == len(current) - 1:
        return 1
    else:
        return 0