def solution(rows, columns, queries):
    answer = [0] * len(queries)
    matrix = [[i * columns + j + 1 for j in range(columns)] for i in range(rows)]

    for i, query in enumerate(queries):
        answer[i] = rotate(matrix, query)

    return answer


def rotate(matrix, query):
    row_s, row_e, col_s, col_e = query[0] - 1, query[2] - 1, query[1] - 1, query[3] - 1
    tmp = matrix[row_s][col_s]
    min_num = float("INF")

    for i in range(col_s + 1, col_e + 1):
        cur = matrix[row_s][i]
        min_num = min(min_num, min(tmp, cur))
        matrix[row_s][i] = tmp
        tmp = cur

    for i in range(row_s + 1, row_e + 1):
        cur = matrix[i][col_e]
        min_num = min(min_num, min(tmp, cur))
        matrix[i][col_e] = tmp
        tmp = cur

    for i in range(col_e - 1, col_s - 1, -1):
        cur = matrix[row_e][i]
        min_num = min(min_num, min(tmp, cur))
        matrix[row_e][i] = tmp
        tmp = cur

    for i in range(row_e - 1, row_s - 1, -1):
        cur = matrix[i][col_s]
        min_num = min(min_num, min(tmp, cur))
        matrix[i][col_s] = tmp
        tmp = cur

    return min_num