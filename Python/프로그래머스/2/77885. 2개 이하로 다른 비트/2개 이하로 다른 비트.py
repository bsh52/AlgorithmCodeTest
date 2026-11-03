def solution(numbers):
    answer = [0] * len(numbers)
    for i in range(len(numbers)):
        s = bin(numbers[i])[2:]

        if numbers[i] % 2 == 0:
            answer[i] = numbers[i] + 1
        else:
            idx = s.rfind("0")

            tmp = ""
            if idx == -1:
                tmp = "10" + s[1:]
            else:
                tmp = s[:idx] + "10" + s[idx + 2 :]

            answer[i] = int(tmp, 2)

    return answer