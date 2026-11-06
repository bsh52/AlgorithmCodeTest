def solution(places):
    return [check(place) for place in places]


def check(place):
    p_lst = [
        (i, j) for i, row in enumerate(place) for j, ch in enumerate(row) if ch == "P"
    ]

    for i in range(len(p_lst)):
        for j in range(i + 1, len(p_lst)):
            r1, c1 = p_lst[i]
            r2, c2 = p_lst[j]

            dist = abs(r1 - r2) + abs(c1 - c2)

            if dist == 1:
                return 0

            if dist == 2 and not between_p(r1, c1, r2, c2, place):
                return 0

    return 1


def between_p(r1, c1, r2, c2, place):
    row1, row2 = sorted([r1, r2])
    col1, col2 = sorted([c1, c2])

    for i in range(row1, row2 + 1):
        for j in range(col1, col2 + 1):
            if place[i][j] not in ("X", "P"):
                return False

    return True