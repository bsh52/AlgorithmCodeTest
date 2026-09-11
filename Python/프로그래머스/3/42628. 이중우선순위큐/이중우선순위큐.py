import heapq


def solution(operations):
    min_q = []
    max_q = []

    for oper in operations:
        order, val = oper.split()
        val = int(val)

        if order == "I":
            heapq.heappush(min_q, val)
            heapq.heappush(max_q, -val)
        elif order == "D":
            if val == 1:
                if max_q:
                    max_val = -heapq.heappop(max_q)
                    min_q.remove(max_val)
            else:
                if min_q:
                    min_val = heapq.heappop(min_q)
                    max_q.remove(-min_val)

    if not min_q:
        return [0, 0]

    return [-heapq.heappop(max_q), heapq.heappop(min_q)]