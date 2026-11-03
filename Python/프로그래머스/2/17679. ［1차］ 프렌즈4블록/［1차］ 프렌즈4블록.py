def solution(m, n, board):
    check = [[False] * n for _ in range(m)]
    board_matrix = [list(s) for s in board]

    while True:
        count = check_x(board_matrix)
        check_four(board_matrix, check, m, n)
        change_block(board_matrix, check, m, n)
        drop_block(board_matrix, check, m, n)

        count2 = check_x(board_matrix)
        if count == count2:
            break

    return check_x(board_matrix)


def check_x(board_matrix):
    count = 0
    for row in board_matrix:
        for col in row:
            if col == "-":
                count += 1
    return count


def check_four(board_matrix, check, m, n):
    for i in range(m - 1):
        for j in range(n - 1):
            current = board_matrix[i][j]
            if current != "-" and (
                current == board_matrix[i][j + 1]
                and current == board_matrix[i + 1][j]
                and current == board_matrix[i + 1][j + 1]
            ):
                check[i][j] = True
                check[i + 1][j] = True
                check[i][j + 1] = True
                check[i + 1][j + 1] = True


def change_block(board_matrix, check, m, n):
    for i in range(m):
        for j in range(n):
            if check[i][j]:
                board_matrix[i][j] = "-"


def drop_block(board_matrix, check, m, n):
    for i in range(n):
        for j in range(m - 1, 0, -1):
            current = board_matrix[j][i]
            if current != "-":
                continue
            for k in range(j - 1, -1, -1):
                _next = board_matrix[k][i]
                if _next != "-":
                    board_matrix[j][i] = _next
                    board_matrix[k][i] = current
                    break

    for i in range(len(board_matrix)):
        for j in range(len(board_matrix[i])):
            if board_matrix[i][j] == "-":
                check[i][j] = True
            else:
                check[i][j] = False