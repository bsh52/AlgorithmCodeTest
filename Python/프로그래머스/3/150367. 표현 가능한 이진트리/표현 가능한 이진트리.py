def solution(numbers):
    def dfs(tree, left, right, parent):
        if left > right:
            return True

        mid = (left + right) // 2
        cur = tree[mid]

        if parent == "0" and cur == "1":
            return False

        return dfs(tree, left, mid - 1, cur) and dfs(tree, mid + 1, right, cur)

    answer = []

    for number in numbers:
        binary = bin(number)[2:]

        size = 1
        while size < len(binary):
            size = size * 2 + 1

        tree = binary.zfill(size)
        answer.append(int(dfs(tree, 0, size - 1, "1")))

    return answer