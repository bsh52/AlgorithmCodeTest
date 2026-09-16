def solution(routes):
    answer = 1
    routes = sorted(routes, key=lambda x: x[1])
    print(routes)
    min_num = routes[0][1]
    for a, b in routes:
        if min_num < a:
            answer += 1
            min_num = b
    return answer