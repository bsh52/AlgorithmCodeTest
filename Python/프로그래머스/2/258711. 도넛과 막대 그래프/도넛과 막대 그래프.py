def solution(edges):
    answer = [0, 0, 0, 0]
    size = max(max(edge) for edge in edges)
    out_e = [0] * (size + 1)
    in_e = [0] * (size + 1)

    for a, b in edges:
        out_e[a] += 1
        in_e[b] += 1

    for i, (v_in, v_out) in enumerate(zip(in_e[1:], out_e[1:]), 1):
        if v_in == 0 and v_out > 1:
            answer[0] = i
        if v_out == 0 and v_in > 0:
            answer[2] += 1
        if v_in > 1 and v_out > 1:
            answer[3] += 1

    answer[1] = out_e[answer[0]] - (answer[2] + answer[3])
    return answer