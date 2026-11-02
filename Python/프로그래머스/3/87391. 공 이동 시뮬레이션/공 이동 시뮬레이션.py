def solution(n, m, x, y, queries):
    min_x = max_x = x
    min_y = max_y = y

    for direct, num in reversed(queries):
        match direct:
            case 0:
                min_y = 0 if min_y == 0 else min_y + num
                max_y = min(max_y + num, m - 1)
            case 1:
                min_y = max(min_y - num, 0)
                max_y = m - 1 if max_y == m - 1 else max_y - num
            case 2:
                min_x = 0 if min_x == 0 else min_x + num
                max_x = min(max_x + num, n - 1)
            case 3:
                min_x = max(min_x - num, 0)
                max_x = n - 1 if max_x == n - 1 else max_x - num

        if min_x > max_x or min_y > max_y:
            return 0

    return (max_x - min_x + 1) * (max_y - min_y + 1)