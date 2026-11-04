from collections import deque


def solution(board):
    answer = -1
    str_arr = [[c for c in board[i]] for i in range(len(board))]
    visited = [[False] * len(board[0]) for _ in range(len(board))]
    start_x = start_y = end_x = end_y = 0

    for i in range(len(board)):
        for j in range(len(board[0])):
            if str_arr[i][j] == "R":
                start_x = i
                start_y = j
            if str_arr[i][j] == "G":
                end_x = i
                end_y = j

    bfs(start_x, start_y, str_arr, visited)

    if str_arr[end_x][end_y] != "G":
        answer = int(str_arr[end_x][end_y])

    return answer


def bfs(x, y, str_arr, visited):
    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]
    que = deque()
    que.append((x, y))
    visited[x][y] = True
    str_arr[x][y] = "0"

    while que:
        cur = que.popleft()

        for i in range(4):
            cx = cur[0]
            cy = cur[1]

            while True:
                cx += dx[i]
                cy += dy[i]
                if cx >= 0 and cx < len(str_arr) and cy >= 0 and cy < len(str_arr[0]):
                    if "D" == str_arr[cx][cy]:
                        cx -= dx[i]
                        cy -= dy[i]
                        break
                else:
                    cx -= dx[i]
                    cy -= dy[i]
                    break

            if not visited[cx][cy]:
                str_arr[cx][cy] = str(int(str_arr[cur[0]][cur[1]]) + 1)
                visited[cx][cy] = True
                if "G" == str_arr[cx][cy]:
                    return
                que.append((cx, cy))