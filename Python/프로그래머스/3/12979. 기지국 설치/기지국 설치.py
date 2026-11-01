def solution(n, stations, w):
    answer = 0
    ran = w * 2 + 1
    start = 0

    for station in stations:
        answer += (station - 1 - w - start + w * 2) // ran
        start = station + w

    answer += (n - start + w * 2) // ran

    return answer