def solution(n):
    answer = [0] * ((n * (n + 1)) // 2)
    tri = [[0] * n for _ in range(n)]
    x, y, num, index = -1, 0, 1, 0

    for i in range(n):
        for j in range(i, n):
            if i % 3 == 0:
                x += 1
            elif i % 3 == 1:
                y += 1
            else:
                x -= 1
                y -= 1
            tri[x][y] = num
            num += 1

    for arr in tri:
        for i in arr:
            if i == 0:
                break
            answer[index] = i
            index += 1

    return answer