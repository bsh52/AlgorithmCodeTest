def solution(weights):
    answer = 0
    d = {}
    weights.sort()
    for weight in weights:
        aa = float(weight)
        bb = weight * 2 / 3
        cc = weight / 2
        dd = weight * 3 / 4

        if aa in d:
            answer += d[aa]
        if bb in d:
            answer += d[bb]
        if cc in d:
            answer += d[cc]
        if dd in d:
            answer += d[dd]

        d[aa] = d.get(aa, 0) + 1

    return answer