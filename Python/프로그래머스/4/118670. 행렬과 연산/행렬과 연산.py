from collections import deque


def solution(rc, operations):
    left = deque(row[0] for row in rc)
    right = deque(row[-1] for row in rc)
    center = deque(deque(row[1:-1]) for row in rc)

    for op in operations:
        if op == "Rotate":
            center[0].appendleft(left.popleft())
            right.appendleft(center[0].pop())
            center[-1].append(right.pop())
            left.append(center[-1].popleft())
        else:
            left.rotate(1)
            right.rotate(1)
            center.rotate(1)

    return [[l, *c, r] for l, c, r in zip(left, center, right)]