def solution(s):
    stack = []
    if s[0] != "(":
        return False

    for c in s:
        if stack and stack[-1] == "(" and c == ")":
            stack.pop()
        else:
            stack.append(c)

    return not stack