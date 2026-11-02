def solution(dirs):
    lst = set()
    start_x = start_y = 0

    for i in range(len(dirs)):
        end_x = start_x
        end_y = start_y
        s = ""

        match dirs[i]:
            case "U":
                end_y += 1
                s += "".join(map(str, (start_x, start_y, end_x, end_y)))
            case "D":
                end_y -= 1
                s += "".join(map(str, (end_x, end_y, start_x, start_y)))
            case "L":
                end_x -= 1
                s += "".join(map(str, (end_x, end_y, start_x, start_y)))
            case "R":
                end_x += 1
                s += "".join(map(str, (start_x, start_y, end_x, end_y)))

        if end_x > 5 or end_x < -5 or end_y > 5 or end_y < -5:
            continue

        lst.add(s)
        start_x = end_x
        start_y = end_y

    return len(lst)