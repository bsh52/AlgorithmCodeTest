from collections import Counter


def solution(points, routes):
    def get_route(route):
        result = []

        for start, end in zip(route, route[1:]):
            x, y = points[start - 1]
            ex, ey = points[end - 1]

            while (x, y) != (ex, ey):
                result.append((x, y))

                if x != ex:
                    x += 1 if x < ex else -1
                else:
                    y += 1 if y < ey else -1

        result.append(tuple(points[route[-1] - 1]))
        return result

    paths = [get_route(route) for route in routes]

    answer = 0

    for t in range(max(map(len, paths))):
        counter = Counter(path[t] for path in paths if t < len(path))
        answer += sum(count >= 2 for count in counter.values())

    return answer