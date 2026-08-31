def solution(storey):
    answer = 0

    while storey > 0:
        n = storey % 10
        storey //= 10

        if n > 5:
            n = 10 - n
            storey += 1
        elif n == 5:
            if storey % 10 >= 5:
                storey += 1
        answer += n

    return answer