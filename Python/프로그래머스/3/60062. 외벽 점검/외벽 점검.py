from itertools import permutations


def solution(n, weak, dist):
    size = len(weak)

    gap = [weak[i + 1] - weak[i] for i in range(size - 1)] + [weak[0] + n - weak[-1]]

    dist.sort(reverse=True)

    perm = (p for r in range(1, len(dist) + 1) for p in permutations(dist[:r]))

    def is_valid(idx, friends):
        cnt = 0

        for d in friends:
            while d >= gap[idx % size]:
                d -= gap[idx % size]
                cnt += 1
                idx += 1
            cnt += 1
            idx += 1

            if cnt >= size:
                return True

        return False

    for friends in perm:
        if any(is_valid(i, friends) for i in range(size)):
            return len(friends)

    return -1