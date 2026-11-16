def solution(lines):
    answer = 0
    logs = []

    for line in lines:
        arr = line.split(" ")
        end = to_millis(arr[1])
        start = end - get_duration(arr[2]) + 1
        logs.append((start, end))

    for i in range(len(logs)):
        base = logs[i][1]
        cnt = 0
        for start, end in logs:
            if is_cycle(base, start, end):
                cnt += 1
        answer = max(answer, cnt)

    return answer


def to_millis(time):
    hms, ms = time.split(".")
    h, m, s = map(int, hms.split(":"))
    return (h * 3600 + m * 60 + s) * 1000 + int(ms)


def get_duration(duration):
    s = duration.replace("s", "")
    sec, *ms = s.split(".")
    return int(sec) * 1000 + int((ms[0] + "000")[:3] if ms else "0")


def is_cycle(base_start, start, end):
    base_end = base_start + 999
    return base_start <= end and base_end >= start