def solution(user_id, banned_id):
    lst = [[] for _ in range(len(banned_id))]

    for i, user in enumerate(user_id):
        for j, ban in enumerate(banned_id):
            if is_match(user, ban):
                lst[j].append(i)

    st = set()
    dfs(0, lst, st, set())
    return len(st)


def dfs(depth, lst, st, tmp):
    if depth == len(lst):
        st.add(frozenset(tmp))
        return

    for user in lst[depth]:
        if user in tmp:
            continue
        tmp.add(user)
        dfs(depth + 1, lst, st, tmp)
        tmp.remove(user)


def is_match(user, ban):
    if len(user) != len(ban):
        return False

    for i in range(len(user)):
        if user[i] != ban[i] and ban[i] != "*":
            return False

    return True