def solution(cap, n, deliveries, pickups):
    answer = 0
    d_stack = [[i + 1, v] for i, v in enumerate(deliveries) if v != 0]
    p_stack = [[i + 1, v] for i, v in enumerate(pickups) if v != 0]

    while d_stack or p_stack:
        d = calc(d_stack, cap)
        p = calc(p_stack, cap)

        answer += max(d, p) * 2

    return answer


def calc(stack, cap):
    result = 0
    max = 0

    while stack:
        idx, val = stack.pop()

        if idx > max:
            max = idx

        if val + result > cap:
            val = val + result - cap
            stack.append([idx, val])
            return max

        result += val

    return max