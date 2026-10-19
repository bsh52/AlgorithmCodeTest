def solution(n, bans):
    numbers = sorted((convert_int(ban), ban) for ban in bans)

    for num, _ in numbers:
        if num > n:
            break
        n += 1

    return convert_string(n)


def convert_string(n):
    chars = []

    while n > 0:
        n -= 1
        chars.append(chr(ord("a") + n % 26))
        n //= 26

    return "".join(reversed(chars))


def convert_int(s):
    result = 0

    for i in s:
        result = result * 26 + ord(i) - ord("a") + 1

    return result