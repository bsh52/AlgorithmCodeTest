def solution(n, m, x, y, r, c, k):
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    direction = ["d", "l", "r", "u"]
    x -= 1
    y -= 1
    r -= 1
    c -= 1

    distance = abs(x - r) + abs(y - c)

    if distance > k or (k - distance) % 2 != 0:
        return "impossible"

    answer = []

    for _ in range(k):
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if not (0 <= nx < n and 0 <= ny < m):
                continue

            remain = k - len(answer) - 1

            distance = abs(nx - r) + abs(ny - c)
            if remain < distance:
                continue

            if (remain - distance) % 2 != 0:
                continue

            answer.append(direction[i])
            x, y = nx, ny
            break

    return "".join(answer)