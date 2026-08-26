from collections import deque

def solution(queue1, queue2):
    answer = 0
    q1, q2 = deque(queue1), deque(queue2)
    s1, s2 = sum(q1), sum(q2)
    
    if (s1 + s2) % 2 != 0:
        return -1
    
    while s1 != s2:
        if answer > len(queue1) * 2 + 1:
            return -1
        if s1 < s2:
            cur = q2.popleft()
            q1.append(cur)
            s2 -= cur
            s1 += cur
        else:
            cur = q1.popleft()
            q2.append(cur)
            s1 -= cur
            s2 += cur
        answer += 1
            
    return answer