def solution(beginning, target):
    answer = 0
    diff = [[0] * len(beginning[0]) for _ in range(len(beginning))]
    for i in range(len(beginning)):
        for j in range(len(beginning[i])):
            if beginning[i][j] != target[i][j]:
                diff[i][j] = 1
            else:
                diff[i][j] = 0

    mini = min(flip1(diff), flip2(diff))

    flip_row(diff, 0)
    mini2 = min(flip1(diff), flip2(diff)) + 1

    answer = min(mini, mini2)
    return answer


def copy_arr(beginning):
    arr = [[0] * len(beginning[0]) for _ in range(len(beginning))]
    for i in range(len(beginning)):
        arr[i] = beginning[i].copy()
    return arr


def flip1(diff):
    arr = copy_arr(diff)
    cnt = 0
    for i in range(len(arr)):
        if arr[i][0] == 1:
            flip_row(arr, i)
            cnt += 1

    for i in range(len(arr[0])):
        if arr[0][i] == 1:
            flip_col(arr, i)
            cnt += 1

    if all(1 not in row for row in arr):
        return cnt

    return -1


def flip2(diff):
    arr = copy_arr(diff)
    cnt = 0
    for i in range(len(arr[0])):
        if arr[0][i] == 1:
            flip_col(arr, i)
            cnt += 1

    for i in range(len(arr)):
        if arr[i][0] == 1:
            flip_row(arr, i)
            cnt += 1

    if all(1 not in row for row in arr):
        return cnt

    return -1


def flip_col(board, col):
    for i in range(len(board)):
        board[i][col] ^= 1


def flip_row(board, row):
    for i in range(len(board[0])):
        board[row][i] ^= 1