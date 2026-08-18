def solution(citations):
    answer = 0
    for i in range(1, 10001):
        cnt = 0
        for j in citations:
            if j >= i:
                cnt += 1
        if cnt == 0:
            break
        answer = max(min(i, cnt), answer)

    return answer