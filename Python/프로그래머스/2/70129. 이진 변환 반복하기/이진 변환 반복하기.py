def solution(s):
    answer = [0, 0]

    while s != "1":
        cnt_one = s.count("1")
        answer[1] += len(s) - cnt_one
        s = str(bin(cnt_one)[2:])
        answer[0] += 1

    return answer