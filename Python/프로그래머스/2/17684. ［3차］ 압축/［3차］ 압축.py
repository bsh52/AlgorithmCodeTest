def solution(msg):
    answer = []
    d = {}
    for i in range(26):
        d[chr(ord("A") + i)] = i + 1

    idx = 0

    while idx < len(msg):
        key = ""
        while idx < len(msg):
            if key + msg[idx] not in d:
                break
            else:
                key += msg[idx]
            idx += 1
        answer.append(d[key])

        if idx < len(msg):
            d[key + msg[idx]] = len(d) + 1

    return answer