from collections import deque


def solution(game_board, table):
    holes = []
    pieces = []

    get_list(game_board, holes, 0)
    get_list(table, pieces, 1)

    used = [False] * len(pieces)
    answer = 0

    for hole in holes:
        for i, piece in enumerate(pieces):
            if not used[i] and len(hole) == len(piece) and match_piece(hole, piece):
                answer += len(piece)
                used[i] = True
                break

    return answer


def match_piece(hole, piece):
    arr = [p[:] for p in piece]
    for _ in range(4):
        rotate(arr)
        if same_shape(hole, arr):
            return True
    return False


def same_shape(hole, piece):
    hole.sort()
    piece.sort()

    hole_x_min = min(a[0] for a in hole)
    hole_y_min = min(a[1] for a in hole)

    piece_x_min = min(b[0] for b in piece)
    piece_y_min = min(b[1] for b in piece)

    for i in range(len(hole)):
        hole_x = hole[i][0] - hole_x_min
        hole_y = hole[i][1] - hole_y_min

        piece_x = piece[i][0] - piece_x_min
        piece_y = piece[i][1] - piece_y_min

        if hole_x != piece_x or hole_y != piece_y:
            return False

    return True


def rotate(arr):
    for i in range(len(arr)):
        arr[i] = [arr[i][1], -arr[i][0]]


def get_list(target, lst, num):
    n = len(target)
    visited = [[False] * n for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(n):
        for j in range(n):
            if target[i][j] != num or visited[i][j]:
                continue

            block = []
            queue = deque()
            queue.append((i, j))
            visited[i][j] = True

            while queue:
                cur = queue.popleft()
                block.append(cur)
                for k in range(4):
                    nx = cur[0] + dx[k]
                    ny = cur[1] + dy[k]
                    if (
                        nx < 0
                        or nx >= n
                        or ny < 0
                        or ny >= n
                        or visited[nx][ny]
                        or target[nx][ny] != num
                    ):
                        continue
                    queue.append((nx, ny))
                    visited[nx][ny] = True
            lst.append(block)