def solution(play_time, adv_time, logs):
    play_second = to_second(play_time)
    adv_second = to_second(adv_time)
    arr = [0] * (play_second + 1)

    for log in logs:
        s_arr = log.split("-")
        start = to_second(s_arr[0])
        end = to_second(s_arr[1])

        arr[start] += 1
        arr[end] -= 1

    for i in range(1, len(arr)):
        arr[i] += arr[i - 1]
    for i in range(1, len(arr)):
        arr[i] += arr[i - 1]

    idx = 0
    maxi = arr[adv_second - 1]

    for i in range(1, len(arr) - adv_second):
        cur = arr[adv_second - 1 + i] - arr[i - 1]
        if cur > maxi:
            maxi = cur
            idx = i

    return to_time(idx)


def to_second(time):
    s_arr = time.split(":")
    return int(s_arr[0]) * 3600 + int(s_arr[1]) * 60 + int(s_arr[2])


def to_time(second):
    hour = second // 3600
    second %= 3600
    minute = second // 60
    second %= 60
    return str(f"{hour:02d}:{minute:02d}:{second:02d}")