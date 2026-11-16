def solution(n, k, cmd):
    prev = [i - 1 for i in range(n)]
    nxt = [i + 1 for i in range(n)]
    nxt[-1] = -1

    stack = []
    cur = k
    for s in cmd:
        action, *args = s.split()
        match action:
            case "D":
                for _ in range(int(args[0])):
                    cur = nxt[cur]
            case "U":
                for _ in range(int(args[0])):
                    cur = prev[cur]
            case "C":
                stack.append(cur)
                p, q = prev[cur], nxt[cur]
                if p != -1:
                    nxt[p] = q
                if q != -1:
                    prev[q] = p
                cur = p if q == -1 else q
            case "Z":
                restore = stack.pop()
                p, q = prev[restore], nxt[restore]
                if p != -1:
                    nxt[p] = restore
                if q != -1:
                    prev[q] = restore

    answer = ["O"] * n

    for i in stack:
        answer[i] = "X"

    return "".join(answer)