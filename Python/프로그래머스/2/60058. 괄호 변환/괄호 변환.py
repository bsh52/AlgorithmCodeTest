def solution(p):
    if not p:
        return ""

    u, v = split_balanced(p)

    if is_correct(u):
        return u + solution(v)

    result = "(" + solution(v) + ")"

    for char in u[1:-1]:
        result += ")" if char == "(" else "("

    return result


def split_balanced(p):
    balance = 0

    for i, char in enumerate(p):
        balance += 1 if char == "(" else -1

        if balance == 0:
            return p[: i + 1], p[i + 1 :]


def is_correct(p):
    balance = 0

    for char in p:
        balance += 1 if char == "(" else -1

        if balance < 0:
            return False

    return balance == 0