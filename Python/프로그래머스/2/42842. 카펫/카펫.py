def solution(brown, yellow):
    answer = [0] * 2
    sum = brown + yellow
    for i in range(3, sum):
        min = i
        max = sum // min
        if (min - 2) * (max - 2) == yellow:
            answer[0] = max
            answer[1] = min
            break

    return answer