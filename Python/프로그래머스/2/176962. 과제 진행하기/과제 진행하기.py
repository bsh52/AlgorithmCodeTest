def solution(plans):
    answer = []
    stack = []
    subjects = []
    for name, start, left in plans:
        h, m = map(int, start.split(":"))
        start = h * 60 + m
        subjects.append([name, start, int(left)])

    subjects.sort(key=lambda x: x[1])

    now = subjects.pop(0)
    time = now[1]

    while subjects:
        time += now[2]
        next_subject = subjects[0]

        if time > next_subject[1]:
            now[2] = time - next_subject[1]
            stack.append(now)
        else:
            answer.append(now[0])
            if stack:
                now = stack.pop()
                continue
        now = subjects.pop(0)
        time = now[1]

    answer.append(now[0])
    while stack:
        answer.append(stack.pop()[0])

    return answer