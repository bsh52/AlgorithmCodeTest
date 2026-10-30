def solution(n, t, m, timetable):
    answer = ""
    time_list = []
    first = "09:00"
    start_time = time_to_int(first)
    last_time = time_to_int(first) + (n - 1) * t

    for s in timetable:
        if time_to_int(s) > last_time:
            continue
        time_list.append(time_to_int(s))

    time_list.sort()

    if len(time_list) < m:
        answer = time_to_string(last_time)
    else:
        answer = get_time(start_time, last_time, n, t, m, time_list)

    return answer


def get_time(start_time, last_time, count, gap, max, time_list):
    now = start_time
    while count > 0:
        cnt = 0
        for t in time_list:
            if t <= now:
                cnt += 1
        if cnt >= max:
            if now == last_time:
                return time_to_string(time_list[max - 1] - 1)
            time_list = time_list[max : len(time_list)]
        else:
            time_list = time_list[cnt : len(time_list)]
        now += gap
        count -= 1

    return time_to_string(last_time)


def time_to_int(time):
    split = time.split(":")
    return int(split[0]) * 60 + int(split[1])


def time_to_string(time):
    return str(f"{time//60:02d}:{time%60:02d}")