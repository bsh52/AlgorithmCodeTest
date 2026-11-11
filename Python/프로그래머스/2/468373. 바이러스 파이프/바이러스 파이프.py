from collections import defaultdict


def solution(n, infection, edges, k):
    d = defaultdict(list)
    comb = []
    answer = 0

    for edge in edges:
        d[edge[0]].append([edge[1], edge[2]])
        d[edge[1]].append([edge[0], edge[2]])

    def get_comb(max, depth, lst):
        if depth == max:
            comb.append(lst.copy())
            return

        for i in range(1, 4):
            if lst and lst[len(lst) - 1] == i:
                continue
            lst.append(i)
            get_comb(max, depth + 1, lst)
            lst.pop()

    get_comb(k, 0, [])

    def bfs(infection, lst):
        infected = [infection]
        new_i = []

        for i in range(len(lst)):
            t = lst[i]
            j = 0

            while j < len(infected):
                inf = infected[j]

                for edge in d[inf]:
                    if edge[1] == t:
                        if edge[0] not in new_i and edge[0] not in infected:
                            new_i.append(edge[0])

                infected.extend(new_i)
                new_i.clear()

                j += 1

        return len(infected)

    for lst in comb:
        answer = max(answer, bfs(infection, lst))

    return answer