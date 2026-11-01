def solution(s):
    answer = []
    target = "110"

    for string in s:
        count = 0
        sb = []

        for c in string:
            sb.append(c)
            n = len(sb)
            if n >= 3 and "".join(sb[-3:]) == target:
                del sb[-3:]
                count += 1

        idx = "".join(sb).rfind("0")
        sb[idx + 1 : idx + 1] = list(target * count)
        answer.append("".join(sb))

    return answer