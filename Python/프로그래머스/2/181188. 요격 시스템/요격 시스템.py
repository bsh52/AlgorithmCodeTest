def solution(targets):
    answer = 0
    targets.sort(key=lambda x: x[1])
    point = 0
    for x, y in targets:
        if point <= x:
            point = y
            answer += 1
    return answer