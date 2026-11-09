def solution(diffs, times, limit):
    left, right = 1, max(diffs)

    while left < right:
        mid = (left + right) // 2

        total_time = 0
        for i, (diff, cur) in enumerate(zip(diffs, times)):
            prev = times[i - 1] if i > 0 else 0
            total_time += max(0, diff - mid) * (cur + prev) + cur

        if total_time > limit:
            left = mid + 1
        else:
            right = mid

    return left