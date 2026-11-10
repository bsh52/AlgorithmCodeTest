def solution(relation):
    answer = 0
    col_size = len(relation[0])
    comb = []
    used = []

    def check_relation(relation):
        nonlocal answer

        for lst in comb:
            st = set()
            for i in range(len(relation)):
                sb = []

                for j in lst:
                    sb.append((relation[i][j]))
                st.add("".join(sb))

            if len(st) == len(relation):
                used.append(lst.copy())
                answer += 1

    def dfs(idx, depth, relation, lst):
        if is_used(lst, used):
            return

        if len(lst) == depth:
            comb.append(lst.copy())
            return

        for i in range(idx, len(relation[0])):
            lst.append(i)
            dfs(i + 1, depth, relation, lst)
            del lst[len(lst) - 1]

    def is_used(lst, used):
        for u in used:
            if set(u).issubset(lst):
                return True

        return False

    for i in range(1, col_size + 1):
        comb.clear()
        dfs(0, i, relation, [])
        check_relation(relation)

    return answer