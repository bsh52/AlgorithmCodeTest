def solution(line):
    answer = []
    st = set()
    min_x = min_y = float("inf")
    max_x = max_y = float("-inf")

    for i, a in enumerate(line):
        for b in line[i + 1 :]:
            denominator = a[0] * b[1] - a[1] * b[0]
            if denominator == 0:
                continue
            numerator_x = a[1] * b[2] - a[2] * b[1]
            numerator_y = a[2] * b[0] - a[0] * b[2]
            if numerator_x % denominator != 0 or numerator_y % denominator != 0:
                continue

            x = numerator_x // denominator
            y = numerator_y // denominator

            min_x = min(min_x, x)
            min_y = min(min_y, y)
            max_x = max(max_x, x)
            max_y = max(max_y, y)

            st.add((x, y))

    x_len = max_x - min_x + 1
    y_len = max_y - min_y + 1

    answer = [["."] * x_len for _ in range(y_len)]

    for x, y in st:
        answer[max_y - y][x - min_x] = "*"

    return ["".join(row) for row in answer]