def solution(genres, plays):
    answer = []
    total_d = {}
    d = {}

    for i in range(len(genres)):
        g, p = genres[i], plays[i]
        total_d[g] = total_d.get(g, 0) + p

        if g not in d:
            d[g] = []

        d[g].append((p, i))

    sorted_total_d = sorted(total_d.items(), key=lambda x: x[1], reverse=True)

    for genre, _ in sorted_total_d:
        sorted_d = sorted(d[genre], key=lambda x: (-x[0], x[1]))
        answer.extend([idx for p, idx in sorted_d[:2]])

    return answer