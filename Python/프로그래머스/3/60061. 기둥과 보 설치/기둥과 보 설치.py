def solution(n, build_frame):
    build = []
    for x, y, a, b in build_frame:
        if b == 1:
            if installable(x, y, a, build):
                build.append([x, y, a])
        else:
            build.remove([x, y, a])
            for x2, y2, a2 in build:
                if not installable(x2, y2, a2, build):
                    build.append([x, y, a])
                    break

    build.sort()
    return build


def installable(x, y, a, build):
    if a == 0:
        return (
            y == 0
            or [x, y, 1] in build
            or [x - 1, y, 1] in build
            or [x, y - 1, 0] in build
        )
    else:
        return (
            [x, y - 1, 0] in build
            or [x + 1, y - 1, 0] in build
            or ([x - 1, y, 1] in build and [x + 1, y, 1] in build)
        )