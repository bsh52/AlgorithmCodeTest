def solution(key, lock):
    answer = False
    angle = 0

    key = expand(key, lock)

    while angle < 360:
        if check(key, lock):
            answer = True
            break
        angle += 90
        key = rotate(key)

    return answer


def rotate(key):
    rotated = [[0] * len(key) for _ in range(len(key))]

    for i in range(len(key)):
        for j in range(len(key)):
            rotated[j][len(key) - 1 - i] = key[i][j]

    return rotated


def expand(key, lock):
    size = len(key) + ((len(lock) - 1) * 2)
    expanded = [[0] * size for _ in range(size)]

    for i in range(len(key)):
        for j in range(len(key)):
            expanded[i + len(lock) - 1][j + len(lock) - 1] = key[i][j]

    return expanded


def check(key, lock):
    for i in range(len(key) - (len(lock) - 1)):
        for j in range(len(key) - (len(lock) - 1)):
            cnt = 0
            for k in range(len(lock)):
                for l in range(len(lock)):
                    if key[k + i][l + j] != lock[k][l]:
                        cnt += 1
            if cnt == len(lock) * len(lock):
                return True

    return False