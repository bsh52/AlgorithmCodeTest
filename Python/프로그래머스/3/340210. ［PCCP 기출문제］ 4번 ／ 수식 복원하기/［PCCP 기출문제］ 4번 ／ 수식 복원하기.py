def solution(expressions):
    known = []
    unknown = []
    max_digit = 0

    for line in expressions:
        a, op, b, _, result = line.split()

        max_digit = max(max_digit, *(int(c) for c in line if c.isdigit()))

        exp = (a, op, b, result)

        if result == "X":
            unknown.append((a, op, b, line))
        else:
            known.append(exp)

    bases = [
        base
        for base in range(max_digit + 1, 10)
        if all(str(calc(a, op, b, base)) == result for a, op, b, result in known)
    ]

    if not bases:
        bases = range(max_digit + 1, 10)

    answer = []

    for a, op, b, line in unknown:
        results = {calc(a, op, b, base) for base in bases}
        result = results.pop() if len(results) == 1 else "?"
        answer.append(line.replace("X", result))

    return answer


def calc(a, op, b, base):
    a = int(a, base)
    b = int(b, base)

    result = a + b if op == "+" else a - b

    return to_base(result, base)


def to_base(num, base):
    if num == 0:
        return "0"

    digits = []

    while num:
        digits.append(str(num % base))
        num //= base

    return "".join(reversed(digits))