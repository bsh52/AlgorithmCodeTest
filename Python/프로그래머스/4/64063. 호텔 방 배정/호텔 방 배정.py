def solution(k, room_number):
    answer = []
    d = {}

    def find_room(n):
        path = []

        while n in d:
            path.append(n)
            n = d[n]

        d[n] = n + 1

        for p in path:
            d[p] = n + 1

        return n

    for num in room_number:
        answer.append(find_room(num))

    return answer