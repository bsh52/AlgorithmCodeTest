def solution(elements):
    st = set()
    n = len(elements)

    for i in range(1, n + 1):
        for _ in range(n):
            total = sum(elements[:i])
            if total not in st:
                st.add(total)
            elements.append(elements.pop(0))

    return len(st)