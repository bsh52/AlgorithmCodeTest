def solution(word):
    lst = []
    words = ["A", "E", "I", "O", "U"]

    def dfs(word, depth):
        lst.append(word)

        if depth == 5:
            return

        for s in words:
            dfs(word + s, depth + 1)

    dfs("", 0)
    return lst.index(word)