def solution(board, skill):
    arr = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)]

    for type, r1, c1, r2, c2, degree in skill:
        damage = -degree if type == 1 else degree
        arr[r1][c1] += damage
        arr[r1][c2 + 1] -= damage
        arr[r2 + 1][c1] -= damage
        arr[r2 + 1][c2 + 1] += damage

    for i in range(len(board)):
        for j in range(1, len(board[0])):
            arr[i][j] = arr[i][j - 1] + arr[i][j]

    for i in range(len(board[0])):
        for j in range(1, len(board)):
            arr[j][i] = arr[j - 1][i] + arr[j][i]

    answer = 0

    for i in range(len(board)):
        for j in range(len(board[0])):
            board[i][j] += arr[i][j]
            if board[i][j] > 0:
                answer += 1

    return answer