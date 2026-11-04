import heapq


def solution(book_time):
    book_q = book_time[:]
    room_q = []
    heapq.heapify(book_q)
    cur = heapq.heappop(book_q)
    heapq.heappush(room_q, (cur[1], cur[0]))

    while book_q:
        cur = heapq.heappop(book_q)
        nxt = (cur[1], cur[0])
        prv = room_q[0]
        if time_to_int(prv[0]) + 10 <= time_to_int(nxt[1]):
            heapq.heappop(room_q)
            heapq.heappush(room_q, nxt)
        else:
            heapq.heappush(room_q, nxt)

    return len(room_q)


def time_to_int(time):
    split = time.split(":")
    return int(split[0]) * 60 + int(split[1])