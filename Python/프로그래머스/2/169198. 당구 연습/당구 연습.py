def solution(m, n, startX, startY, balls):
    answer = []

    for target_x, target_y in balls:
        distances = []

        if not (startY == target_y and startX <= target_x):
            distances.append(distance(startX, startY, m + (m - target_x), target_y))
        if not (startY == target_y and startX >= target_x):
            distances.append(distance(startX, startY, -target_x, target_y))
        if not (startX == target_x and startY <= target_y):
            distances.append(distance(startX, startY, target_x, n + (n - target_y)))
        if not (startX == target_x and startY >= target_y):
            distances.append(distance(startX, startY, target_x, -target_y))

        answer.append(min(distances))

    return answer


def distance(x1, y1, x2, y2):
    return (x2 - x1) ** 2 + (y2 - y1) ** 2