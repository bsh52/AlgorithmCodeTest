def solution(words):
    answer = 0
    words.sort()

    for i in range(len(words)):
        prev_cnt = 0
        if i != 0:
            prev_cnt = check(words[i], words[i - 1])
        next_cnt = 0
        if i != len(words) - 1:
            next_cnt = check(words[i], words[i + 1])
        answer += max(prev_cnt, next_cnt)
    return answer


def check(word, other):
    length = min(len(word), len(other))
    cnt = 0
    for i in range(length):
        if word[i] != other[i]:
            break
        cnt += 1

    if cnt != len(word):
        return cnt + 1

    return cnt