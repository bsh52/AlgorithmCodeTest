def solution(enroll, referral, seller, amount):
    n = len(enroll)
    answer = [0] * n
    d_idx = {}
    for i in range(n):
        d_idx[enroll[i]] = i

    parent = [0] * n
    for i in range(n):
        parent[i] = d_idx.get(referral[i], -1)

    for i in range(len(seller)):
        idx = d_idx.get(seller[i])
        price = amount[i] * 100

        while idx != -1 and price > 0:
            next = price // 10
            answer[idx] += price - next
            price = next
            idx = parent[idx]

    return answer