def solution(picks, minerals):
    answer = 0
    count = min(picks[0] + picks[1] + picks[2], len(minerals) // 5 + 1)
    arr = [[0] * 3 for _ in range(count)]
    dp = ip = sp = 0

    for i in range(0, len(minerals), 5):
        if i // 5 == count:
            break

        for j in range(i, i + 5):
            s = minerals[j]
            if s == "diamond":
                dp += 1
                ip += 5
                sp += 25
            elif s == "iron":
                dp += 1
                ip += 1
                sp += 5
            elif s == "stone":
                dp += 1
                ip += 1
                sp += 1
            if j == len(minerals) - 1:
                break

        arr[i // 5][0] = dp
        arr[i // 5][1] = ip
        arr[i // 5][2] = sp

        dp = ip = sp = 0

    arr.sort(key=lambda x: x[2], reverse=True)

    for i in range(count):
        if picks[0] != 0:
            answer += arr[i][0]
            picks[0] -= 1
        elif picks[1] != 0:
            answer += arr[i][1]
            picks[1] -= 1
        else:
            answer += arr[i][2]
            picks[2] -= 1

    return answer