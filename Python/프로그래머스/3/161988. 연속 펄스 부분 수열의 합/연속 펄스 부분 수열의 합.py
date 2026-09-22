def solution(sequence):
    answer = 0
    is_positive = True
    sum1, sum2 = 0, 0

    for i in sequence:
        sum1 += i if is_positive else -i
        sum2 += -i if is_positive else i

        sum1 = max(sum1, 0)
        sum2 = max(sum2, 0)

        answer = max(answer, max(sum1, sum2))
        is_positive = not is_positive

    return answer