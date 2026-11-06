def solution(n):
    arr = []
    hanoi(n, 1, 3, 2, arr)
    return arr


def hanoi(n, _from, _to, via, arr):
    move = [_from, _to]

    if n == 1:
        arr.append(move)
    else:
        hanoi(n - 1, _from, via, _to, arr)
        arr.append(move)
        hanoi(n - 1, via, _to, _from, arr)