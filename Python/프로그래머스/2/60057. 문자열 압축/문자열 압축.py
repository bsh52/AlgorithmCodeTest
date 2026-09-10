def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1):
        length = 0
        j = 0

        while j + i <= len(s):
            count = 1
            next_idx = j + i
            sub_str = s[j : j + i]

            while next_idx + i <= len(s) and sub_str == s[next_idx : next_idx + i]:
                count += 1
                next_idx += i

            if count == 1:
                length += i
            else:
                length += i + len(str(count))

            j = next_idx

        length += len(s) % i
        answer = min(answer, length)

    return answer