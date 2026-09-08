def solution(board):
    def is_bingo(c):
        nonlocal board
        for i in range(len(board)):
            r_cnt, c_cnt = 0, 0
            for j in range(len(board[0])):
                if board[i][j] == c:
                    r_cnt += 1
                if board[j][i] == c:
                    c_cnt += 1
            if r_cnt == len(board) or c_cnt == len(board):
                return True

        d_cnt, dd_cnt = 0, 0
        for i in range(len(board)):
            if board[i][i] == c:
                d_cnt += 1
            if board[i][len(board) - 1 - i] == c:
                dd_cnt += 1
        if d_cnt == len(board) or dd_cnt == len(board):
            return True

        return False

    o_cnt, x_cnt = 0, 0
    for row in board:
        for c in row:
            if c == "O":
                o_cnt += 1
            elif c == "X":
                x_cnt += 1

    answer = 0
    if o_cnt == x_cnt:
        if not is_bingo("O"):
            answer = 1
    elif o_cnt == x_cnt + 1:
        if not is_bingo("X"):
            answer = 1

    return answer