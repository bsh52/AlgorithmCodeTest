from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    total = 0
    queue = deque()

    for truck in truck_weights:
        while True:
            if not queue:
                queue.append(truck)
                total += truck
                answer += 1
                break
            elif len(queue) == bridge_length:
                total -= queue.popleft()
            else:
                if total + truck <= weight:
                    queue.append(truck)
                    total += truck
                    answer += 1
                    break
                else:
                    queue.append(0)
                    answer += 1

    return answer + bridge_length