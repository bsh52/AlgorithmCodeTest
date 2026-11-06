def solution(board):
    answer = 0
    n = len(board)
    m = len(board[0])

    if n < 2 and m < 2 and board[0][0] != 0:
        return 1

    for i in range(n):
        for j in range(m):
            if board[i][j] == 1 and i > 0 and j > 0:
                board[i][j] = (
                    min(board[i - 1][j - 1], board[i - 1][j], board[i][j - 1]) + 1
                )
            answer = max(answer, board[i][j])

    return answer**2