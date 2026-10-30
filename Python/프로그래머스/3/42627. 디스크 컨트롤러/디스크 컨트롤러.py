import heapq

def solution(jobs):
    wait_pq = []
    job_pq = jobs.copy()
    heapq.heapify(job_pq)

    total = 0
    end = 0

    while True:
        if not wait_pq:
            poll = heapq.heappop(job_pq)
            end = poll[0]
            heapq.heappush(wait_pq, (poll[1], poll[0]))
        else:
            while wait_pq:
                cur = heapq.heappop(wait_pq)
                end += cur[0]
                total += end - cur[1]

                size = len(job_pq)
                for _ in range(size):
                    next = job_pq[0]
                    if next != None and next[0] <= end:
                        poll = heapq.heappop(job_pq)
                        heapq.heappush(wait_pq, (poll[1], poll[0]))

        if not job_pq and not wait_pq:
            break

    return total // len(jobs)