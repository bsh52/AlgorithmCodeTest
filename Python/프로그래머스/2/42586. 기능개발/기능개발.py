from collections import deque


def solution(progresses, speeds):
    answer = []

    q = deque()
    for i in range(len(progresses)):
        q.append((100 - progresses[i] + speeds[i] - 1) // speeds[i])

    while q:
        cnt = 1
        cur = q.popleft()
        while q and q[0] <= cur:
            q.popleft()
            cnt += 1
        answer.append(cnt)

    return answer