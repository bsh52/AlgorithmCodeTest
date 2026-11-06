from itertools import permutations


def solution(expression):
    answer = 0

    lst = []
    num = ""

    for ch in expression:
        if ch in "+-*":
            lst.append(int(num))
            lst.append(ch)
            num = ""
        else:
            num += ch

    lst.append(int(num))

    for operators in permutations("+-*"):
        tmp = lst.copy()

        for op in operators:
            k = 0

            while k < len(tmp):
                if tmp[k] == op:
                    if op == "+":
                        result = tmp[k - 1] + tmp[k + 1]
                    elif op == "-":
                        result = tmp[k - 1] - tmp[k + 1]
                    else:
                        result = tmp[k - 1] * tmp[k + 1]

                    tmp[k - 1 : k + 2] = [result]
                    k = 0
                else:
                    k += 1

        answer = max(answer, abs(tmp[0]))

    return answer