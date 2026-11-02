def solution(s):
    answer = 0
    pairs = {")": "(", "]": "[", "}": "{"}

    for _ in range(len(s)):
        stack = []

        for c in s:
            if stack and c in pairs and stack[-1] == pairs[c]:
                stack.pop()
            else:
                stack.append(c)

        if not stack:
            answer += 1

        s = s[1:] + s[0]

    return answer